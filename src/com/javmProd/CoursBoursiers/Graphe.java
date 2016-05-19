package com.javmProd.CoursBoursiers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Graphe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Graphe(HistoriqueCoursAction symbol){
		super("Cours de "+symbol.getSymbol());
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(new Dimension(900, 500));

		
		
		JPanel feuille = new JPanel(null);
		feuille.setBackground(Color.white);
		
		JPanel panelGraph = new JPanel(new BorderLayout());
		panelGraph.add(feuille,BorderLayout.CENTER);
		//panelGraph.add(new AxisRule(AxisRule.HORIZONTAL), BorderLayout.SOUTH);
		
		JScrollPane panelGeneral= new JScrollPane();
		panelGeneral.setViewportView(panelGraph);
		panelGeneral.setViewportBorder(new LineBorder(Color.BLACK));
		panelGeneral.setHorizontalScrollBar(panelGeneral.createHorizontalScrollBar());
		panelGeneral.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelGeneral.setVerticalScrollBar(panelGeneral.createVerticalScrollBar());
		panelGeneral.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelGeneral.setBackground(Color.black);
		
		
		GraphBounds gbounds = new GraphBounds(symbol,feuille);
		
		Chandelle ch = null;
		System.out.println(symbol.size()+" loops");
		int i = 1;
		for(Value v : symbol){
			try{
				ch= v.toChandelle();
				
				feuille.add(ch);
				
				int x = (int)(i++*(gbounds.getCandelWidth()+2));
				int y = (int)gbounds.calcY(v.getHigh());
								
				ch.setBounds(gbounds,x,y);
				ch.repaint();
				
			}catch (OutOfGraphException e){
				e.printStackTrace();
			}
		}
		this.getContentPane().add(panelGeneral);
		panelGeneral.setMinimumSize(panelGeneral.getParent().getSize());
		//super.pack();
		this.setVisible(true);
	}
}
