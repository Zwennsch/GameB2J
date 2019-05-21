package com.svenjava.snake;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLogic extends KeyAdapter{
	
	private boolean isRunning;
	private int panelWidth, panelHeight;
	private Point fruitPosoition;
	private Snake snake;
	private SnakePanel panel;
	
	
	public GameLogic(int width, int height, Snake snake, SnakePanel snakePanel) {
		this.panel = snakePanel;
		isRunning = true;
		this.snake = snake;
		this.panelWidth = width;
		this.panelHeight = height;
		createRandomFruitPosition();
		runGameLoop();
	}

	private void runGameLoop() {
		Thread thread = new Thread() {
			public void run() {
				gameLoop();
			}
		};
		thread.start();
	}
	private void gameLoop() {
		// TODO Auto-generated method stub
		
	}

	private void createRandomFruitPosition() {
		Random rand = new Random();
		fruitPosoition = new Point(rand.nextInt(panelWidth), rand.nextInt(panelHeight));
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		super.keyPressed(e);
		
		int k = e.getExtendedKeyCode();
		
		System.out.println(k);
	}
	public void initGame() {
		snake = new Snake();
	}


}
