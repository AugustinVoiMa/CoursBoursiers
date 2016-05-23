package com.javmProd.CoursBoursiers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InterfacePrincipale extends Container implements Appellant{
	InterfacePrincipale(){
		super();
		super.setLayout(new BorderLayout());
		
		JFrame fen = new JFrame("Cours Boursiers");
		
		JMenuBar menu = new JMenuBar();
		menu.getSize().height = 15;
		
		JMenu fichiers = new JMenu("Fichiers");
		fichiers.setText("Fichiers");

		
		MenuListener buttonlistener = new MenuListener(this);
		
		JMenuItem reglages = new JMenuItem("Réglages");
		reglages.setName("Reglages");
		reglages.addActionListener(buttonlistener);
		fichiers.add(reglages);
		
		menu.add(fichiers);
		
		fen.setMinimumSize(new Dimension(200,100));
		
		fen.setJMenuBar(menu);
		fen.setContentPane(this);
		
		fen.setVisible(true);
	}

	@Override
	public void launchView(Vue v) {
		// TODO Auto-generated method stub
		v.show();
		
	}
}
