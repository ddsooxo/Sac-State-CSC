package com.mycompany.myapp;
import java.util.*;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class GameObject {
	
	//private variables
	private  int size;
	private Point location;
	private int color;
	
	//constructor
	public GameObject() {
		
	}
	
	/* get and set methods */
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int newSize) {
		
	}
	
	
	
	public Point getWholeLocation() {
		return location;
	}
	
	public void setLocation(float x, float y) {
		
		//need code here
	}
	
	public float getX() {
		return location.getX();
	}
	
	public void setX() {
		
	}
	
	
	public float getY() {
		return location.getY();
	}
	
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}
		
	
}
