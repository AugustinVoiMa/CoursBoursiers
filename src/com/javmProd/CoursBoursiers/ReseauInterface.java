package com.javmProd.CoursBoursiers;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ReseauInterface extends JPanelCustom{
	HashMap<Component,ArrayList<Component>> hash;
	JPanel mainPanel;
	ReseauInterface(OptListener opt){
		super();
		mainPanel = new JPanel();
		
		super.setViewportView(mainPanel);
		
		this.hash = new HashMap<Component,ArrayList<Component>>();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel proxyParam = new JPanel();
		proxyParam.setBorder(new TitledBorder("Paramètres Proxy"));
		proxyParam.setLayout(new BoxLayout(proxyParam,BoxLayout.Y_AXIS));
		
		JCheckBox useProxy = new JCheckBox("Utiliser un Proxy");
		useProxy.setName("useProxy");
		useProxy.setSelected(false);
		useProxy.addItemListener(opt);
		this.hash.put(useProxy,new ArrayList<Component>());
		
		proxyParam.add(useProxy);
		
		JPanel j = new JPanel(new FlowLayout());
		
		JLabel jl = new JLabel("serveur proxy : ");
		
		JTextField jtxt = new JTextField(25);
		jtxt.setEnabled(false);
		
		j.add(jl);
		j.add(jtxt);
		
		JPanel j2 = new JPanel(new FlowLayout());
		
		JLabel jl2 = new JLabel("port proxy : ");
		
		JTextField jtxt2 = new JTextField(4);
		jtxt2.setEnabled(false);
		
		j2.add(jl2);
		j2.add(jtxt2);
		
		this.hash.get(useProxy).add(jl2);
		this.hash.get(useProxy).add(jtxt2);
		
		proxyParam.add(j);
		proxyParam.add(j2);
		
		super.add(proxyParam);
		
	}

	@Override
	public void setAllEnabledFor(Component source, Boolean enable) {
		// TODO Auto-generated method stub
		for(Component c : this.hash.get(source)){
			c.setEnabled(enable);
		}
	}
}
