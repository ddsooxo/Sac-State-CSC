package com.mycompany.a2;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

public class Bird extends Moveable {
	
	public Bird() {
		
		setSpeed(rand.nextInt(6) + 5);	// generates random int speed between 5 and 10
		setSize(rand.nextInt(41) + 10); // generates random int size between 10 and 50
		setHeading(rand.nextInt(359)); 	// generates random int heading between 0 and 359
		setColor(0,0,255); 				// BLUE
	}

	@Override
	public String toString() {
		String parentString = super.toString();
		String birdString = " heading=" + super.getHeading() + " speed=" + super.getSpeed() + " size=" + super.getSize();
		
		return "Bird: " + parentString + birdString;
	}

	
}
