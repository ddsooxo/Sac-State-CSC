package com.mycompany.a2;

import com.codename1.charts.models.Point;

public class PlayerSquirrel extends Squirrel {
	public PlayerSquirrel(Point loc) {
		super(loc);	
	}

	public PlayerSquirrel(float x, float y) {
		super(x, y);
	}

	@Override
	public String toString() {
		String parentString = super.toString();
		return "Squirrel: " + parentString;
	}
}
