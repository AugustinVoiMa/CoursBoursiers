package com.javmProd.CoursBoursiers;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

public class OptListener implements ActionListener {
	Props p;
	
	OptListener(Props p){
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Menu
		String name = ((Component)arg0.getSource()).getName();
		System.out.println(name);
		if(name.equals("reseauOPT")){
			this.p.showReseauInterface();
		}
		
		// Components
		
		if(name.equals("useProxy")){
			this.p.setAllEnabledFor(((Container)arg0.getSource()),((AbstractButton)arg0.getSource()).isSelected());
		}
	}

}
