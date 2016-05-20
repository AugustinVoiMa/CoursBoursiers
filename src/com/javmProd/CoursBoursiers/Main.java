package com.javmProd.CoursBoursiers;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.xml.bind.JAXBException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			HistoriqueCoursAction sy = new HistoriqueCoursAction("AAPL",new GregorianCalendar(2015,04,10), new GregorianCalendar());
			sy.updateData();
			JFrame fen = new JFrame("Cours de AAPL");
			fen.setSize(600, 400);
			Graphe g = new Graphe(sy);
			g.setSize(fen.getSize());
			fen.getContentPane().add(g);
			fen.setVisible(true);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
