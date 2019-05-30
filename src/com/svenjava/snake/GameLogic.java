package com.svenjava.snake;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLogic extends KeyAdapter{
	
	private boolean isRunning;
	private int panelWidth, panelHeight;
	private Point fruitPosoition;
	private Snake snake;
	private SnakePanel panel;
	private int frameCount = 0;
	private int fps = 60;
	
	
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
			double now = System.nanoTime();
			int updateCount = 0;
//			Do as many updates as we need to potentially playing catch-up
			while(now - lastUpdateTime >= TIME_BETWEEN_UPDATES && updateCount <= MAX_UPDATES_PER_RENDER) {
				updateGame();
				lastUpdateTime += TIME_BETWEEN_UPDATES;
				updateCount++;
			}
//			if for some reason an update takes forever we don't want to do an insane number of catch-ups
//			if you were doing some sort of game that needed to keep EXACT_TIME! you would get rid of this
			if(now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
				lastUpdateTime = now - TIME_BETWEEN_UPDATES;
			}
			
//			Render. To do so, we need to calculate interpolation for a smooth render.
			float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));
			renderGame(interpolation);
			lastRenderTime = now;
			
//			Update the frames we got.
			int thisSecond = (int) (lastUpdateTime / 1000000000);
			if (thisSecond > lastSecondTime) {
				System.out.println("New Second: "+ thisSecond +" "+ frameCount);
				fps = frameCount;
				frameCount = 0;
				lastSecondTime = thisSecond;
			}
			
//			Yield until it has been at least the target time between renders. This saves CPU from hogging
			while(now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
				Thread.yield();
			}
		}
		
	}

	private void renderGame(float interpolation) {
		panel.setInterpolation(interpolation);
		panel.repaint();
	}
	private void updateGame() {
		checkFruit();
		checkCollision();
		move();
		
	}
	private void move() {
		// TODO Auto-generated method stub
		
	}
	private void checkCollision() {
		// TODO Auto-generated method stub
		
	}
	private void checkFruit() {
		if (snake.getPositionHead().equals(fruitPosoition)) {
			
		}
	}
	private void createRandomFruitPosition() {
		Random rand = new Random();
		fruitPosoition = new Point(rand.nextInt(panelWidth-10), rand.nextInt(panelHeight-10));
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		super.keyPressed(e);
		
		int k = e.getExtendedKeyCode();
		
		System.out.println(k + " -> Taste Nr.");
	}
	public void initGame(Snake snake) {
		this.snake = snake;
	}
	public Point getFruitPosoition() {
		return fruitPosoition;
	}
	


}
