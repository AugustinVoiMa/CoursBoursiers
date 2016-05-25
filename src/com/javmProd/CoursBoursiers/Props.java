package com.javmProd.CoursBoursiers;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.prefs.Preferences;

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
	private Preferences prefs;
	
	public static String RESEAU_OPTIONS = "reseau";
	
	Props(){
		super();
		prefs = Preferences.userNodeForPackage(com.javmProd.CoursBoursiers.Props.class);
		opt = new OptListener(this);

		
	}
	public void switchInterface(JPanel interf){
		
	}
	public void show(){	
		fen = new JFrame("Réglages");
		fen.setSize(new Dimension(700,300));
		fen.setContentPane(this);
		
		Dimension innerd = new Dimension(fen.getSize().width-10,fen.getSize().height-10);
		
		Dimension vpd = new Dimension((int)(fen.getSize().getWidth()*0.8),(int)fen.getSize().getHeight());
		
		optionsPane = new JPanel(new CardLayout());
		optionsPane.setBackground(Color.LIGHT_GRAY);
		optionsPane.setSize(vpd);
		visiblePane = new ReseauInterface(opt,innerd,prefs);
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
		splitPane.setSize(innerd);
		splitPane.setDividerSize(2);
		splitPane.setRightComponent(optionsPane);
		splitPane.setLeftComponent(scrollMenuPane);
		splitPane.setDividerLocation(0.2);
		
		
		this.add(splitPane);
		
		
		this.show(this.RESEAU_OPTIONS);
		
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
	public void save() {
		// TODO Auto-generated method stub
		this.visiblePane.save();
	}
}
