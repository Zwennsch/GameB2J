package com.svenjava.snake;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class SnakePanel extends JPanel{
	
	private Snake snake;
	private final int WIDTH = 700;
	private final int HEIGHT = WIDTH*9/16;
	
	public SnakePanel() {
		setBackground(Color.BLACK);
	}
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(WIDTH, HEIGHT);
	}
	

}
