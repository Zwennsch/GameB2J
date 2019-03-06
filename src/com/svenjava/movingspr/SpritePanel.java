package com.svenjava.movingspr;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SpritePanel extends JPanel implements ActionListener{
	
	private SpaceShip spaceShip;
	private Timer timer;
	private final int DELAY = 10;
	
	
	public SpritePanel() {
		initBoard();
		addKeyListener(new TAdapter());
	} 
		
	

	private void initBoard() {
		setBackground(Color.BLACK);
		
		spaceShip = new SpaceShip(40,60);
		
		timer = new Timer(DELAY, this);
		timer.start();
		this.setFocusable(true);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}



	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), null);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
	
	private void step() {
		spaceShip.move();
//		System.out.println("in step");
		repaint(spaceShip.getX()-1, spaceShip.getY()-1, spaceShip.getWidth()+2, spaceShip.getHeight()+2);
	}

	private class TAdapter extends KeyAdapter{
//		protected TAdapter() {
//			System.out.println("in KeyAdapter");
//		}
		
		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("key released");
			spaceShip.keyReleased(e);
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("key ppressed");
			spaceShip.keyPressed(e);
		}
	}

	

}
