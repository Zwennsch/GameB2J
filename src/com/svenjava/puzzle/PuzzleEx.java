package com.svenjava.puzzle;

import java.awt.EventQueue;
import java.awt.Point;
import java.util.List;

import javax.swing.JFrame;

public class PuzzleEx extends JFrame{
	
	List<Point> solution;
	List<MyButton> buttons;
	
	public PuzzleEx() {
		initUI();
	}

	private void initUI() {
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			PuzzleEx puzzleEx = new PuzzleEx();
			puzzleEx.setVisible(true);
		});
	}

}
