package com.javmProd.CoursBoursiers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntPrincActions implements ActionListener {
	InterfacePrincipale iP;
	IntPrincActions(InterfacePrincipale iP){
		this.iP=iP;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String name = ((Component)arg0.getSource()).getName();
		if(name.equals("launchG"))
			this.iP.launchGraphe("AAPL");
	}

}
