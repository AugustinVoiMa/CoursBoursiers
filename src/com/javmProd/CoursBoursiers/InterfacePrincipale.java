package com.javmProd.CoursBoursiers;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InterfacePrincipale extends Container implements Appellant{
	InterfacePrincipale(){
		super();
		JFrame fen = new JFrame("Cours Boursiers");
		fen.setContentPane(this);
		JMenuBar menu = new JMenuBar();
		this.add(menu);
		
		JMenuItem fichiers = new JMenuItem("Fichiers");
		menu.add(fichiers);
		
		ButtonL buttonlistener = new ButtonL(this);
		
		JButton reglages = new JButton("Réglages");
		fichiers.add(reglages);
		reglages.setName("Reglages");
		reglages.addActionListener(buttonlistener);
		
		fen.repaint();
		fen.setVisible(true);
	}

	@Override
	public void launchView(Vue v) {
		// TODO Auto-generated method stub
		v.show();
		
	}
}
