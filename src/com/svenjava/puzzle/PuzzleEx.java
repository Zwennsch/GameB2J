package com.svenjava.puzzle;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuzzleEx extends JFrame{
	
	private JPanel panel;
	
	List<Point> solution;
	List<MyButton> buttons;
	
	public final int NUMBER_OF_BUTTONS = 12;
	private final int DESIRED_WIDTH= 300;
	
	public PuzzleEx() {
		initUI();
	}

	private void initUI() {
		solution = new ArrayList<>();
		
		solution.add(new Point(0, 0));
		solution.add(new Point(0, 1));
		solution.add(new Point(0, 2));
		solution.add(new Point(1, 0));
		solution.add(new Point(1, 1));
		solution.add(new Point(1, 2));
		solution.add(new Point(2, 0));
		solution.add(new Point(2, 1));
		solution.add(new Point(2, 2));
		solution.add(new Point(3, 0));
		solution.add(new Point(3, 1));
		solution.add(new Point(3, 2));
		
		buttons = new ArrayList<>();
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			PuzzleEx puzzleEx = new PuzzleEx();
			puzzleEx.setVisible(true);
		});
	}

}
