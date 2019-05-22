package com.svenjava.snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	private int length;
	private final int PART_RADIOUS = 10;
	
	private List<Point> bodyParts;
	private int direction;
	private Point positionHead;
	private int speed;
	private final int SCREEN_WIDTH = SnakePanel.WIDTH;
	private final int SCREEN_HEIGHT = SnakePanel.HEIGHT;
	
	public Snake() {
		length = 3;
		bodyParts = new ArrayList<>();
		for (int i = 0; i <3; i++) {
			bodyParts.add(new Point(SCREEN_WIDTH/2 - i * PART_RADIOUS, SCREEN_HEIGHT/2));
		}
		setPositionHead(bodyParts.get(0));
	}

	public Point getPositionHead() {
		return positionHead;
	}

	public void setPositionHead(Point positionHead) {
		this.positionHead = positionHead;
	}

}
