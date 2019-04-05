
package com.svenjava.snake;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainSnake {
	
	private static SnakePanel snakePanel = new SnakePanel();
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createAndShowUI());
	}

	private static void createAndShowUI() {
		JFrame frame = new JFrame("Snake");
		frame.add(snakePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
