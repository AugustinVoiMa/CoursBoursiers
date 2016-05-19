package com.javmProd.CoursBoursiers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AxisRule extends JPanel {
	public static final int VERTICAL = 1;
	public static final int HORIZONTAL = 2;
	private int mode;
	AxisRule(int mode){
		this.mode = mode;
	}
	public void setMode(int mode){
		this.mode=mode;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		int w = (this.mode==AxisRule.HORIZONTAL) ? this.getParent().getWidth() : 28;
		int h = (this.mode==AxisRule.VERTICAL) ? this.getParent().getHeight() : 28;
		int y = this.getParent().getHeight()-1-h;
		this.setBounds(0,y,w,h);
		this.setBackground(Color.gray);
	}
}
