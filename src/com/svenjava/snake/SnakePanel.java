package com.svenjava.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {
	
	private GameLogic game;
	private Snake snake;
	private float interpolation;
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
//		int drawXhead = (int) 
		g.fillOval(snake.getPositionHead().x, snake.getPositionHead().y, 10, 10);
		g.setColor(Color.gray);
		for (int i = 1; i < snake.getLength(); i++) {
			g.fillOval(snake.getBodyParts().get(i).x, snake.getBodyParts().get(i).y, 10, 10);
		}
		g.setColor(Color.RED);
		g.fillOval(game.getFruitPosoition().x, game.getFruitPosoition().y, 10, 10);
	}
	public void setInterpolation(float interpolation) {
		this.interpolation = interpolation;
	}
	
	

}
