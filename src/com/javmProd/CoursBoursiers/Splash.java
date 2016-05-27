package com.javmProd.CoursBoursiers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

class Splash extends JFrame{
	JLabel image;
	Splash(){
		super();
		JPanel jp = new JPanel();
		image = new JLabel();
		image.setIcon(new ImageIcon(new ImageIcon("images/splash01.jpg").getImage().getScaledInstance(500, 300, Image.SCALE_AREA_AVERAGING)));
		jp.add(image);
		
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		
		
		JProgressBar jpb = new JProgressBar();
		jpb.setIndeterminate(true);
		
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		jp2.add(image);
		jp.add(jp2);
		
		jp.add(jpb);
		this.getContentPane().add(jp);
		this.pack();
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		
		this.setVisible(true);
				
	}
}