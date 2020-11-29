package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/ 

public class Tomato extends Fixed{
	private int nutrition;
	
	/* Tomato constructor */
	public Tomato(float x, float y, int sz, int color) {
		super(x, y, sz, color);
		this.nutrition = super.getSize(); 	// nutrition is porprotional to its own size
	}
	
	/* Setting used Tomato's nutrition = 0 */
	public void eaten() {
		this.nutrition = 0;
	}
		
	/* Get and set methods */
	public int getNutrition() {
		return nutrition;
	}

	public void setNutrition(int nutrition) { 
		this.nutrition = nutrition;
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		/* Tomato = Filled Circle */
		g.setColor(this.getColor());
		int xPoint = (int)(this.getLocation().getX() + pCmpRelPrnt.getX());
		int yPoint = (int)(this.getLocation().getY() + pCmpRelPrnt.getY());
		int s = this.getSize();
		int radius = s / 2;
		
		g.fillArc(xPoint, yPoint, 2*radius, 2*radius, 0, 360);
		
		Font font = g.getFont();
		String text = Integer.toString(this.getNutrition());
		int width = font.stringWidth(text);
		int height = font.getHeight();
		g.setColor(ColorUtil.BLACK);
		g.drawString(text, xPoint - width / 2, yPoint - height / 2);
	}

	@Override
	public boolean collidesWith(GameObject otherObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public String toString() {
		String parentString = super.toString();
		String tomatoString = " capacity=" + getNutrition();
		return "Tomato: " + parentString + tomatoString;
	}
}