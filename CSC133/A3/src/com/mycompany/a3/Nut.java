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

public class Nut extends Fixed {
	/* private attributes*/
	private int seqNum;

	/* Nut Constructor */
	public Nut(float x, float y, int sz, int color, int sNo) {
		super(x, y, sz, color);
		this.seqNum = sNo;
	}
	
	/* Accessor methods */
	public int getSeqNum() {
		return seqNum;
	}
	
	public void setSeqNum(int sNo) {
		this.seqNum = sNo;
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {	
		/* Nut = Filled Isosceles Triangles */
		g.setColor(this.getColor());
		int xPoint = (int)(this.getLocation().getX() + pCmpRelPrnt.getX());
		int yPoint = (int)(this.getLocation().getY() + pCmpRelPrnt.getY());
		int radius = this.getSize() / 2;
		
		int[] xPoints = {xPoint - radius, xPoint, xPoint + radius};
		int[] yPoints = {yPoint - radius, yPoint + radius, yPoint - radius};
	
		g.fillPolygon(xPoints, yPoints, 3);
		
		Font font = g.getFont();
		String text = Integer.toString(this.getSeqNum());
		int width = font.stringWidth(text);
		int height = font.getHeight();
		g.setColor(ColorUtil.BLACK);
		g.drawString(text, xPoint - width / 2, yPoint - height / 2);
	}

	@Override
	public boolean collidesWith(GameObject otherObject) {
		return false;
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		//todo		
	}

	/* printing Nut data into console */
	@Override
	public String toString() {
		String parentString = super.toString();
		String nutString = " size =" + super.getSize() + " seqNum=" + getSeqNum();		
		return "Nut: " + parentString + nutString;
	}
}
