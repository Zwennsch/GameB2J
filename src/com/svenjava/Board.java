package com.svenjava;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Board extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawDonut(g);
		
	}
	
	private void drawDonut(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.addRenderingHints(rh);
		
		Dimension size = getSize();
		double width = size.getWidth();
		double height = size.getHeight();
		
		Ellipse2D ellipse2d = new Ellipse2D.Double(0, 0, 80, 130);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.gray);
		
		for (double deg = 0; deg < 360; deg += 5 ) {
			AffineTransform affineTransform = AffineTransform.getTranslateInstance(width/2, height/2);
			affineTransform.rotate(Math.toRadians(deg));
			g2d.draw(affineTransform.createTransformedShape(ellipse2d));
		}
	}

	public Board() {
		
	}
}
