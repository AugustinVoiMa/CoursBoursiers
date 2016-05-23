package com.javmProd.CoursBoursiers;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;

import javax.swing.JPanel;

public class GraphBounds {
	public Date xmin,xmax;
	public Double ymin, ymax, xmind, xmaxd;
	private Double width,height;
	private Double candelWidth, candelHeight;
	private Integer nbCandels;
	private HistoriqueCoursAction h;
	public final static Integer EXTREMUMS__GWIDTH = 2;
	Graphe gr;
	
	public GraphBounds(HistoriqueCoursAction cours,Graphe gr){
		this.h = cours;
		this.gr=gr;
		
		this.candelHeight = 6.;
		this.candelWidth = 6.;		
		
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
		
		
		gr.getFeuille().setPreferredSize(new Dimension((int)(this.nbCandels*this.candelWidth*2),(int)(this.height*this.candelHeight)));
	}
	
	/*
	 * 	FenHeight = Height*CandelHeight
	 * 			CandelHeight = FenHeight/Height
	 * 
	 * 	FenWidth = nbCandels * candelWidth * 2;
	 * 			candelWidth = FenWidth/(nbCandels*2)
	 */
	
	
	public double getCandelWidth(){
		return this.candelWidth;
	}	
	public double getCandelHeight(){
		return this.candelHeight;
	}
	
	public double calcY(Double y) throws OutOfGraphException{
		//Renvoie la coordonnée en Y de la chandelle
		
		Double res = (this.height-(y-this.ymin)) * this.candelHeight;
		
		if (res < -(this.candelHeight/2.) || res > this.height*this.candelHeight){
			throw new OutOfGraphException("y: "+res+" is not in [ "+ymin+" ; "+ymax+" ]");
		}
		return res;
	}
	
	
	/*
	 * 
	 * 	Utiliser Valeur.isVisible() pour obtenir les dimensions des chandelles visibles dans le viewport?????
	 * 
	 */
	
	/*public void autoZoom(){
		Dimension dVisible = gr.getViewport().getExtentSize();
		double max = this.h.getSeqMax(this.getfeuilleXmin(),this.getfeuilleXmax());
		double min= this.h.getSeqMin(this.getfeuilleXmin(),this.getfeuilleXmax());
		double height = (max-min);
		this.candelHeight = dVisible.getHeight()/height;
	}

	private Double getfeuilleXmax() {
		Rectangle dVisible = gr.getViewport().getViewRect();
		double xmax = dVisible.getMaxX();
		return xmax;
	}

	private Double getfeuilleXmin() {
		Rectangle dVisible = gr.getViewport().getViewRect();
		double xmax = dVisible.getMaxX();
		return null;
	}*/
	
	
}
