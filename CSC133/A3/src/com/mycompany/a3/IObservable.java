package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

public interface IObservable {
	public void addObserver(IObserver observer);
	public void notifyObserver();	
}
