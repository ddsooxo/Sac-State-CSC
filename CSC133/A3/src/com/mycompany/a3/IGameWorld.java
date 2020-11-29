package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

public interface IGameWorld {
	public int getTime();
	public int getLivesLeft();
	public int getLastNutReached();
	public double getPlayerEnergyLevel();
	public int getPlayerDamageLevel();
	public boolean getSound();
	public GameObjectCollection getCollection();
}
