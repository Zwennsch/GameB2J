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
// 	game loop should be running in it's own thread
	private void runGameLoop() {
		Thread thread = new Thread() {
			public void run() {
				gameLoop();
			}
		};
		thread.start();
	}
	private void gameLoop() {
		System.out.println("Starting the loop");
		final double GAME_HERTZ = 30.0;
//		Calculate how many ns each frame should take for our target game hertz
		final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
//		At the very most we will update the game this many times before a new render
//		if worried about visual hitches more than perfect timing, set this to 1.
		final int MAX_UPDATES_PER_RENDER = 5;
//		We need the last update time
		double lastUpdateTime = System.nanoTime();
//		Store the last time we rendered
		double lastRenderTime = System.nanoTime();
		
//		If we are able to get as high as this FPS don't render again
		final double TARGET_FPS = 60.0;
		final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
		
//		Simple way of finding FPS:
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);
		
		while(isRunning) {
			
		}
		
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
	public void initGame(Snake snake) {
		this.snake = snake;
	}


}
