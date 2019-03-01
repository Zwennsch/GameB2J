package com.svenjava;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardImage extends JPanel{
	
	private Image werder;
	private BufferedImage werder2= null;
	
	public BoardImage() {
		initBoard();
	}

	private void initBoard() {
		loadImage();
		
		int werderWidth = werder.getWidth(this);
		int werderHeight = werder.getHeight(this);
		
		setPreferredSize(new Dimension(werderWidth, werderHeight));
		
	}

	private void loadImage() {
		ImageIcon ii = new ImageIcon("src/resources/werder.jpg");
		werder = ii.getImage();
		try {
			werder2 = ImageIO.read(new File("src/resources/werder.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		AffineTransform at = AffineTransform.getTranslateInstance(20,10);
		at.scale(0.5, 0.5);
		Graphics2D g2d =  (Graphics2D) g;
		g2d.drawImage(werder, at, null);
	}

}
