package com.svenjava.movingspr;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class MovingSpriteEx extends JFrame {
	
	public static Dimension dim = new Dimension(400, 300);
	
	public MovingSpriteEx() {
		initUI();
	}

	private void initUI() {
		add(new SpritePanel());
		
		setTitle("SpaceShip");
		setSize(dim);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() ->{
			MovingSpriteEx movSpr = new MovingSpriteEx();
			movSpr.setVisible(true);
		});
	}

}
