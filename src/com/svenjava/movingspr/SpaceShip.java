package com.svenjava.movingspr;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class SpaceShip extends Sprite{
	
	private int dx, dy;
	private final String SRC = "src/resources/spaceship.png";
	private List<Missile> missiles;
	
	public SpaceShip(int startx, int starty) {
		super(startx,starty);
		this.dx = 0;
		this.dy = 0;
		missiles = new ArrayList<>();
		try {
			loadImage(SRC);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		getImageDimension();
	}
	
	public List<Missile> getMissiles(){
		return missiles;
	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			fire();
		}
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

	private void fire() {
		missiles.add(new Missile(this.x + this.width-20, this.y + this.height/2-3));
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
	}

	

	
	
	

}
