package com.svenjava.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SnakePanel extends JPanel implements ActionListener{
	
	private GameLogic game;
	private Snake snake;
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	
	public SnakePanel() {
		setBackground(Color.BLACK);
		snake = new Snake();
		game = new GameLogic(WIDTH, HEIGHT, snake);
		initBoard();
		
	}
	private void initBoard() {
		addKeyListener(game);
		setFocusable(true);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("jjj");
	}
	

}
