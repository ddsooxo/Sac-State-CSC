package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;

public class MapView extends Container implements Observer {

	/* This class contains code to output the map */
	TextArea gameText;

	public MapView() {
		
		this.setWidth(1000);  // setting GameWorld Width to 1000
		this.setHeight(1000); // setting GameWorld Height to 1000
		
	}
	
	@Override
	public void update(Observable observable, Object data){
		if(observable instanceof GameWorld){
			((GameWorld)observable).printMap();
		}
		
		this.repaint();
		
	}
}
