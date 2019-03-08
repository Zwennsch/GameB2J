package com.svenjava.movingspr;

public class Missile extends Sprite{
	
	private String source = "src/resources/missile2.png";
	private final int MISSILE_SPEED = 2;

	public Missile(int x, int y) {
		super(x, y);
		
		initMissile();
	}

	private void initMissile() {
		loadImage(source);
		getImageDimension();
	}
	public void move() {
		x+=MISSILE_SPEED;
		
		if (x > MovingSpriteEx.dim.width) {
			visible = false;
		}
	}
	
}
