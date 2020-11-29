package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

public class Strategy implements IStrategy {
	private NonPlayerSquirrel npSqrl;
	
	public Strategy(NonPlayerSquirrel npc) {
		this.setNpSqrl(npc);
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
	}

	public NonPlayerSquirrel getNpSqrl() {
		return npSqrl;
	}

	public void setNpSqrl(NonPlayerSquirrel npSqrl) {
		this.npSqrl = npSqrl;
	}	
}
