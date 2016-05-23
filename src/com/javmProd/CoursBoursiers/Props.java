package com.javmProd.CoursBoursiers;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Props extends Container implements Vue {
	JFrame fen;
	private JPanel menuPane;
	private JPanel optionsPane;
	private JScrollPane scrollMenuPane;
	private JScrollPane scrollOptionsPane;
	
	Props(){
		super();
		JFrame fen = new JFrame("Réglages");
		fen.setContentPane(this);
		menuPane = new JPanel();
		optionsPane = new JPanel();
		
		Dimension d = new Dimension(500,300);
		
		scrollMenuPane = new JScrollPane(menuPane);
		scrollMenuPane.setViewportView(menuPane);
		
		scrollOptionsPane = new JScrollPane(optionsPane);
		scrollOptionsPane.setViewportView(optionsPane);
	}
	
	@Override
	public void show(){	
		fen.setVisible(true);
	}
}
