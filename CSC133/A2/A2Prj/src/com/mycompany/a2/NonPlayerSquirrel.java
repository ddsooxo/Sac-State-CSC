package com.mycompany.a2;


/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

import com.codename1.charts.models.Point;

public class NonPlayerSquirrel extends Squirrel {
	private IStrategy strategy;
	
	
	public NonPlayerSquirrel(Point loc) {
		super(loc);
		super.setMaxDamage(200);
	}
	
	public NonPlayerSquirrel(float x, float y) {
		super(x, y);
		super.setMaxDamage(10);
	}
	
	
	public IStrategy getStrat() {
		return this.strategy;
	}
	
	public String getStrategy() {
		if(strategy instanceof AttackStrategy) {
			return "Attack Strategy";
		}
		else {
			return "Follow Nut Strategy";
		}
	}

	public void invokeStrategy() {
		strategy.apply();
	}
	
	public void setStrategy(IStrategy s) {
		this.strategy = s;
	}
	
	@Override
	public String toString() {
		
		String parentString = super.toString();
		String npcString = " strategy = " +  this.getStrategy();	
		return "Non Player Squirrel: " + parentString + npcString;
		
	}

	
	
	
}
