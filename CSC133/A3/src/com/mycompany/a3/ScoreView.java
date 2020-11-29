package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.Container;
import com.codename1.ui.Label;

public class ScoreView extends Container implements Observer {
	/* code to output the current game/player-squirrel state information */
	private Label timeValue = new Label("Time: 0 ");
	private Label livesLeft = new Label("Lives: 3");
	private Label lastNutReached = new Label("Last Nut Reached:");
	private Label energyLevel = new Label("Energy : 0");
	private Label damageLevel = new Label("Damage : 0");
	private Label sound = new Label("Sound: OFF");
	
	public ScoreView() {
		this.add(timeValue);
		this.add(livesLeft);
		this.add(lastNutReached);
		this.add(energyLevel);
		this.add(damageLevel);
		this.add(sound);
	}	
	
	public void update(Observable o, Object arg) {
		timeValue.setText("Time: " + ((GameWorld) o).getTime());
		livesLeft.setText("Lives: " + ((GameWorld)o).getLivesLeft());
		lastNutReached.setText("Last Nut Reached: " + ((GameWorld)o).getLastNutReached());
		energyLevel.setText("Energy: " + ((GameWorld)o).getPlayerEnergyLevel());
		damageLevel.setText("Damage: " + ((GameWorld)o).getPlayerDamageLevel());
		sound.setText("Sound: " + (((GameWorld)o).getSound()? "ON" : "OFF")) ;
	}	
}
		