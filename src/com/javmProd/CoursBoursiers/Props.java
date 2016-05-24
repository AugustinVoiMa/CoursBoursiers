package com.javmProd.CoursBoursiers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Props extends Container implements Vue {
	public JFrame fen;
	private JPanelCustom currInterface;
	private JPanel optionsPane;
	private JScrollPane scrollMenuPane;
	private JScrollPane scrollOptionsPane;
	private JSplitPane splitPane;
	private OptListener opt;
	Props(){
		super();
		
	}
	public void switchInterface(JPanel interf){
		
	}
	public void show(){	
		
		Dimension d = new Dimension(500,300);
		
		opt = new OptListener(this);
		
		currInterface = new ReseauInterface(opt);
		currInterface.setBackground(Color.WHITE);
		
		
		optionsPane = new JPanel();
		optionsPane.setBackground(Color.LIGHT_GRAY);
		
		scrollMenuPane = new JScrollPane(currInterface);
		scrollMenuPane.setViewportView(currInterface);
		
		
		scrollOptionsPane = new JScrollPane(optionsPane);
		scrollOptionsPane.setViewportView(optionsPane);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setSize(d);
		splitPane.setDividerSize(2);
		splitPane.setRightComponent(scrollOptionsPane);
		splitPane.setLeftComponent(scrollMenuPane);
		
		
		this.add(splitPane);
		
		addNetworkSettings();
		
		fen = new JFrame("Réglages");
		fen.setSize(d);
		fen.setContentPane(this);
		fen.setVisible(true);
	}
	
	
	private void addNetworkSettings(){
		JButton reseau= new JButton("Réseau");
		reseau.setName("reseauOPT");
		reseau.setBorder(null);
		reseau.setBackground(null);
		reseau.addActionListener(this.opt);
		this.currInterface.add(reseau);
	}
	public void showReseauInterface(){
		this.currInterface = new ReseauInterface(this.opt);		
		this.fen.setVisible(true);
	}
	public void setAllEnabledFor(Container component,Boolean is_enabled) {
		this.currInterface.setAllEnabledFor(component, is_enabled);
		
	}
}
