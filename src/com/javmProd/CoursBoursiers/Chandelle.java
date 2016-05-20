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
	}
	public int getHeight(){
		int res = 0;
		try{
			res =((int)((this.gbounds.calcY(this.value.getHigh())-this.gbounds.calcY(this.value.getLow()))));
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
			// Extremums jour de marché
		
			int cX = ((int)(width/2));
			
			graphic.setColor(Color.gray);
			graphic.fillRect(cX,0,GraphBounds.EXTREMUMS__GWIDTH,this.height);
			
			// rectangle ouverture/fermeture du marché
			int height2 = ((int)((this.gbounds.calcY(this.value.getClose())-this.gbounds.calcY(this.value.getOpen()))));
			if(height2<0){
				height2=-height2;
			}
				
			if(this.value.getOpen()>this.value.getClose()){ // Décroissant
				graphic.setColor(Color.red);
			}
			else{ //Croissant
				graphic.setColor(Color.green);
			}

			// La moitié de la différence de hauteur entre le rectangle et la ligne d'extrema
			// donne la marge en y pour positionner le rectangle
			int y2 = ((int)((height-height2)/2.)); 
			graphic.fillRect(0, y2, this.width , height2);
			
		}catch(OutOfGraphException e ){
			e.printStackTrace();
			System.exit(-1);

		}
	}

}
