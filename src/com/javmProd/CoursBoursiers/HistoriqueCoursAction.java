package com.javmProd.CoursBoursiers;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="query")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoriqueCoursAction implements Iterable<Value>{
	private String symbol;
	private GregorianCalendar startDate, endDate;
	@XmlElementWrapper(name="results")
    @XmlElement(name="quote")
    private ArrayList<Value> Values;
	public HistoriqueCoursAction(){
		
	}
	public HistoriqueCoursAction(String symbol,GregorianCalendar StartDate, GregorianCalendar EndDate){
		this.symbol = symbol;
		this.startDate=StartDate;
		this.endDate=EndDate;
	}
	public String getSymbol(){
		return symbol;
	}

	public void updateData() throws SocketTimeoutException, IOException, JAXBException {
		JAXBContext jc = JAXBContext.newInstance(HistoriqueCoursAction.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    String link = "https://query.yahooapis.com/v1/public/yql?" +
	    		"q=select%20*%20" +
	    		"from%20yahoo.finance.historicaldata%20" +
	    		"where%20symbol='"+this.symbol+"'%20" +
	    				"and%20startDate='"+format1.format(this.startDate.getTime()).toString()+"'%20" +
	    				"and%20endDate='"+format1.format(this.endDate.getTime()).toString()+"'" +
	    		"&diagnostics=true&env=store://datatables.org/alltableswithkeys";
	    System.out.println(link);
	   
	    Proxy p;
	    //p=Proxy.NO_PROXY;
	    p = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("194.167.30.76",3128));
	    
	    // http://wwwcache.univ-orleans.fr:3128/
	    Authenticator.setDefault(new Authenticator() {
 
	        public PasswordAuthentication getPasswordAuthentication() {
	            return (new PasswordAuthentication("o2150534",
	                    "094ACB8d".toCharArray()));
	        }
	    });
	    
	    URL url = new URL(link);
	    System.out.println("URL created");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection(p);
	    System.out.println("Connection created");
	    System.out.println("Proxy? " + conn.usingProxy());
	    conn.connect();
	    System.out.println("Connection established");
	    InputStream xmlStream = conn.getInputStream();
	    System.out.println("InputStream created");
	    HistoriqueCoursAction stock = (HistoriqueCoursAction) unmarshaller.unmarshal(xmlStream);
        xmlStream.close();
        conn.disconnect();
        this.Values = stock.Values;
        Collections.sort(this.Values,new CompareValues(CompareValues.ByX));
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.marshal(this, System.out);
    }
	public Iterator<Value> iterator(){
		return this.Values.listIterator();
	}
	public Value get(int i){
		return this.Values.get(i);
	}
	
	public Value getFirstVal(){
		return this.get(0);
	}
	public Value getLastVal(){
		return this.get(this.Values.size()-1);
	}
	public Value getMinOfVals(){
		Value res = Collections.max(this.Values,new CompareValues(CompareValues.MIN));
		//System.out.println("MinOfVals="+res.getLow());
		return res;
	}
	public Value getMaxOfVals(){
		Value res = Collections.max(this.Values,new CompareValues(CompareValues.MAX));
		//System.out.println("MaxOfVals="+res.getHigh());
		return res;
	}
	public Integer size(){
		return this.Values.size();
	}
	public Double getSeqMin(Double xmin, Double xmax) {
		Value min = null;
		for(Value v : this.Values){
			if (min==null || (v.between(xmin,xmax) && v.plusPetitMin(min))){
				min=v;
			}
		}
		return min.getLow();
	}
	public Double getSeqMax(Double xmin, Double xmax) {
		Value max = null;
		for(Value v : this.Values){
			if (max==null || (v.between(xmin,xmax) && v.plusPetitMin(max))){
				max=v;
			}
		}
		return max.getLow();
	}
}
