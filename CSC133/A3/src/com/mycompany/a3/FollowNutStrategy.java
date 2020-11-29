package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

public class FollowNutStrategy extends Strategy implements IStrategy{
	private Nut nut;
	
	public FollowNutStrategy(NonPlayerSquirrel npc, Nut nutNum) {
		super(npc);
		this.nut = nutNum;
	}

	public Nut getNut() {
		return nut;
	}

	public void setNut(Nut nut) {
		this.nut = nut;
	}
}
