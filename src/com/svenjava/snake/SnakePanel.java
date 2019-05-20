package com.svenjava.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {
	
	private GameLogic game;
	private Snake snake;
	protected static final int WIDTH = 600;
	protected static final int HEIGHT = 600;
	
	public SnakePanel() {
		snake = new Snake();
		game = new GameLogic(WIDTH, HEIGHT, snake, this);
		initBoard();
		
	}
	private void initBoard() {
		setBackground(Color.BLACK);
		addKeyListener(game);
		setFocusable(true);
		game.initGame();
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
		g.fillOval(10, 20, 10, 10);
	}
	
	

}
