package com.javmProd.CoursBoursiers;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;

public class OptListener implements ActionListener, ItemListener {
	Props p;
	
	OptListener(Props p){
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Menu
		String name = ((Component)arg0.getSource()).getName();
		if(name.equals("reseauOPT")){
			this.p.show(Props.RESEAU_OPTIONS);
		}
		else if(name.equals("savePreferences")){
			this.p.save();
		}
		
		// Components
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		String name = ((Component)arg0.getSource()).getName();

		if(name.equals("useProxy")){
			this.p.setAllEnabledFor(((Container)arg0.getSource()),((AbstractButton)arg0.getSource()).isSelected());
		}
	}

}
