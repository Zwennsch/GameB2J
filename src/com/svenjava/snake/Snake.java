package com.svenjava.snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	private int length;
	protected final int PART_RADIOUS = 10;
	
	private List<Point> bodyParts;
	
//	you should probably create a enum for the directions; for now 38 -> up; 39-> right; 40->down, 37->left
	private int direction;
	private Point positionHead;
	static int lastHeadx;
	static int lastHeady;
	public Point lastPositionHead;
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
		lastPositionHead = positionHead;
		tailEnd = bodyParts.get(bodyParts.size()-1);
		length = bodyParts.size();
		speed = 1;
		direction = 39;
	}
	public void move() {
		lastHeadx = positionHead.x;
		lastHeady = positionHead.y;
		for (int i = this.getLength()-1; i > 0; i--) {
			this.getBodyParts().get(i).x = this.getBodyParts().get(i-1).x;
			this.getBodyParts().get(i).y = this.getBodyParts().get(i-1).y;
		}
		int dir = this.getDirection();
		if (dir == 39) {
			this.getBodyParts().get(0).x += this.PART_RADIOUS;
		}
		if (dir == 37) {
			this.getBodyParts().get(0).x -= this.PART_RADIOUS;
		}
		if (dir == 38) {
			this.getBodyParts().get(0).y -= this.PART_RADIOUS;
		}
		if (dir == 40) {
			this.getBodyParts().get(0).y += this.PART_RADIOUS;
		}
		tailEnd = bodyParts.get(bodyParts.size()-1);
	}
	public Point getPositionHead() {
//		maybe I have to change this to bodyParts[0]
		return bodyParts.get(0);
	}

	public void setPositionHead(Point positionHead) {
		this.positionHead = positionHead;
	}
	public void addNewPart() {
		bodyParts.add(new Point(tailEnd.x+ PART_RADIOUS, tailEnd.y));
		//System.out.println("New part body part added at: "+ this.get);
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	

}
