package com.mycompany.a2; 

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

import java.util.Observable;
import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;



public class GameWorld extends Observable implements IGameWorld{
	
	/* private attributes */
	private int lives = 3;
	private int gameClock;
	private int worldWidth;
	private int worldHeight;
	private boolean sound;
	private Random rand = new Random();
	
	
	/* private game objects instances */
	private IIterator gi;
	private GameObjectCollection goc; 
	private PlayerSquirrel sqrl;
	
	private Nut n1 = new Nut(1);		//creating instance of Nut #1
	private Nut n2 = new Nut(2);		//creating instance of Nut #2
	private Nut n3 = new Nut(3);		//creating instance of Nut #3
	private Nut n4 = new Nut(4);		//creating instance of Nut #4
	private Nut n5 = new Nut(5);		//creating instance of Nut #5
	private Nut n6 = new Nut(6);		//creating instance of Nut #6
	private Nut n7 = new Nut(7);		//creating instance of Nut #7
	private Nut n8 = new Nut(8);		//creating instance of Nut #8
	private Nut n9 = new Nut(9);		//creating instance of Nut #9	


	public void init() {
		this.worldHeight = 0;
		this.worldWidth = 0;
		this.sound = false;
		this.goc = new GameObjectCollection();	

		/* Setting Nuts' Locations */
		n1.setLocation(150.0f,200.0f); 	// Nut # 1 at (150.0,200.0)
		n2.setLocation(400.0f,400.0f);	// Nut # 2 at (400.0,400.0)
		n3.setLocation(600.0f,600.0f);	// Nut # 3 at (600.0,600.0)
		n4.setLocation(70.0f,700.0f);	// Nut # 4 at (70.0,700.0)
		n5.setLocation(800.0f,200.0f); 	// Nut # 5 at (800.0,200.0)
		n6.setLocation(450.0f,450.0f);	// Nut # 6 at (450.0,450.0)
		n7.setLocation(650.0f,50.0f);	// Nut # 7 at (650.0,50.0)
		n8.setLocation(30.0f,40.0f);	// Nut # 8 at (30.0,40.0)
		n9.setLocation(999.0f,555.0f);	// Nut # 9 at (999.0,555.0)
		
		/* Adding Player Squirrel */		
		this.sqrl = new PlayerSquirrel(n1.getWholeLocation());
		this.goc.add(sqrl);
		
		/* Adding 3 Non Player Squirrels */
		this.addNPC();

		/* Adding Nuts 1 through 9 */
		this.goc.add(n1);
		this.goc.add(n2);
		this.goc.add(n3);
		this.goc.add(n4);
		this.goc.add(n5);
		this.goc.add(n6);
		this.goc.add(n7);
		this.goc.add(n8);
		this.goc.add(n9);
		
		/* Adding Birds */
		this.addBirds();
		
		/* Adding Tomatos */
		this.addTomatos();

		this.notifyChanges();
	}
	
		
	/* Adding 3 NonPlayeSquirels*/
	public void addNPC() {
		for (int i = 0; i < 3; i++) {
			float x = rand.nextInt(991) + 5;  // generates random x value 5 and 1000
			float y = rand.nextInt(991) + 5; // generates random y value 5 and 1000
		
			NonPlayerSquirrel npc = new NonPlayerSquirrel(x,y);
			int choice = rand.nextInt(2);
			
			if (choice == 0) 
				npc.setStrategy(new  AttackStrategy(npc));
			else
				npc.setStrategy(new  FollowNutStrategy(npc));
			goc.add(npc);
		}
	}
		
	/* Adding 2 Tomatos*/
	public void addTomatos() {
		Tomato t = new Tomato();
		for(int i = 0; i < 2; i++) {		
			goc.add(t);
		}
	}
	
	/* Adding 2 birds*/
	public void addBirds() {
		Bird b = new Bird();
		for(int i = 0; i < 2; i++) {
			goc.add(b);
		}
		
	}
	
	/* Player Squirrel Accelerate [game command a] */
	public void acceleratePlayerSquirrel(){		
		if (sqrl != null && sqrl.getSpeed() != sqrl.getMaxSpeed() && sqrl.getDamageLevel() < sqrl.getMaxDamage()){
			sqrl.setSpeed(sqrl.getSpeed() + 1);	
		} else {
			System.out.println("Oops! Unable to accelerate because "
					+ "either a Squirrel doesn't exist "
					+ "or it reached maximum speed level"
					+ "or it reached maximum damage level!");
		}
	}	
	
	/* Player Squirrel Brakes [game command b] */
	public void brakePlayerSquirrel() {
		if(sqrl.getSpeed() > 0 || sqrl.getSpeed() < sqrl.getMaxSpeed()) {
			sqrl.setSpeed(sqrl.getSpeed() - 1);
			System.out.println("*Brake is applied!*");
		} else {
			System.out.println("Oops! Unable to brake! Squirrel speed is at 0!");
		}
	}
	
	/* Player Squirrel Steer Left [game command l] */
	public void steerLeft() {
		//as long as squirrl exists, squirrel energyLevel is not 0, steering direction does not equal -40 degrees and squirrel speed != max speed or speed = 0
		if(sqrl != null && sqrl.getSpeed() != sqrl.getMaxSpeed() 
				&& sqrl.getEnergyLevel() != 0 && sqrl.getSteeringDir()!= -40) {
			System.out.println("*Steering squirrel to the left*");
			sqrl.steer((int) (sqrl.getSteeringDir() - 5));
		}
		else {
			System.out.println("Oops! unable to steer left!");
		}
	}
	
	/* Player Squirrel Steer Right [game command r] */
	public void steerRight() {
		//as long as squirrl exists, squirrel energyLevel is not 0,steering direction does != +40 degrees and squirrel speed != max speed or speed = 0
		if(sqrl != null && sqrl.getSpeed() != sqrl.getMaxSpeed() 
				&& sqrl.getEnergyLevel() != 0 && sqrl.getSteeringDir()!= 40) {
			System.out.println("*Steering squirrel to the right*");
			sqrl.steer((int) (sqrl.getSteeringDir() - 5));
		}
		else {
			System.out.println("Oops! unable to steer right!");
		}
	}
	
	/* Collide with a NonPlayerSquirrel [game command c] */
	public void collideWithNpc() {
		System.out.println("*Collision with a NonPlayerSquirrel Squirrel detected!");

		int npcCount = 0;
		this.gi = this.goc.getIterator();
		
		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof NonPlayerSquirrel) {
				if (((NonPlayerSquirrel)(tmp)).getEnergyLevel() != 0) {
					npcCount++;
				}
			}
		}
		
		int chosen = rand.nextInt(npcCount) + 1;	
		npcCount = 0;
		this.gi = this.goc.getIterator();
	
		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof NonPlayerSquirrel) {
				if (((NonPlayerSquirrel)(tmp)).getEnergyLevel() != 0) {
					npcCount++;
				}
				if (npcCount == chosen) {
					//fade Player Squirrel color + increase damage level
					sqrl.setColor(188,143,143);
					
					//always choosing the same NonPlayerSquirrel to collide Player Squirrel with...
					sqrl.setLocation(((NonPlayerSquirrel) tmp).getWholeLocation());
					((NonPlayerSquirrel) tmp).setLastNutReached(sqrl.getLastNutReached());
					
					//add damage to NonPlayerSquirrel 
					if(((NonPlayerSquirrel) tmp).getDamageLevel() < ((NonPlayerSquirrel) tmp).getMaxDamage()) {
						((NonPlayerSquirrel) tmp).setDamageLevel(((NonPlayerSquirrel) tmp).getDamageLevel() + 10);	
					}
				
					//add damage to player Squirrel
					if(sqrl.getDamageLevel() < sqrl.getMaxDamage()) {
						sqrl.setDamageLevel(sqrl.getDamageLevel() + 20);	
						sqrl.setSpeed(sqrl.getSpeed() - 5);
						System.out.println("Squirrel Player speed has been decreased. New Speed is " + sqrl.getSpeed());
					}
							
					//if squirrel damage level results in not being able to move, player loses a life
					if(sqrl.getDamageLevel()>= sqrl.getMaxDamage()){
						System.out.println("Critical! Squirrel damage level is at its maximum level");
						this.loseLife();
					}
							
					break;
				}
			}
		}

		this.notifyChanges();
	}
	
	/* Collide between Nut 1 through Nut 9 */
	public void collideWithNuts(int x) {
		int getNutCount = 9;
		
		if(x > getNutCount || x < 1) {
			Command cOk = new Command("Ok");
			Dialog.show("Error", "Invalid nut # ", cOk);
		}
		
		System.out.println("Collided with Nut Sequence: " + x);
		
		//when Squirrel visits nut number exactly 1 higher than the current value of lastNutReached
		if(x >= sqrl.getLastNutReached() + 1) {
			this.sqrl.setLastNutReached(x);
			
			this.gi = goc.getIterator();
			while(gi.hasNext()) {
				GameObject tmp = (GameObject) gi.getNext();
				if(tmp instanceof Nut) {
					int nutNum = ((Nut) tmp).getSeqNum();
					if(nutNum == x) {
						sqrl.setLocation(tmp.getWholeLocation());
					}
					
				}
			}

		}
		
		//when player squirrel reaches the last nut, player wins
		if(this.getLastNutReached() == getNutCount) {
			this.gameWin();
		}	
		
		this.notifyChanges();
	}

	/* Collide with a Tomato [game command e] */
	public void collideWithTomatoCommand() {
		System.out.println("*Collision with a Tomato detected!");
		int tCount = 0;
		this.gi = this.goc.getIterator();
		
		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof Tomato) {
				if (((Tomato)(tmp)).getNutrition() != 0) {
					tCount++;
				}
			}
		}
		
		int chosen = rand.nextInt(tCount) + 1;	
		tCount = 0;
		this.gi = this.goc.getIterator();
	
		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof Tomato) {
				if (((Tomato)(tmp)).getNutrition() != 0) {
					tCount++;
				}
				if (tCount == chosen) {
					this.sqrl.setEnergyLevel( this.sqrl.getEnergyLevel() + ((Tomato) tmp).getNutrition());
					sqrl.setLocation(((Tomato) tmp).getWholeLocation());
					((Tomato) tmp).setColor(200, 0, 100);
					((Tomato) tmp).setNutrition(0);
					goc.add(new Tomato());
					break;
				}
			}
		}
		
		this.notifyChanges();
	}
	
	/* Collide With Bird [game command g] */
	public void collideWithBirdCommand() {
		//the damage caused by a bird is half the damage caused by colliding with another npc squirrel
		System.out.println("*Collision with a Bird detected!");
		
		
		int bCount = 0;
		this.gi = this.goc.getIterator();
		
		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof Bird) {
				if (((Bird)(tmp)).getSpeed() != 0) {
					bCount++;
				}
			}
		}
		
		int chosen = rand.nextInt(bCount) + 1;	
		bCount = 0;
		this.gi = this.goc.getIterator();
	
		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof Bird) {
				if (((Bird)(tmp)).getSpeed() != 0) {
					bCount++;
				}
				if (bCount == chosen) {
					//fade Squirrel color, increase damage level 
					this.sqrl.setColor(188,143,143);
					this.sqrl.setDamageLevel(sqrl.getDamageLevel() + 10);
					this.sqrl.setLocation(tmp.getWholeLocation());
					this.sqrl.setSpeed(sqrl.getSpeed() - ((Bird) tmp).getSpeed()); //reduce speed of Squirrel
					
					if(sqrl.getDamageLevel() >= (sqrl.getMaxDamage()/2)) {
						//sets squirrel speed level to 1/2 of its current speed
						sqrl.setSpeed(sqrl.getSpeed()/2);
					}
					
					if(sqrl.getDamageLevel()!= sqrl.getMaxDamage()) {
						sqrl.setDamageLevel(sqrl.getDamageLevel() + 20);	
					}

					//if squirrel damage level results in not being able to move, player loses a life
					if(sqrl.getDamageLevel()>= sqrl.getMaxDamage()){
						Command cOk = new Command("Ok");
						Dialog.show("Critical Damage!", "Squirrel Damage Level has reached its maximum.", cOk);
						this.loseLife();	
					}	
					
					break;
				}
			}
		}
		this.notifyChanges();
	}
	

	/* change strategies command */
	public void changeStrategies() {
		System.out.println("====***change strategies is pressed***====");
		
		this.gi = this.goc.getIterator();
		
		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			
			if (tmp instanceof NonPlayerSquirrel) {
				NonPlayerSquirrel npc = (NonPlayerSquirrel) tmp;
				
				if (npc.getStrat() instanceof AttackStrategy) {
					int seq = ((NonPlayerSquirrel) tmp).getLastNutReached();
					npc.setLastNutReached(seq + 1);
					npc.setStrategy(new FollowNutStrategy(npc));
				} else {
					npc.setStrategy(new AttackStrategy(npc));
				}
			}
		}
		
		this.notifyChanges();
	}
	
	/* Colliding With Tomato [game command t] */
	public void tickCommand() {
		
		//change Player Squirrel heading depending on its steering direction
		if(sqrl.getEnergyLevel()!= 0 && sqrl.getDamageLevel() < sqrl.getMaxDamage() && sqrl.getSpeed() != 0) {
			sqrl.setHeading(sqrl.getHeading() + sqrl.getSteeringDir());
			sqrl.setEnergyLevel(sqrl.getEnergyLevel() - 5); //energy level decrements by 5 each tick
			sqrl.move();
		}
		
		if(sqrl.getEnergyLevel() <= 0) {
			System.out.println("Player Energy Level at 0!");
			this.loseLife();
		}
		
		
		//move NPC player and invoke strategy
		while(gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			
			if(tmp instanceof NonPlayerSquirrel) {
				((NonPlayerSquirrel) tmp).move();
				((NonPlayerSquirrel) tmp).invokeStrategy();
				
				if(((NonPlayerSquirrel) tmp).getEnergyLevel() == 0) {
					((NonPlayerSquirrel) tmp).setEnergyLevel(100);
				}
				
			}
		}
		
		//set Bird's heading to either +5 or -5
		int r = rand.nextInt(1);
		
		while(gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			
			if(tmp instanceof Bird) {
				if(r == 0) {
					((Bird)tmp).setHeading(((Bird)tmp).getHeading() + 5);
				}else {
					((Bird)tmp).setHeading(((Bird)tmp).getHeading() - 5);
				}
				
				((Bird) tmp).move();
			}
		}
	
		this.gameClock++; //increment game clock by +1
		this.notifyChanges();	
		System.out.println("Printing gameClock after tick : " + this.gameClock);

	}
	
	
	/* Printing Game Map [game command m] */
	public void printMap() {
		System.out.println("======================== Printing Updated Map ========================");
		
		/* iterating through gameobject collection objects and printing toString method */
		this.gi = this.goc.getIterator();
		while (gi.hasNext()) {			
			GameObject go = (GameObject) gi.getNext();
			System.out.println(go.toString());
		}
	}
	
	/*Notifying Observer*/
	public void notifyChanges() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/* Resetting game init() method */
	public void resetInit() {
		this.init();
		this.gameClock++;
		if(this.lives == 0) {
			this.gameOver();
		}
	} 
	
	/* When Squirrel Player loses a life*/
	public void loseLife() {
		this.lives--;
		
		Command cOk = new Command("Ok");
		Dialog.show("Squirrel player loses a life!", "Lives remaining: "  + this.lives , cOk);
		this.resetInit();//re-initialize GW
		
		if(this.lives == 0) {
			Command cOk1 = new Command("Ok");
			Dialog.show("\"Oh no!! Squirrel Player has lost all 3 lives!!!", "Better luck next time! ", cOk1);
			this.gameOver();
		}	
	}
	
	/* When Squirrel runs out of lives, game ends! */
	public void gameOver() {
		Boolean cOk = Dialog.show("Game Over! You failed!", "Total Time: "  + this.gameClock , "Ok", null);
		
		if(cOk) {
			Display.getInstance().exitApplication();
		}
	}
	
	/* Player squirrel reaches the last nut in the garden, the game ends */
	public void gameWin() {
		
		Boolean cOk = Dialog.show("Game over", "Congratulations, you won! You reached the "
				+ "last nut of the garden! "
				+ "\nTotal time:" +  this.gameClock  , "Ok", null);
		
		if(cOk) {
			Display.getInstance().exitApplication();
		}
	}
	
	/* Accessor methods for ScoreView class*/
	public int getTime() {
		return this.gameClock;
	}

	public int getLivesLeft() {
		return this.lives;
	}
	
	public int getLastNutReached() {
		return sqrl.getLastNutReached();
	}

	public int getPlayerEnergyLevel() {
		return sqrl.getEnergyLevel();
	}

	public int getPlayerDamageLevel() {
		return sqrl.getDamageLevel();
	}

	public boolean getSound() {
		return sound;
	}
	
	public void setSound() {		
		if(sound)
			sound = false;
		else
			sound = true;
	}
	
	public void toggleSound() {
		this.sound = !this.sound;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getWidth() {
		return this.worldWidth;
	}
	
	public int getHeight() {
		return this.worldHeight;
	}
	
	public void setDimensions(int x, int y) {
		this.worldWidth = x;
		this.worldHeight = y;
	    this.setChanged();
	}
	
}
