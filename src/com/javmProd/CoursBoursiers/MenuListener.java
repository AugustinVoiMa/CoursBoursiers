package com.javmProd.CoursBoursiers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
	Appellant a;
	MenuListener(Appellant a){
		this.a = a;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = ((Component)arg0.getSource()).getName();
		if(name.equals("reglages")){
			this.a.launchView(new Props());
		}
	}

}
