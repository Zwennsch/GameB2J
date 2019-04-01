package com.svenjava.puzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuzzleEx extends JFrame{
	
	private JPanel panel;
	private static final String  SOURCE = "src/resources/claudio-pizarro.jpg";
	private int width, height;
	
	private BufferedImage resizedImage;
	private Image image;
	
	List<Point> solution;
	List<MyButton> buttons;
	
	public final int NUMBER_OF_ROWS = 4;
	public final int NUMBER_OF_COLUMNS = 3;
	
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
		
		ImageLoader iLoader = new ImageLoader(SOURCE, DESIRED_WIDTH);
		resizedImage = iLoader.getResizedImage();
		width = resizedImage.getWidth();
		height = resizedImage.getHeight();
		
		add(panel, BorderLayout.CENTER);
		
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				image = createImage(new FilteredImageSource(resizedImage.getSource(), imgf))
				
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			PuzzleEx puzzleEx = new PuzzleEx();
			puzzleEx.setVisible(true);
		});
	}

}
