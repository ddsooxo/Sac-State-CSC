package com.mycompany.a2;

import com.codename1.charts.models.Point;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

public abstract class Squirrel extends Moveable implements ISteerable{
	
	/* private Squirrel attributes */
	private int maxDamage = 100;
	private int steeringDirection;
	private int maximumSpeed;
	private int energyLevel;
	private int energyConsumptionRate;
	private int damageLevel;
	private int lastNutReached = 1;

	
	/* Squirrel constructor*/
	public Squirrel(Point loc) {
		setLocation(loc.getX(), loc.getY());
		setColor(165,42,42); //BROWN
		setSpeed(25); 
		setSize(40);
		setHeading(0);
		this.damageLevel = 0;		
		this.steeringDirection = 0;
		this.maximumSpeed = 50;
		this.energyLevel = 100; 
		this.energyConsumptionRate = 50;     

	}
	
	public Squirrel(float x, float y) {
		setLocation(x, y);
		setColor(165,42,42);//BROWN
		setSpeed(25); 
		setSize(40);
		setHeading(0);
		this.damageLevel = 0;		
		this.steeringDirection = 0;
		this.maximumSpeed = 50;
		this.energyLevel = 100; 
		this.energyConsumptionRate = 50;     
	}
	
	@Override
	public void steer(int dir) {
		this.setSteeringDir(dir);
	}
	
	/*get and set methods*/
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public void setMaxDamage(int maximumDamage) {
		this.maxDamage = maximumDamage;
	}
	
	public int getSteeringDir() {
		return steeringDirection;
	}
	public void setSteeringDir(int dir) {
		steeringDirection = dir;
	}
	public int getMaxSpeed() {
		return maximumSpeed;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energy) {
		this.energyLevel = energy;
	}
	
	public int getEnergyConsumption() {
		return energyConsumptionRate;
	}
	
	public void setEnergyConsumption(int cons) {
		this.energyConsumptionRate = cons;
	}
	
	public int getDamageLevel() {
		return damageLevel;
	}
	
	public void setDamageLevel(int level) {
		this.damageLevel = level;
	}
	
	public int getLastNutReached() {
		return lastNutReached;
	}

	public void setLastNutReached(int nut) {
		this.lastNutReached = nut;
	}
	
	@Override
	public String toString() {
		String parentString = super.toString();
		String sqString = " heading=" + super.getHeading() + " speed=" + super.getSpeed() 
		+ " size=" + super.getSize()
		+ " maxSpeed=" + getMaxSpeed()
		+ " steeringDirection="  + getSteeringDir()
		+ " energyLevel="  + getEnergyLevel()
		+ " damageLevel=" + getDamageLevel();
		
		return parentString + sqString;
	}

}
