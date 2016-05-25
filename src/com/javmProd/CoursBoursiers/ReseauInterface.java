package com.javmProd.CoursBoursiers;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.prefs.Preferences;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

public class ReseauInterface extends JPanelCustom{
	HashMap<Component,ArrayList<Component>> hash;
	JPanel mainPanel;
	Preferences prefs;
	private JCheckBox useProxy;
	private JComponent proxyParam;
	private JLabel jl;
	private JTextField jtxt;
	private JLabel jl2;
	private JTextField jtxt2;
	private JLabel etat;
	ReseauInterface(OptListener opt,Dimension d,Preferences p){
		super();
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(d);

		JPanel body = new JPanel();
		this.prefs=p;
		
		super.add(mainPanel);
		//super.setViewportView(mainPanel);
		this.hash = new HashMap<Component,ArrayList<Component>>();
		
		
		proxyParam = new JPanel();
		proxyParam.setBorder(new TitledBorder("Paramètres Proxy"));
		proxyParam.setLayout(new BoxLayout(proxyParam,BoxLayout.Y_AXIS));
		
		useProxy = new JCheckBox("Utiliser un Proxy");
		useProxy.setName("useProxy");
		useProxy.setSelected((prefs.get("useProxy", "false").equals("true")));
		useProxy.addItemListener(opt);
		this.hash.put(useProxy,new ArrayList<Component>());
		
		proxyParam.add(useProxy);
		
		proxyParam.add(new JSeparator(JSeparator.HORIZONTAL));
		
		//JPanel j = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//j.setEnabled(false);
		jl = new JLabel("serveur proxy : ");
		
		jtxt = new JTextField(prefs.get("proxyServer", ""),25);
		jtxt.setEnabled(useProxy.isSelected());
		
		proxyParam.add(jl);
		proxyParam.add(jtxt);
		this.hash.get(useProxy).add(jl);
		this.hash.get(useProxy).add(jtxt);
		
		//JPanel j2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//j.setEnabled(false);
		jl2 = new JLabel("port proxy : ");
		
		jtxt2 = new JTextField(prefs.get("proxyServerPort",""),4);
		jtxt2.setEnabled(useProxy.isSelected());
		
		proxyParam.add(jl2);
		proxyParam.add(jtxt2);
		
		this.hash.get(useProxy).add(jl2);
		this.hash.get(useProxy).add(jtxt2);
		
		//proxyParam.add(j);
		//proxyParam.add(j2);
		
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.setName("savePreferences");
		enregistrer.addActionListener(opt);
		
		body.add(proxyParam);
		body.add(enregistrer);
		
		mainPanel.add(body,BorderLayout.CENTER);
		
		etat = new JLabel("pas de modifications");
		mainPanel.add(etat,BorderLayout.SOUTH);
		
	}

	@Override
	public void setAllEnabledFor(Component source, Boolean enable) {
		// TODO Auto-generated method stub
		for(Component c : this.hash.get(source)){
			c.setEnabled(enable);
		}
	}
	@Override
	public void save() {
		// TODO Auto-generated method stub
		prefs.put("useProxy",useProxy.isSelected() ? "true" : "false");
		prefs.put("proxyServer", jtxt.getText());
		prefs.put("proxyServerPort", jtxt2.getText());
	}
}
