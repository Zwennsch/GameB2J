package com.svenjava;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class Basic extends JFrame{
	
	public Basic() {
		initUI();
	}

	private void initUI() {
		add(new Board());
		
		setSize(330	, 330);
		setTitle("Donat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			Basic basic = new Basic();
			basic.setVisible(true);
		});
		
	}

}
