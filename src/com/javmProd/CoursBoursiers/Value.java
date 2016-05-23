package com.javmProd.CoursBoursiers;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Value {
	@XmlElement(name="Date")
    @XmlSchemaType(name="date")
    private Date date;

    @XmlElement(name="Open")
    private double open;

    @XmlElement(name="High")
    private double high;

    @XmlElement(name="Low")
    private double low;

    @XmlElement(name="Close")
    private double close;

    @XmlElement(name="Volume")
    private long volume;

    @XmlElement(name="Adj_Close")
    private double adjClose;
    
    public Date getDate(){
    	return this.date;
    }
    public Double getOpen(){
    	return this.open;
    }
    public Double getHigh(){
    	return this.high;
    }
    public Double getLow(){
    	return this.low;
    }
    public Double getClose(){
    	return this.close;
    }
    
    public Long getVolume(){
    	return this.volume;
    }
    public Double getAdj_Close(){
    	return this.adjClose;
    }
    
    public Chandelle toChandelle(){
    	return new Chandelle(this);
    }
    
    public String toString(){
    	return this.open+"->"+this.close+"|++="+this.high+",--="+this.low+"|V="+this.volume;
    }
	public boolean between(Date xmin, Date xmax) {
		return this.date.getTime() >= xmin.getTime() && this.date.getTime()<=xmax.getTime(); 
	}
	public boolean plusPetitMin(Value v2){
		return this.getLow() < v2.getLow();
	}
	public boolean plusGrandMax(Value v2){
		return this.getHigh() > v2.getHigh();
	}
}
