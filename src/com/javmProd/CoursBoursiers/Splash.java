package com.javmProd.CoursBoursiers;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Splash extends Container{
	JFrame fen;
	JLabel image;
	Splash(){
		super();
		fen = new JFrame();
		fen.setContentPane(this);
		image = new JLabel(new ImageIcon("images/splash01.jpg"));
		this.add(image);
		
		fen.setVisible(true);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}