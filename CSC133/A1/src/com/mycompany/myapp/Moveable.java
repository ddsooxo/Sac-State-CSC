package com.mycompany.myapp;
import com.codename1.charts.models.Point;


public abstract class Moveable extends GameObject implements IMoveable{
	private int heading;
	private int speed;
	
	
	public Moveable() {
		//heading = 
		//speed =
	}
	
	public int getHeading() {
		return heading;
	}
	
	public void setHeading(int path) {
		heading = path;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int velocity) {
		speed = velocity;
	}


	public void move() {
		 Point newXY = new Point(0, 0);
		 Point oldXY = getWholeLocation();
		 
	}
	
	//fixed object class Nuts
	class Nuts extends Fixed{
		
		private int sequenceNumber;
		
		//Nuts constructor
		public Nuts() {
			
		}
	}
	
	
	class Tomatoes extends Fixed{
		
		private int nutrition;
		
		public Tomatoes() {
			
		}
	}

}
