package com.mycompany.a2;

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
		
		
		Point npcLoc = npSqrl.getWholeLocation();
		Point sqrlLoc = sqrl.getWholeLocation();
		
		
		deltaX = (sqrlLoc.getX() - npcLoc.getX());
		deltaY = (sqrlLoc.getY() - npcLoc.getY());
		
		targetHeading = (MathUtil.atan2(deltaX, deltaY));
		npsHeading = (int)(90 - Math.toDegrees(targetHeading));
		npSqrl.setHeading(npsHeading);
		
	}

	
	
	
}
