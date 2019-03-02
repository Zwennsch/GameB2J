package com.svenjava.swingtimer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SwingPanel extends JPanel implements ActionListener {
	
	private final int P_WIDTH = 400;
	private final int P_HEIGHT = 350;
	private final int INITIAL_X = 0;
	private final int INITIAL_Y = 0;
	private final int DELAY = 25;
	private final String IMAGE_SRC = "src/resources/star.png";
	
	private Image star;
	private Timer timer;
	private int x,y;
	private int xSpeed;
	private int ySpeed;
	
	public SwingPanel() {
		initPanel();
	}
	
	private void initPanel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
		
		loadImage(IMAGE_SRC);
		
		x = INITIAL_X;
		y = INITIAL_Y;
		xSpeed = 1;
		ySpeed = 1;
		
		timer = new Timer(DELAY, this);
		timer.start();
	}

	private void loadImage(String iMAGE_SRC2) {
		ImageIcon ii = new ImageIcon(iMAGE_SRC2);
		star = ii.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawStar(g);
		
	}

	private void drawStar(Graphics g) {
		g.drawImage(star, x, y,  this);
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x+=xSpeed;
		y+=ySpeed;
		
		if(x > this.getWidth()-star.getWidth(this) || x < 0) {
			xSpeed*=-1;
		}
		if(y > this.getHeight()-star.getHeight(this) || y < 0) {
			ySpeed*=-1;
		}
		repaint();
	}

}
