package com.svenjava.snake;

import java.awt.Point;
import java.util.Random;

public class GameLogic {
	
	private boolean isRunning;
	private int panelWidth, panelHeight;
	private Point fruitPosoition;
	
	public GameLogic(int width, int height) {
		isRunning = true;
		createRandomStartPositions();
		this.panelWidth = width;
		this.panelHeight = height;
	}

	private void createRandomStartPositions() {
		Random rand = new Random();
//		fruitPosoition = new Point(rand.nextInt(arg0), y)
	}

}
