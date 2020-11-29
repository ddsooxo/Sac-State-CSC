package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

import java.util.Random;


public abstract  class GameObject implements IDrawable, ICollider{
	
	/* private variables */
	private Point location = new Point();	
	private int sz;						
	private int color; 							
	
	/*GameObject constructor */  
	public GameObject(float x, float y, int sz, int objColor) {
		this.setLocation(x, y);
		this.setSize(sz);
		this.setColor(objColor);
	}
	
	/* get and set methods */
	public int getSize() {
		return this.sz;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public void setLocation(float x, float y) {
		this.location.setX(x);
		this.location.setY(y);
	}
	
	public float getLocX() {
		return this.location.getX();
	}
	
	public float getLocY() {
		return this.location.getY();
	}
	
	public int getColor() {
		return this.color;
	}
	
	public void setColor(int r, int g, int b) {
		this.color = ColorUtil.rgb(r, g, b);
	}
	
	private void setSize(int newSize) {
		this.sz = newSize;
	}
	
	private void setColor(int rgb) {
		this.color = rgb;
	}
	

	/* move an object to new displacement */
	public void move(float x, float y) {
		float newX = this.location.getX() - x;
		float newY = this.location.getY() - y;
		this.setLocation(newX, newY);
	}

	public boolean collidesWith(ICollider otherObject) {
		int objSize = this.getSize() / 2;
		float thisCenterX = this.getLocation().getX();
		float thisCenterY = this.getLocation().getY();
		int otherObjSize = ((GameObject)otherObject).getSize() / 2;
		float otherCenterX = ((GameObject)otherObject).getLocation().getX();
		float otherCenterY = ((GameObject)otherObject).getLocation().getY();
		boolean nonOverlapLR = (thisCenterX + objSize < otherCenterX - otherObjSize || thisCenterX - objSize > otherCenterX + otherObjSize)? true : false;
		boolean nonOverlapTB = (thisCenterY + objSize < otherCenterY - otherObjSize || thisCenterY - objSize > otherCenterY + otherObjSize)? true : false;
		return (nonOverlapLR || nonOverlapTB)? false : true;
	}
	
	public void handleCollision(ICollider otherObject) {
		// TODO
	}
	
	public String toString() {
		return "loc=(" + this.getLocation().getX() + "," + this.getLocation().getY() + ")"
					+ " color=[" + ColorUtil.red(this.getColor()) 
					+ "," + ColorUtil.green(this.getColor()) 
					+ "," + ColorUtil.blue(this.getColor()) + "]"
					+ " size= " + this.getSize();		
	}
	
}
	
