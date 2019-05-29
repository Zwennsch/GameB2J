package com.svenjava.snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	private int length;
	private final int PART_RADIOUS = 10;
	
	private List<Point> bodyParts;
	
//	you should probably create a enum for the directions
	private int direction;
	private Point positionHead;
	private Point tailEnd;
	private int speed;
	private final int SCREEN_WIDTH = SnakePanel.WIDTH;
	private final int SCREEN_HEIGHT = SnakePanel.HEIGHT;
	
	public Snake(int initialLength) {
		bodyParts = new ArrayList<>();
		for (int i = 0; i <initialLength; i++) {
			bodyParts.add(new Point(SCREEN_WIDTH/2 - i * PART_RADIOUS, SCREEN_HEIGHT/2));
		}
		setPositionHead(bodyParts.get(0));
		tailEnd = bodyParts.get(bodyParts.size()-1);
		length = bodyParts.size();
		speed = 1;
	}

	public Point getPositionHead() {
		return positionHead;
	}

	public void setPositionHead(Point positionHead) {
		this.positionHead = positionHead;
	}
	public void addNewPart() {
		bodyParts.add(new Point(tailEnd.x+ PART_RADIOUS, tailEnd.y));
	}
	public int getLength() {
		return length;
	}
	public int getSpeed() {
		return this.speed;
	}
	public List<Point> getBodyParts(){
		return this.bodyParts;
	}
	
	

}
