package com.svenjava.puzzle;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton{
	
	private boolean isLastButton;
	
	public MyButton() {
		super();
		
		initUI();
	}

	public MyButton(Image image) {
		super(new ImageIcon(image));
		
		initUI();
	}

	private void initUI() {
		
		isLastButton = false;
		BorderFactory.createLineBorder(Color.GRAY);
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				super.mouseEntered(e);
				BorderFactory.createLineBorder(Color.YELLOW);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				super.mouseEntered(e);
				BorderFactory.createLineBorder(Color.GRAY);
			}
		});
	}
	
	public void setLastButton() {
		this.isLastButton = true;
	}
	
	public boolean isLastButton() {
		return this.isLastButton;
	}
	

}
