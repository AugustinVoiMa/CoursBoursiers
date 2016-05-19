package com.javmProd.CoursBoursiers;

import java.io.IOException;
import java.util.GregorianCalendar;

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
			new Graphe(sy);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
