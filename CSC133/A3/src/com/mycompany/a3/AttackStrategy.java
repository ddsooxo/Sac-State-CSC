package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import com.codename1.charts.models.Point;
import com.codename1.util.MathUtil;

public class AttackStrategy extends Strategy implements IStrategy{

	private NonPlayerSquirrel npSqrl;
	private PlayerSquirrel sqrl;
	
	public AttackStrategy(NonPlayerSquirrel npc) {
		super(npc);
	}
	
	public void apply() {
		float deltaX;
		float deltaY;
		int npsHeading;
		double targetHeading;
	
		Point npcLoc = npSqrl.getLocation();
		Point sqrlLoc = sqrl.getLocation();	
		
		deltaX = (sqrlLoc.getX() - npcLoc.getX());
		deltaY = (sqrlLoc.getY() - npcLoc.getY());
		
		targetHeading = (MathUtil.atan2(deltaX, deltaY));
		npsHeading = (int)(90 - Math.toDegrees(targetHeading));
		npSqrl.setHeading(npsHeading);
	}
}
