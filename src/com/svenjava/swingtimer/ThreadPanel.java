package com.svenjava.swingtimer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ThreadPanel extends JPanel implements Runnable {
	
	private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = 0;
    private final int INITIAL_Y = 0;    
    private final int DELAY = 25;
    private final String IMAGE_SRC = "src/resources/star.png";
    
    private Image star;
    private Thread animator;
    private int x,y;
	
	public ThreadPanel(){
		initBoard();
	}

	private void initBoard() {
		setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage(IMAGE_SRC);

        x = INITIAL_X;
        y = INITIAL_Y;
		
	}
//	The addNotify() method is called after our JPanel has been added to the JFrame component. 
//	This method is often used for various initialisation tasks. 
	public void addNotify() {
		super.addNotify();
		
		animator = new Thread(this);
		animator.start();
	}

	private void loadImage(String src) {
		ImageIcon ii = new ImageIcon(src);
		star = ii.getImage();
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStar(g);
    }

    private void drawStar(Graphics g) {
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }


	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
		beforeTime = System.currentTimeMillis();
		
		while(true) {
			cycle();
			repaint();
			
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;
			
			if(sleep < 0) {
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				 String msg = String.format("Thread interrupted: %s", e.getMessage());
	                
	             JOptionPane.showMessageDialog(this, msg, "Error", 
	            		 JOptionPane.ERROR_MESSAGE);
			}
			
			beforeTime = System.currentTimeMillis();
		}
	}

	private void cycle() {
		 x += 1;
	     y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }
		
	}

}
