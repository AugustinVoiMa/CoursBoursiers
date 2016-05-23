package com.javmProd.CoursBoursiers;

import java.awt.Container;

import javax.swing.JFrame;

public class InterfacePrincipale extends Container {
	InterfacePrincipale(){
		super();
		JFrame fen = new JFrame("Cours Boursiers");
		fen.setContentPane(this);
	}
}
