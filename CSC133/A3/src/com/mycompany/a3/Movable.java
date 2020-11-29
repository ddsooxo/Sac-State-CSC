package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

public abstract class Movable extends GameObject {
	
	private int heading;
	private int speed;
	
	public Movable(float x, float y, int size, int rgb) {
		super(x, y, size, rgb);
	}
	
	/* Get and set methods */
	public int getHeading() {
		return this.heading;
	}
	
	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int velocity) {
		speed = velocity;
	}

	public void adjustHeading() {
		if (this.heading < 0) {
			this.heading += 360;
		}
	}
	
	public void move(double timerValue) {
		
		/** 
		 * heading of Movable objects specified below
		 * 0   : north(upwards)
		 * 90  : east(right of the screen)
		 * 180 : south (downwards)
		 * 270 : west(left of the screen)
		 */
		
		int currentHeading = this.getHeading();
		double alpha = Math.toRadians(90 - currentHeading);
		float deltaX = (float) (Math.cos(alpha) * this.getSpeed() * (timerValue/1000));
		float deltaY = (float) (Math.sin(alpha) * this.getSpeed() * (timerValue/1000));
		super.move(deltaX, deltaY);
	}
	
	@Override
	public void handleCollision(ICollider otherObject) {
		System.out.println(this.getClass() + " collided with " + otherObject.getClass());
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}