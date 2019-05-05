package com.svenjava.snake;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLogic extends KeyAdapter {
	
	private boolean isRunning;
	private int panelWidth, panelHeight;
	private Point fruitPosoition;
	private Snake snake;
	
	public GameLogic(int width, int height, Snake snake) {
		isRunning = true;
		this.snake = snake;
		this.panelWidth = width;
		this.panelHeight = height;
		createRandomStartPositions();
	}

	private void createRandomStartPositions() {
		Random rand = new Random();
//		fruitPosoition = new Point(rand.nextInt(arg0), y)
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		super.keyPressed(e);
		
		int k = e.getExtendedKeyCode();
		
		System.out.println(k);
	}

}
