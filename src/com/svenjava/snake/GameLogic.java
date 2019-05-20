package com.svenjava.snake;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLogic extends KeyAdapter implements ActionListener{
	
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
	public void initGame() {
		snake = new Snake();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
