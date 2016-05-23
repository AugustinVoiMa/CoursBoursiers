package com.javmProd.CoursBoursiers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Graphe extends JScrollPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel feuille;
	private JPanel panelGraph;
	private JScrollPane panelGeneral;
	private GraphBounds gbounds;
	public JPanel getFeuille(){
		return this.feuille;
	}
	public GraphBounds getGBounds(){
		return this.gbounds;
	}
	public Graphe(HistoriqueCoursAction symbol){		
		super();
		feuille = new JPanel(null);
		feuille.setBackground(Color.white);
		
		
		
		panelGraph = new JPanel(new BorderLayout());
		panelGraph.add(feuille,BorderLayout.CENTER);
		
		panelGeneral= this;
		panelGeneral.setViewportView(panelGraph);
		panelGeneral.setViewportBorder(new LineBorder(Color.BLACK));
		
		panelGeneral.setHorizontalScrollBar(panelGeneral.createHorizontalScrollBar());
		panelGeneral.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panelGeneral.getHorizontalScrollBar().setMinimum(0);
		panelGeneral.getHorizontalScrollBar().setMaximum(feuille.getWidth());
		panelGeneral.getHorizontalScrollBar().setValue(feuille.getWidth());
		
		
		panelGeneral.setVerticalScrollBar(panelGeneral.createVerticalScrollBar());
		panelGeneral.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		panelGeneral.setBackground(Color.black);
		
		
		gbounds = new GraphBounds(symbol,this);
		MouseListGraph mml = new MouseListGraph(this);
		panelGeneral.getViewport().addMouseMotionListener(mml);
		panelGeneral.getViewport().addMouseListener(mml);
		Chandelle ch = null;

		int i = 1;
		
		for(Value v : symbol){
			try{
				ch= v.toChandelle();
				
				feuille.add(ch);
				
				int x = (int)(i++*2*(gbounds.getCandelWidth()));
				int y = (int)(gbounds.calcY(v.getHigh()));
								
				ch.setBounds(gbounds,x,y);
				ch.repaint();
				
			}catch (OutOfGraphException e){
				e.printStackTrace();
			}
		}
	}

}
