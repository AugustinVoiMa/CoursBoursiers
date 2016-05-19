package com.javmProd.CoursBoursiers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Chandelle extends JPanel {
	Value value;
	GraphBounds gbounds;
	int width, height, x, y;
	public Chandelle(Value v) {
		this.value = v;
	}
	public void setBounds(GraphBounds gbounds, int x, int y){
		this.gbounds = gbounds;
		this.width = ((int)gbounds.getCandelWidth())+1;
		this.height = this.getHeight();
		this.y = y;
		this.x = x;
		super.setBounds(x,y,this.width,this.getParent().getSize().height);
		System.out.println("width = " + this.width +"\nheight = "+this.getHeight()+"\nx = "+x+"\ny = "+y);
	}
	public int getHeight(){
		int res = 0;
		try{
			res =((int)(this.gbounds.calcY(this.value.getLow())-this.gbounds.calcY(this.value.getHigh())));
			if (res < 0)
				res = -res;
		}catch(OutOfGraphException | NullPointerException e){
			e.printStackTrace();
		}
		return res;
	}
	public void paint(Graphics graphic){
		super.paint(graphic);
		super.setBackground(Color.white);
		try{
			// Extremums
		
			int cX = ((int)(width/2));
			
			graphic.setColor(Color.gray);
			graphic.fillRect(cX,0,GraphBounds.EXTREMUMS__GWIDTH,this.height);
			
			// Debut/fin

			int height2 = ((int)(this.gbounds.calcY(this.value.getClose())-this.gbounds.calcY(this.value.getOpen())));
			if(height2<0){
				height2=-height2;
			}
				
			if(this.value.getOpen()>this.value.getClose()){ // Décroissant
				graphic.setColor(Color.red);
				//System.out.println("Rouge");
			}
			else{ //Croissant
				graphic.setColor(Color.green);
				//System.out.println("Vert");
			}

			//System.out.println("x="+x+"\ny="+y+"\nw="+this.gbounds.getCandelWidth().intValue()+"\nh="+height);
			int y2 = ((int)((height-height2)/2.));
			System.out.println("rectangle y2 = "+y2);
			graphic.fillRect(0, y2, this.width , height2);
			
		}catch(OutOfGraphException e ){
			e.printStackTrace();
			System.exit(-1);

		}
	}

}
