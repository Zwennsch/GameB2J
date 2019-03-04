package com.svenjava.swingtimer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class UtilityTimerPanel extends JPanel{
	
	private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = 0;
    private final int INITIAL_Y = 0;    
    private final int INITIAL_DELAY = 2000;
    private final int PERIOD_INTERVAL = 25;
    private final String IMAGE_SRC = "src/resources/star.png";
    
    private Image star;
    private Timer timer;
    
    private int x,y;
    
    public UtilityTimerPanel() {
    	initPanel();
    }

	private void initPanel() {
		setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        loadImage(IMAGE_SRC);

        x = INITIAL_X;
        y = INITIAL_Y;
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 
                INITIAL_DELAY, PERIOD_INTERVAL);  
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStar(g);
    }

	private void drawStar(Graphics g) {
		g.drawImage(star, x, y,  this);
		Toolkit.getDefaultToolkit().sync();
		
	}

	private void loadImage(String src) {
		ImageIcon ii = new ImageIcon(src);
		star = ii.getImage();
		
	}
	
	private class ScheduleTask extends TimerTask {

		@Override
		public void run() {
			x += 1;
            y += 1;

            if (y > B_HEIGHT) {
                y = INITIAL_Y;
                x = INITIAL_X;
            }
            
            repaint();
		}
		
	}

}
