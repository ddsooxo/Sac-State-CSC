package com.mycompany.a2;

import com.codename1.charts.models.Point;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

public abstract class Moveable extends GameObject{
	private int heading;
	private int speed;
	
	public Moveable() { 
		this.heading = getHeading(); 
		this.speed = getSpeed();
	}
	
	public int getHeading() {
		return heading;
	}
	
	public void setHeading(int path) {
		heading = path;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int velocity) {
		speed = velocity;
	}

	public void move() {
		 Point newLocation = new Point(0.0f, 0.0f);
		 Point oldLocation = getWholeLocation();
		 float deltaX;
		 float deltaY;
	
		 /** 
		  * heading of Moveable objects specified below
		  * 0   : north(upwards)
		  * 90  : east(right of the screen)
		  * 180 : south (downwards)
		  * 270 : west(left of the screen)
		  */
		 
		 deltaX = (float) Math.cos(Math.toRadians(90 - (float)heading)*speed);
		 deltaY = (float) Math.sin(Math.toRadians(90 - (float)heading)*speed);

		 newLocation.setX(deltaX + oldLocation.getX());
		 newLocation.setY(deltaY + oldLocation.getY());
		 
		 setLocation(newLocation);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
		 
}
