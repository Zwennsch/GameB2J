package com.svenjava.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {
	
	private GameLogic game;
	private Snake snake;
	protected static float interpolation;
	private int lastDrawXHead, lastDrawBodyPartX, lastDrawYHead, lastDrawBodyPartY;
	protected static final int WIDTH = 600;
	protected static final int HEIGHT = 600;
	
	public SnakePanel() {
		snake = new Snake(3);
		game = new GameLogic(WIDTH, HEIGHT, snake, this);
		initBoard();
	}
	private void initBoard() {
		setBackground(Color.BLACK);
		addKeyListener(game);
		setFocusable(true);
		game.initGame(snake);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(WIDTH, HEIGHT);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.green);
		g.fillOval(snake.getPositionHead().x, snake.getPositionHead().y, 10, 10);
		g.setColor(Color.gray);
//		int drawX = 
		for (int i = 1; i < snake.getLength(); i++) {
//			Do i really need the last Position and actual Position of every single body Part??? 
			g.fillOval(snake.getBodyParts().get(i).x, snake.getBodyParts().get(i).y, 10, 10);
		}
		g.setColor(Color.RED);
		g.fillOval(game.getFruitPosoition().x, game.getFruitPosoition().y, 10, 10);
		System.out.println(interpolation);
//		System.out.println("head x: "+Snake.positionHead.x+ "; last head x: "+ Snake.lastPositionHead.x);
	}
	public void setInterpolation(float interpolation) {
		this.interpolation = interpolation;
	}
	
	

}
