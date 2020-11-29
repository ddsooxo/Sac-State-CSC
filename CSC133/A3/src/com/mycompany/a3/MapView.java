package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;
import com.codename1.ui.Graphics;

public class MapView extends Container implements Observer {
	/* This class contains code to output the map */
	TextArea gameText;
	GameWorld gw;

	public MapView(GameWorld gameWorld) {
		this.gw = gameWorld;
	}
	
	@Override
	public void update(Observable observable, Object data){
		if(observable instanceof GameWorld){
			((GameWorld)observable).printMap();
		}
		this.repaint();	
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
		
		IIterator objs = gw.getCollection().getIterator();
		while (objs.hasNext()) {
			GameObject obj = (GameObject) objs.getNext();
			if (obj instanceof IDrawable) {
				(obj).draw(g, pCmpRelPrnt);
			}
		}	
	}
	
	public float getMapWidth(){
		return (float) this.getWidth();
	}
	
	public float getMapHeight(){
		return (float) this.getHeight();
	}
}
