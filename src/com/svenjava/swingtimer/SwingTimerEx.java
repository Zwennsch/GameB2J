package com.svenjava.swingtimer;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SwingTimerEx extends JFrame {
	
	public SwingTimerEx() {
		initUI();
	}

	private void initUI() {
		add(new SwingPanel());
		pack();
		setTitle("Timer Example");
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(300, 300);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			SwingTimerEx st = new SwingTimerEx();
			st.setVisible(true);
		});
	}

}
