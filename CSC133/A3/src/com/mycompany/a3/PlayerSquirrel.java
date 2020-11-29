package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

public class PlayerSquirrel extends Squirrel {
	public PlayerSquirrel(float x, float y, int sz, int color) {
		super(x,y,sz,color);
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		/* Player Squirrel = Filled Square */
		g.setColor(this.getColor());
		int xPoint = (int)(this.getLocation().getX() + pCmpRelPrnt.getX());
		int yPoint = (int)(this.getLocation().getY() + pCmpRelPrnt.getY());
		
		int radius = this.getSize() / 2;
		g.fillRect(xPoint - radius, yPoint - radius, radius * 2, radius * 2);
	}
	
	@Override
	public boolean collidesWith(GameObject otherObject) {
		return false;
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		//todo	
	}
	
	/*Print Player Squirrel data on console*/
	@Override
	public String toString() {
		String parentString = super.toString();
		return "Squirrel: " + parentString;
	}
}