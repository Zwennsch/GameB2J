package com.svenjava.movingspr;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class SpaceShip {
	
	private int x,y,dx, dy, w, h;
	private Image image;
	private final String SRC = "src/resources/spaceship.png";
	
	public SpaceShip(int startx, int starty) {
		this.x = startx;
		this.y = starty;
		this.dx = 0;
		this.dy = 0;
		
		try {
			loadImage(SRC);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	private void loadImage(String src) {
		ImageIcon ii = new ImageIcon(src);
		image = ii.getImage();
		
		w = image.getWidth(null);
		h = image.getHeight(null);
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx = -2;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 2;
		}
		if (key == KeyEvent.VK_UP) {
			dy = -2;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 2;
		}
		
	}

	public void move() {
		x+=dx;
		y+=dy;
//		System.out.println("x : "+ x);
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return this.w;
	}
	public int getHeight() {
		return this.h;
	}

	public Image getImage() {
		
		return this.image;
	}
	
	

}
