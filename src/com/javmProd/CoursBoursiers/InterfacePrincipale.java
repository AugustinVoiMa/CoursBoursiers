package com.javmProd.CoursBoursiers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.bind.JAXBException;

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
		
		IntPrincActions act = new IntPrincActions(this);
		
		JButton launchGraphe = new JButton("Afficher le graphe");
		launchGraphe.setName("launchG");
		launchGraphe.addActionListener(act);
		
		this.add(launchGraphe);
		
		fen.setMinimumSize(new Dimension(200,100));
		
		fen.setJMenuBar(menu);
		fen.setContentPane(this);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
	}

	@Override
	public void launchView(Vue v) {
		// TODO Auto-generated method stub
		v.show();
		
	}
	
	public void launchGraphe(String symbole){
		try {
			HistoriqueCoursAction sy = new HistoriqueCoursAction(symbole,new GregorianCalendar(2015,04,10), new GregorianCalendar());
			System.out.println("HistoriqueCoursAction OK");
			sy.updateData();
			System.out.println("HistoriqueCoursAction.updateData() OK");
			JFrame gr = new JFrame("Cours de AAPL");
			gr.setSize(600, 400);
			Graphe g = new Graphe(sy);
			g.setSize(gr.getSize());
			gr.getContentPane().add(g);
			gr.setVisible(true);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
