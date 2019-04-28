package com.svenjava.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SnakePanel extends JPanel{
	
	private GameLogic game;
	private Snake snake;
	private final int WIDTH = 700;
	private final int HEIGHT = WIDTH*9/16;
	
	public SnakePanel() {
		setBackground(Color.BLACK);
		game = new GameLogic(WIDTH, HEIGHT);
	}
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(WIDTH, HEIGHT);
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
	}
	

}
