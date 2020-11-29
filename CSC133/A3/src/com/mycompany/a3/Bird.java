package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/ 

public class Bird extends Movable {
	
	public Bird(float x, float y, int sz, int color, int heading, int speed) {
		super(x,y,sz, color);
		super.setHeading(heading);
		super.setSpeed(speed);
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		/* Bird = Unfilled Isosceles Triangles */
		g.setColor(this.getColor());
		int xPoint = (int)(this.getLocation().getX() + pCmpRelPrnt.getX());
		int yPoint = (int)(this.getLocation().getY() + pCmpRelPrnt.getY());
		int radius = this.getSize() / 2;
		
		int[] xPoints = {xPoint - radius, xPoint, xPoint + radius};
		int[] yPoints = {yPoint - radius, yPoint + radius, yPoint - radius};
		
		int nPoints = 3;
		g.drawPolygon(xPoints, yPoints, nPoints);
		
	}

	@Override
	public boolean collidesWith(GameObject otherObject) {
		return false;
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		//todo
	}
	
	/* Print Bird data to console*/
	@Override
	public String toString() {
		String parentString = super.toString();
		String birdString = " heading=" + super.getHeading() + " speed=" + super.getSpeed() + " size=" + super.getSize();
		return "Bird: " + parentString + birdString;
	}
	
}
