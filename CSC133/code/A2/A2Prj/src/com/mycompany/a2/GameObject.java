package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.Random;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

public class GameObject {
	
	/* public variables */
	public Random rand = new Random(); 
	
	/* private variables */
	private  int size;
	private Point location;
	private int color;
	
	/*GameObject constructor */
	public GameObject() {
		//giving game objects random xy point location between 0 and 1000 except for Nut and Squirrel
		float x = Math.round(1001*rand.nextFloat()*10)/10;
		float y = Math.round(1001*rand.nextFloat()*10)/10;
		
		this.location = new Point(x,y);
	}
	
	/* get and set methods */
	public int getSize() {
		return size;
	}
	
	public void setSize(int newSize) {
		 this.size = newSize;
	}
	
	public Point getWholeLocation() {
		
		return location;
	}
	
	public void setLocation(float x, float y) {
		this.location.setX(x);
		this.location.setY(y);
	}
	
	public void setLocation(Point position) {
		this.location.setX(position.getX());
		this.location.setY(position.getY());
	}
	
	public float getLocX() {
		return location.getX();
	}
	
	public float getLocY() {
		return location.getY();
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int r, int g, int b) {
		this.color = ColorUtil.rgb(r, g, b);
	}
	
	/* Printing the location data to console */
	public String toString() {
		return "loc=(" + location.getX() + ", " + location.getY() + ")"
							 + " color=[" + ColorUtil.red(color)
							 + ", " + ColorUtil.green(color) + ", "
							 + ColorUtil.blue(color) + "]";
	}

	
	
}
