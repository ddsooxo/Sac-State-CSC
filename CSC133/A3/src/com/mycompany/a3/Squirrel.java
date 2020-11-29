package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/ 

public abstract class Squirrel extends Movable implements ISteerable{	
	/* private Squirrel attributes */
	private int maxDamage = 50;
	private int steeringDir = 0;
	private int maximumSpeed = 50;
	private double energyLevel = 100;
	private double energyConsumptionRate = 0.25;
	private int damageLevel = 0;
	private int lastNutReached = 1;
	
	public Squirrel(float x, float y, int size, int rgb) {
		super(x, y, size, rgb);
		super.setHeading(0);
		super.setSpeed(0);
	}

	/* Get and Set Methods*/
	public int getMaxSpeed() {
		return this.maximumSpeed;
	}
	
	public void setMaxDamage(int damage) {
		this.maxDamage = damage;
	}
	
	public int getSteeringDir() {
		return this.steeringDir;
	}
	
	public void setSteerDir(int value) {
		this.steeringDir = value;
	}
	
	public double getEnergyLevel() {
		return this.energyLevel;
	}
	
	public void setEnergyLevel(double energy) {
		this.energyLevel = energy;
	}
	
	public int getDamageLevel() {
		return this.damageLevel;
	}
	
	public void setDamageLevel(int damage) {
		this.damageLevel = damage;
	}
	
	public int getLastNutReached() {
		return this.lastNutReached;
	}
	
	public void setLastNutReached(int nut) { 
		this.lastNutReached = nut;
	}
		
	public int getMaxDamage() {
		return this.maxDamage;
	}
	
	public void consumeEnergy() {
		double remainingEnergy = this.energyLevel - this.energyConsumptionRate;
		
		if (remainingEnergy > 0) {
			this.setEnergyLevel(remainingEnergy);
		} else {
			this.setEnergyLevel(0);
		}
	}
	
	public void steer() {
		this.setHeading(this.getHeading() + this.getSteeringDir());
		super.adjustHeading();
	}
	
	public void takeDamage(int damage) {
		int currentDamage = this.getDamageLevel();
		this.maxDamage = this.getMaxDamage();
		currentDamage += damage;
		this.setDamageLevel(currentDamage);
		if (currentDamage > 0 && currentDamage < maxDamage) {
			this.damageLevel++;
		} else {
			this.setSpeed(0);
		}
	}
	
	private void collideWithNut(int seqNum) {
		if (this.getLastNutReached() + 1 == seqNum) this.setLastNutReached(seqNum);	
	}
	
	private void collideWithTomato(int capacity) {
		this.setEnergyLevel(this.getEnergyLevel() + capacity);
	}

	@Override
	public void handleCollision(ICollider otherObject) {
		if (otherObject instanceof Nut) {
			this.collideWithNut(((Nut)otherObject).getSeqNum());
		}
		if (otherObject instanceof Tomato) {
			Tomato t = (Tomato)otherObject;
			if (t.getNutrition()!= 0) {
				this.collideWithTomato(t.getNutrition());
			}
		}
		if (otherObject instanceof Bird) {
			this.takeDamage(1);
		}
		if (otherObject instanceof Squirrel) {
			this.takeDamage(2);
		}
	}
	
	/* Print Squirrel data to console*/
	@Override
	public String toString() {
		String parentString = super.toString();
		String sqrlString = " heading=" + super.getHeading() + " speed=" + super.getSpeed() 
					+ " steeringDirection=" + this.getSteeringDir()
					+ " energyLevel=" + this.getEnergyLevel()
					+ " damageLevel=" + this.getDamageLevel()
					+ " lastNutReached=" + this.getLastNutReached();
		
		return parentString + sqrlString;
	}
}