package com.javmProd.CoursBoursiers;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JPanel;

public class GraphBounds {
	public Date xmin,xmax;
	public Double ymin, ymax, xmind, xmaxd;
	private Double width,height;
	private Double candelWidth, candelHeight;
	private Integer nbCandels;
	public final static Integer EXTREMUMS__GWIDTH = 2;
	
	public GraphBounds(HistoriqueCoursAction cours,JPanel feuille){
		this.candelHeight = 11.;
		this.candelWidth = 10.;		
		
		this.xmin=cours.getFirstVal().getDate();
		this.xmax=cours.getLastVal().getDate();
		
		this.xmind = (double)xmin.getTime();
		this.xmaxd=(double)xmax.getTime();
		
		
		this.ymin = cours.getMinOfVals().getLow();
		this.ymax = cours.getMaxOfVals().getHigh();
		
		this.width = (this.xmaxd-this.xmind);
		this.height = (this.ymax-this.ymin);
		
		//this.candelWidth  = (widthT)/((double)cours.size());
		//this.candelHeight = ((double)heighT)/(this.height);
		
		this.nbCandels=(int)(cours.size()+2);
		feuille.setPreferredSize(new Dimension((int)(this.nbCandels*this.candelWidth),(int)(this.height*this.candelHeight)));
	}
	
	public double getCandelWidth(){
		return this.candelWidth;
	}	
	public double getCandelHeight(){
		return this.candelHeight;
	}
	
	public double calcY(Double y) throws OutOfGraphException{
		//Renvoie la coordonnée en Y de la chandelle
		
		Double res = (y-this.ymin) * this.candelHeight;
		
		if (res < -(this.candelHeight/2.) || res > this.height*this.candelHeight){
			throw new OutOfGraphException("y: "+res+" is not in [ "+ymin+" ; "+ymax+" ]");
		}
		//System.out.println("calcY = "+res);
		return res;
	}
	
	/*
	 * à venir...
	 * 
	public void autoZoomY(){
		
	}
	public Double getZoomX(){
		return this.candelWidth;
	}
	public Double getZoomY(){
		return this.candelHeight;
	}
	public void setZoomX(Double zoom){
		this.candelWidth = zoom;
	}
	public void setZoomY(Double zoom){
		this.candelHeight = zoom;
	}
	public void incZoom(Date cursor){
		try {
			this.incZoom(1.);
		} catch (InvalidZoomException e) {
			e.printStackTrace();
		}
	}
	public void incZoom(Double i) throws InvalidZoomException{
		this.candelWidth += i;
		if (this.candelWidth <= 0){
			this.candelWidth -= i;
			throw new InvalidZoomException();
		}
		this.autoZoomY();
	}
	
	*/
	
	
	/*
	 * Inutile...
	 
	public double calcX(Date d) throws OutOfGraphException{
		//Renvoie la coordonnée en X de la chandelle
		Double res = (double) ((d.getTime()-xmind)/this.width)*this.candelWidth;
		
		//System.out.println("d.getTime() = "+d.getTime()+"\n(d.getTime()-xmind) = "+(d.getTime()-xmind)+"\nthis.candelWidth = "+this.candelWidth + "\ncalcX = "+res);

		if (res < 0.-(this.candelWidth/2.) || res > this.width*this.candelWidth)
			throw new OutOfGraphException("x: "+d.getTime()+" is not in [ "+xmind+" ; "+xmaxd+" ]");
		
		return res;		
	}
	
	*/
	
	
	
}
