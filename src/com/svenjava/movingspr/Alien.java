package com.svenjava.movingspr;

public class Alien extends Sprite{
	
	private final int INITIAL_X = 400;

	public Alien(int x, int y) {
		super(x, y);
		
		initAlien();
	}

	private void initAlien() {
		loadImage("src/resources/alien.png");
		getImageDimension();
	}

	public void move() {
		if (x < 0) {
			x = INITIAL_X;
		}else {
			x -=1;
		}
	}

}
