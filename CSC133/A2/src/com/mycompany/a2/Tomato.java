package com.mycompany.a2;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

public class Tomato extends Fixed{

	private int nutrition;
	
	/* Tomato constructor */
	public Tomato() {
		setColor(255,0,0); //RED
		setSize(rand.nextInt(41) + 10); 	// generates random int size between 10 and 50
		this.nutrition = super.getSize(); 	// nutrition is porprotional to its size
	}

	/* get and set methods */
	public int getNutrition() {
		return nutrition;
	}

	public void setNutrition(int nutrition) { 
		this.nutrition = nutrition;
	}
	
	@Override
	public String toString() {
		String parentString = super.toString();
		String tomatoString = " size=" + super.getSize() + " capacity=" + getNutrition();
		return "Tomato: " + parentString + tomatoString;
	}

}
	
	

