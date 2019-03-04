package com.svenjava.swingtimer;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SwingTimerEx extends JFrame {
	
	public SwingTimerEx() {
		initUI();
	}

	private void initUI() {
//		with Swing Timer:
//		add(new SwingPanel());
		
		/*
		 * with Utility Timer:
		 */
		add(new UtilityTimerPanel());
		pack();
		setTitle("Timer Example");
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(500, 300);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			SwingTimerEx st = new SwingTimerEx();
			st.setVisible(true);
		});
	}

}
