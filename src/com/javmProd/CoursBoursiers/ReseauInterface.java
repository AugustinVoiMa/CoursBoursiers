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
	ReseauInterface(OptListener opt){
		this.hash = new HashMap<Component,ArrayList<Component>>();
		this.setLayout(new FlowLayout());
		
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
		
		this.hash.get(useProxy).add(jl);
		this.hash.get(useProxy).add(jtxt);
		
		proxyParam.add(j);
		
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
