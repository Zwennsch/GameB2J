package com.svenjava.movingspr;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SpritePanel extends JPanel implements ActionListener{
	
	private SpaceShip spaceShip;
	private List<Alien> aliens;
	private boolean ingame;
	private Timer timer;
	private final int B_WIDTH = 400;
    private final int B_HEIGHT = 300;
    private final int DELAY = 15;
    
    private final int[][] pos = {
            {2380, 29}, {2500, 59}, {1380, 89},
            {780, 109}, {580, 139}, {680, 239},
            {790, 259}, {760, 50}, {790, 150},
            {980, 209}, {560, 45}, {510, 70},
            {930, 159}, {590, 80}, {530, 60},
            {940, 59}, {990, 30}, {920, 200},
            {900, 259}, {660, 50}, {540, 90},
            {810, 220}, {860, 20}, {740, 180},
            {820, 128}, {490, 170}, {700, 30}
        };
	
	
	public SpritePanel() {
		initBoard();
		addKeyListener(new TAdapter());
	} 
		
	

	private void initBoard() {
		setBackground(Color.BLACK);
		this.setFocusable(true);
		ingame = true;
		spaceShip = new SpaceShip(40,60);
		initAliens();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	private void initAliens() {
		aliens = new ArrayList<>();	
		
		for(int[] p : pos) {
			aliens.add(new Alien(p[0], p[1]));
		}
	}



	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(ingame) {
			drawObjects(g);
		}else {
			drawGameOver(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawObjects(Graphics g) {
		
		if(spaceShip.isVisible()) {
//			seems like the g2d object is not needed anymore?!
			g.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);
		}
		List<Missile> missiles = spaceShip.getMissiles();
		
		for (Missile missile : missiles) {
			g.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
		}
		
		for (Alien alien : aliens) {
			if(alien.isVisible()) {
				g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
			}
		}
		g.setColor(Color.WHITE);
		g.drawString("Aliens left: " + aliens.size(), 5, 15);
		
	}






	private void drawGameOver(Graphics g) {
		String msg ="Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);
		
		g.setColor(Color.WHITE);
		g.setFont(small);
		g.drawString(msg, B_WIDTH/2 - fm.stringWidth(msg)/2,B_HEIGHT/2);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		inGame();
		
		updateSpaceShip();
		updateMissiles();
		updateAliens();
		
		checkCollisions();
		
		repaint();
	}
	
	private void checkCollisions() {
		Rectangle sc = spaceShip.getBounds();
		List<Missile> missiles = spaceShip.getMissiles();
		
		for (Alien alien : aliens) {
			Rectangle alRect = alien.getBounds();
			if (alRect.intersects(sc)) {
				spaceShip.setVisible(false);
				alien.setVisible(false);
				ingame = false;
			}
			
			for (Missile missile : missiles) {
				Rectangle misRect = missile.getBounds();
				
				if(alRect.intersects(misRect)) {
					missile.setVisible(false);
					alien.setVisible(false);
				}
			}
		}
		
		
		
	}



	private void updateAliens() {
		if(aliens.isEmpty()) {
			ingame = false;
			return;
		}
		
		for (int i = 0; i < aliens.size(); i++) {
			Alien a = aliens.get(i);
			if(a.isVisible()) {
				a.move();
			}else {
				aliens.remove(i);
			}
		}
	}



	private void inGame() {
		if(!ingame) {
			timer.stop();
		}
	}



	private void updateMissiles() {
		List<Missile> missiles = spaceShip.getMissiles();
		
		for (int i = 0; i < missiles.size(); i++) {
			Missile miss = missiles.get(i);
			if(miss.visible) {
				miss.move();
			}else {
				missiles.remove(i);
			}
		}
	}



	private void updateSpaceShip() {
		if(spaceShip.visible) {
			spaceShip.move();
		}
	}

	private class TAdapter extends KeyAdapter{
		
		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
			spaceShip.keyPressed(e);
		}
	}

	

}
