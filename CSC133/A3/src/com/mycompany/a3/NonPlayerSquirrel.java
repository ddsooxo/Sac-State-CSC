package com.mycompany.a3;


/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/ 

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

public class NonPlayerSquirrel extends Squirrel {
	private IStrategy strategy;
	
	public NonPlayerSquirrel(float x, float y, int sz, int color) {
		super(x,y,sz, color);
		super.setMaxDamage(250);
	}
		
	public IStrategy getStrat() {
		return this.strategy;
	}
	
	public void setStrategy(IStrategy s) {
		this.strategy = s;
	}
	
	public String getStrategyString() {
		if(strategy instanceof AttackStrategy) {
			return "Attack Mode";
		}
		else {
			return "Follow Mode";
		}
	}

	public void invokeStrategy() {
		strategy.apply();
	}
	

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		/* NP Squirrel = Unfilled Square */
		g.setColor(this.getColor());
		int xPoint = (int)(this.getLocation().getX() + pCmpRelPrnt.getX());
		int yPoint = (int)(this.getLocation().getY() + pCmpRelPrnt.getY());
		
		int radius = this.getSize() / 2;
		g.drawRect(xPoint - radius, yPoint - radius, radius * 2, radius * 2);
	}

	@Override
	public boolean collidesWith(GameObject otherObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		// TODO Auto-generated method stub
	}

	/* Print NP Squirrel data to console*/
	@Override
	public String toString() {
		String parentString = super.toString();
		String npcString = " strategy = " +  this.getStrategyString();	
		return "Non Player Squirrel: " + parentString + npcString;
	}
}
