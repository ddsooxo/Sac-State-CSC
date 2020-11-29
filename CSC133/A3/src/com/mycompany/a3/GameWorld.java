package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import java.util.Observable;
import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;

public class GameWorld extends Observable implements IGameWorld {

	/* private game attributes */
	private int lives = 3;
	private int gameClock = 0; // total count of time elapsed
	private int secs = 0; // storing time
	private float w;
	private float h;
	private boolean sound;
	private Random rand = new Random();

	/* private game objects instances */
	private IIterator gi;
	private GameObjectCollection goc;
	private PlayerSquirrel sqrl;

	public void init(float width, float height) {
		this.w = width;
		this.h = height;
		this.sound = false;
		this.goc = new GameObjectCollection();
		
		/* Adding 9 Random Nuts */
		this.addNuts();
		/* Adding one player squirrel */
		this.addSquirrelPlayer();
		/* Adding 3 Non Player Squirrels */
		this.addNPC();
		/* Adding Birds */
		this.addBirds();
		/* Adding Tomatoes */
		this.addTomatos();

		this.notifyChanges();
	}

	/* Adding 4 Random Nuts */
	public void addNuts() {
		int color = ColorUtil.rgb(224, 195, 157); // BEIGE: NUT COLOR
		int size = 150;
		Nut n1 = new Nut(650.0f, 450.0f, size, color, 1); 		// creating instance of Nut #1
		Nut n2 = new Nut(400.0f, 200.0f, size, color, 2); 		// creating instance of Nut #2
		Nut n3 = new Nut(600.0f, 600.0f, size, color, 3); 		// creating instance of Nut #3
		Nut n4 = new Nut(70.0f, 700.0f, size, color, 4); 		// creating instance of Nut #4
		Nut n5 = new Nut(987.0f, 357.0f, size, color, 5); 		// creating instance of Nut #5
		Nut n6 = new Nut(1200.0f, 600.0f, size, color, 6); 		// creating instance of Nut #6
		Nut n7 = new Nut(777.0f, 577.0f, size, color, 7); 		// creating instance of Nut #7
		Nut n8 = new Nut(1500.0f, 178.0f, size, color, 8); 		// creating instance of Nut #8
		Nut n9 = new Nut(850.0f, 900.0f, size, color, 9); 		// creating instance of Nut #9

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
	}

	/* Adding PlayeSquirel */
	public void addSquirrelPlayer() {
		Nut nutOne = this.getNutBySequence(1); 						// first nut Object
		float xPoint = (float) (Math.round(nutOne.getLocX()));
		float yPoint = (float) (Math.round(nutOne.getLocY()));
		int color = ColorUtil.rgb(189, 91, 11); 					// CHESTNUT: PLAYER SQUIRREL COLOR
		
		this.sqrl = new PlayerSquirrel(xPoint, yPoint, 59, color);
		this.goc.add(sqrl);
		
		this.notifyChanges();
	}

	/* Adding 3 NonPlayeSquirels. */
	public void addNPC() {
		Nut nutOne = this.getNutBySequence(1); 						// first nut Object
		int color = ColorUtil.rgb(186, 183, 166); 					// TAUPE: NPC COLOR

		for (int i = 0; i < 3; i++) {
			float xPoint = rand.nextInt((int) nutOne.getLocX());
			float yPoint = rand.nextInt((int) nutOne.getLocY());
			NonPlayerSquirrel npc = new NonPlayerSquirrel(xPoint, yPoint, 65, color);

			int choice = rand.nextInt(2);
			if (choice == 0) {
				npc.setStrategy(new AttackStrategy(npc));
			} else {
				npc.setStrategy(new FollowNutStrategy(npc, this.getNutBySequence(2)));
			}
			
			if (choice == 0)
				npc.setStrategy(new AttackStrategy(npc));
			else
				npc.setStrategy(new FollowNutStrategy(npc, this.getNutBySequence(2)));

			this.goc.add(npc);
		}
		this.notifyChanges();
	}

	/* Grabbing first nut object by nut sequence number */
	public Nut getNutBySequence(int seqNo) {
		this.gi = this.goc.getIterator();

		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof Nut && ((Nut) (tmp)).getSeqNum() == seqNo) {
				return (Nut) tmp;
			}
		}
		return null;
	}

	/* Adding 2 Tomatoes */
	public void addTomatos() {
		int color = ColorUtil.rgb(194, 16, 2);
		int sz = rand.nextInt(31) + 80;
		
		Tomato t1 = new Tomato(585.0f, 250.0f, sz, color);
		Tomato t2 = new Tomato(234.0f, 663.0f, sz, color);

		this.goc.add(t1);
		this.goc.add(t2);

		this.notifyChanges();
	}

	/* Adding 2 birds */
	public void addBirds() {
		int color = ColorUtil.rgb(125, 217, 240); 											// BABY-BLUE: BIRD COLOR
		int sz = rand.nextInt(80) + 31; 													// generates random int size between 50 and 80
		int speed = rand.nextInt(6) + 5; 													// generates random int speed between 5 and 10
		int heading = rand.nextInt(359); 													// generates random int heading between 0 and 359

		for (int i = 0; i < 2; i++) {
			float xPoint = rand.nextInt(501) + 500;
			float yPoint = rand.nextInt(501) + 500;

			Bird b = new Bird(xPoint, yPoint, sz, color, heading, speed);
			goc.add(b);
		}
	}

	/* Player Squirrel Accelerate [game command a] */
	public void acceleratePlayerSquirrel() {
		if (sqrl != null && sqrl.getSpeed() != sqrl.getMaxSpeed() && sqrl.getDamageLevel() < sqrl.getMaxDamage()
				&& sqrl.getEnergyLevel() != 0) {
			int currSpeed = this.sqrl.getSpeed();
			int scaledSpeed = (int) ((double) sqrl.getMaxSpeed()
					* (1 - (double) sqrl.getDamageLevel() / (double) sqrl.getMaxDamage()));

			if (currSpeed + 2 > scaledSpeed) {
				this.sqrl.setSpeed(scaledSpeed);
				System.out.println("Player at maximum speed:  " + scaledSpeed);
			} else {
				this.sqrl.setSpeed(currSpeed + 5);
				System.out.println("Speed accelerates by 2. Your current speed is " + this.sqrl.getSpeed());
			}

		} else {
			System.out.println("Oops! Unable to accelerate because " + "either a Squirrel doesn't exist "
					+ "or maximum speed level reached " + "or maximum damage level reached "
					+ "or energey level reached 0!");
		}
	}

	/* Player Squirrel Brakes [game command b] */
	public void brakePlayerSquirrel() {
		if (sqrl.getSpeed() > 0 || sqrl.getSpeed() < sqrl.getMaxSpeed()) {
			sqrl.setSpeed(sqrl.getSpeed() - 2);
			System.out.println("*Brake is applied!*");
		} else {
			System.out.println("Oops! Unable to brake! Squirrel speed is at 0!");
		}
	}

	/* Player Squirrel Steer Left [game command l] */
	public void steerLeft() {
		/*
		 * As long as squirrel exists, squirrel energyLevel is not 0, steering direction
		 * is greater than -40 degrees and
		 * 
		 */
		if (this.sqrl.getSteeringDir() > -40) {
			this.sqrl.setSteerDir(this.sqrl.getSteeringDir() - 5);

			System.out.println("Steer left by 5. Your steering direction is " + this.sqrl.getSteeringDir());
		} else {
			System.out.println("Oops! unable to steer left!");
		}
	}

	/* Player Squirrel Steer Right [game command r] */
	public void steerRight() {
		/*
		 * as long as squirrel exists, squirrel energyLevel is not 0 steering direction
		 * is less than +40 degrees and squirrel speed != max speed or speed = 0
		 * 
		 */
		if (this.sqrl.getSteeringDir() > -40) {
			this.sqrl.setSteerDir(this.sqrl.getSteeringDir() + 5);
		} else {
			System.out.println("Oops! unable to steer right!");
		}
	}

	/* change strategies command */
	public void changeStrategies() {
		System.out.println(" ======================== Change Strategies Detected ========================");

		this.gi = this.goc.getIterator();

		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();

			if (tmp instanceof NonPlayerSquirrel) {
				NonPlayerSquirrel npc = (NonPlayerSquirrel) tmp;

				if (npc.getStrat() instanceof AttackStrategy) {
					Nut nextNut = this.getNutBySequence(npc.getLastNutReached() + 1);
					npc.setStrategy(new FollowNutStrategy(npc, nextNut));
				} else {
					npc.setStrategy(new AttackStrategy(npc));
				}

			}
		}

		this.notifyChanges();
	}

	public void tick(int t) {

		/* Change Player Squirrel heading depending on its steering direction */
		if (sqrl.getEnergyLevel() != 0 && sqrl.getDamageLevel() < sqrl.getMaxDamage() && sqrl.getSpeed() != 0) {

			sqrl.setHeading(sqrl.getHeading() + sqrl.getSteeringDir());
			sqrl.setEnergyLevel(sqrl.getEnergyLevel() - 2); 							// energy level decrements by 2 each tick
			sqrl.consumeEnergy();
			sqrl.steer();
			sqrl.move(t);
		}

		/*
		 * Checking if Player Squirrel Energy Level is 0 or if Player Squirrel Damage
		 * Level reached its Max Damage
		 */
		if (sqrl.getEnergyLevel() <= 0 || sqrl.getDamageLevel() == sqrl.getMaxDamage()) {
			System.out.println("Player Energy Level at 0!");
			this.loseLife();
		}

		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();

			/* NPC Section + Invoke strategy */
			if (tmp instanceof NonPlayerSquirrel) {
				((NonPlayerSquirrel) tmp).invokeStrategy();
				((NonPlayerSquirrel) tmp).steer();
				((NonPlayerSquirrel) tmp).move(t);
				if (((NonPlayerSquirrel) tmp).getEnergyLevel() == 0) {
				((NonPlayerSquirrel) tmp).setEnergyLevel(60); 							// restore NPC Energy Level after collision
				}
			}

			/* Bird Section + Setting heading to either +5 or -5 */
			int r = rand.nextInt(1);
			if (tmp instanceof Bird) {
				if (r == 0) {
					((Bird) tmp).setHeading(((Bird) tmp).getHeading() + 5);
				} else {
					((Bird) tmp).setHeading(((Bird) tmp).getHeading() - 5);
				}

				((Bird) tmp).move(t);
			}
		}

		this.secs += t;
		if (this.secs % 1000 == 0) {
			this.secs = 0;
			this.gameClock++; 															// increment game clock
		}

		System.out.println("Printing gameClock after tick : " + this.gameClock);

		this.collision();
		this.notifyChanges();
	}

	/*
	 * =============================Make new methods for collision detection *In Progress* ========================== 
	 * detect NPC Collision, Bird Collision, Tomato Collision, Nut Collision
	 * 
	 * Note: In the previous assignment, collisions were caused by pressing one of
	 * the pretend collision buttons (i.e., Collide With NPC, Collide With Nut,
	 * Collide With Bird, Collide with Tomato) and the objects involved in the
	 * collision were chosen arbitrarily. Now, the type of collision will be
	 * detected automatically during collision detection, so the pretend collision
	 * buttons are no longer needed and should be removed.
	 * 
	 * make method called collision() to detect collisions among game objects
	 * add sounds for: crash, dead, victory
	 * 
	 * =============================Make new methods for collision detection: *In Progress* ==========================
	 */

	public void collision() {
		this.gi = this.goc.getIterator();

		while (gi.hasNext()) {
			GameObject tmp = (GameObject) gi.getNext();
			if (tmp instanceof Movable) {
				if (tmp instanceof ICollider) {
					IIterator gi2 = this.goc.getIterator();
					while (gi2.hasNext()) {
						GameObject tmp2 = (GameObject) gi2.getNext();
						if (tmp2 instanceof ICollider && !tmp.equals(tmp2)) {
							if (tmp.collidesWith(tmp2)) {
								tmp.handleCollision(tmp2);

								/* Collision with a Tomato */
								if (tmp instanceof Squirrel && tmp2 instanceof Tomato) {
									Tomato t = (Tomato) tmp2;

									/*
									 * set tomato's nutrition to zero(if it's not already zero) fade it to light red
									 * then, add a new random tomato
									 *
									 **/
									if (t.getNutrition() != 0) {
										t.eaten();
										t.setColor(255, 133, 133); 						// LIGHT PINK : TOMATO COLOR AFTER EATEN

										float xPoint = (float) (Math.round(((this.w + 1.0) * rand.nextDouble() * 10.0))
												/ 10.0);
										float yPoint = (float) (Math.round(((this.h + 1.0) * rand.nextDouble() * 10.0))
												/ 10.0);

										int color = ColorUtil.rgb(255, 0, 0); 			// RED: TOMATO COLOR
									int sz = rand.nextInt(41) + 10; 					// generates random int size between 10 and 50

										/* adding new Tomato into the game world */
										this.getCollection().add(new Tomato(xPoint, yPoint, sz, color));
									}
								}

								/* Collision with a Nut */
								if (tmp instanceof Squirrel && tmp2 instanceof Nut) {
									/*
									 * check if player squirrel reached the last nut in the garden. if so, player
									 * squirrel wins the game. set Player Squirrel's last nut reached to the one it
									 * collided with check if Non player squirrel reached the last nut. if so,
									 * player squirrel loses the game
									 *
									 **/

									/* win or loose checks */
									if (tmp instanceof PlayerSquirrel
											&& this.sqrl.getLastNutReached() == this.goc.getNutCount()) {
										this.gameWin();
									} else {
										if (((NonPlayerSquirrel) tmp).getLastNutReached() == this.goc.getNutCount()) {
											this.gameOver();
										}
									}
									/* when Squirrel visits nut number exactly 1 higher than the current value of lastNutReached */
									if (this.sqrl.getLastNutReached() >= sqrl.getLastNutReached() + 1) {
										this.sqrl.setLastNutReached(this.sqrl.getLastNutReached());
									}

								}

								/* Collision with a Bird or Nonplayer Squirrel */
								if (tmp instanceof PlayerSquirrel && tmp2 instanceof Movable) {
									if (this.sqrl.getDamageLevel() >= this.sqrl.getMaxDamage()) {
										// play dead sound
									} else {
										// play crash sound
									}
								} else if (tmp instanceof Squirrel && tmp2 instanceof Movable) {
									// play crash sound
								}
							}
						}
					}
				}
			}
		}

	}

	/* Printing Game Map [game command m] */
	public void printMap() {
		/*
		 * iterating through game-object collection objects and printing toString method
		 */
		System.out.println("======================== Printing Updated Map ========================");
		this.gi = this.goc.getIterator();
		while (gi.hasNext()) {
			GameObject go = (GameObject) gi.getNext();
			System.out.println(go.toString());
		}
	}

	/* Notifying Observer */
	public void notifyChanges() {
		this.setChanged();
		this.notifyObservers();
	}

	/* Resetting game init() method */
	public void resetInit() {
		this.init(this.w, this.h);
		if (this.lives == 0) {
			this.gameOver();
		}
	}

	/* When Squirrel Player loses a life */
	public void loseLife() {
		this.lives--;
		Command cOk = new Command("Ok");
		Dialog.show("Squirrel player loses a life!", "Lives remaining: " + this.lives, cOk);
		this.resetInit();// re-initialize GW

		if (this.lives == 0) {
			System.out.print("Player ran out of lives");
			this.gameOver();
		}
	}

	/* When Squirrel runs out of lives, game ends! */
	public void gameOver() {
		Boolean cOk = Dialog.show("Game Over! You failed!", "Total Time: " + this.gameClock, "Ok", null);

		if (Boolean.TRUE.equals(cOk)) {
			Display.getInstance().exitApplication();
		}
	}

	/* Player squirrel reaches the last nut in the garden, the game ends */
	public void gameWin() {

		Boolean cOk = Dialog.show("Game over", "Congratulations, you won! You reached the " + "last nut of the garden! "
				+ "\nTotal time:" + this.gameClock, "Ok", null);

		if (Boolean.TRUE.equals(cOk)) {
			Display.getInstance().exitApplication();
		}
	}

	/* Accessor methods for ScoreView class */
	public int getTime() {
		return this.gameClock;
	}

	public int getLivesLeft() {
		return this.lives;
	}

	public int getLastNutReached() {
		return this.sqrl.getLastNutReached();
	}

	public double getPlayerEnergyLevel() {
		return this.sqrl.getEnergyLevel();
	}

	public int getPlayerDamageLevel() {
		return this.sqrl.getDamageLevel();
	}

	public boolean getSound() {
		return this.sound;
	}

	public void setSound() {
		if (sound)
			sound = false;
		else
			sound = true;
	}

	public void setWidth(float width) {
		this.w = width;
		this.setChanged();
	}

	public void setHeight(float height) {
		this.h = height;
		this.setChanged();
	}

	public void switchSound() {
		this.sound = !this.sound;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public GameObjectCollection getCollection() {
		return this.goc;
	}

}