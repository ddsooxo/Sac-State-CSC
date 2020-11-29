package com.mycompany.a3;

import com.codename1.charts.models.Point;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/ 

public abstract class Fixed extends GameObject implements ISelectable{
	private boolean isSelected = false;

	public Fixed(float x, float y, int sz, int color) {
		super(x, y, sz, color);
	}
	
	public void setSelected(boolean s) {
		this.isSelected = s;
	}
	
	public boolean isSelected() {
		return this.isSelected;
	}
	
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		float pX = pPtrRelPrnt.getX();
		float pY = pPtrRelPrnt.getY();
		float xLoc = pCmpRelPrnt.getX() +  this.getLocation().getX();
		float yLoc = pCmpRelPrnt.getY() +  this.getLocation().getY();
		int size = this.getSize() / 2;
		if ((pX >= xLoc - size) && (pX <= xLoc + size) && (pY >= yLoc - size) && (pY <= yLoc + size)) 
			return true; else return false;
	}
		
}
