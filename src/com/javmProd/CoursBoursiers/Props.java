package com.javmProd.CoursBoursiers;

import java.awt.CardLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Props extends Container implements Vue {
	public JFrame fen;
	private JPanel menuPane;
	private JPanel optionsPane;
	private JScrollPane scrollMenuPane;
	private JScrollPane scrollOptionsPane;
	private JSplitPane splitPane;
	private OptListener opt;
	private JPanelCustom visiblePane ;
	
	public static String RESEAU_OPTIONS = "reseau";
	
	Props(){
		super();
		
	}
	public void switchInterface(JPanel interf){
		
	}
	public void show(){	
		
		Dimension d = new Dimension(500,300);
		
		opt = new OptListener(this);
		
		
		optionsPane = new JPanel(new CardLayout());
		optionsPane.setBackground(Color.LIGHT_GRAY);
		
		visiblePane = new ReseauInterface(opt);
		optionsPane.add(visiblePane, RESEAU_OPTIONS);
		
		menuPane = new JPanel();
		menuPane.setLayout(new BoxLayout(menuPane,BoxLayout.PAGE_AXIS));
		menuPane.setBackground(Color.WHITE);
		
		addNetworkSettings();
		
		scrollMenuPane = new JScrollPane(menuPane);
		scrollMenuPane.setViewportView(menuPane);
		scrollMenuPane.setBackground(Color.white);
		scrollMenuPane.setBorder(new EmptyBorder(15,15,15,15));
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setSize(d);
		splitPane.setDividerSize(2);
		splitPane.setRightComponent(optionsPane);
		splitPane.setLeftComponent(scrollMenuPane);
		splitPane.setDividerLocation(0.2);
		
		
		this.add(splitPane);
		
		
		this.show(this.RESEAU_OPTIONS);
		
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
		this.menuPane.add(reseau);
	}

	public void setAllEnabledFor(Container component,Boolean is_enabled) {
		this.visiblePane.setAllEnabledFor(component, is_enabled);

	}
	public void show(String interfaceToShow){
		((CardLayout)optionsPane.getLayout()).show(optionsPane,interfaceToShow);

	}
}
