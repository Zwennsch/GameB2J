package com.svenjava.movingspr;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {
	
	protected int x,y, width, height;
	protected Image image;
	protected boolean visible;
	
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	protected void loadImage(String source) {
		ImageIcon ii = new ImageIcon(source);
		image = ii.getImage();
	}
	
	protected void getImageDimension() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean vis) {
		this.visible = vis;
	}

}
