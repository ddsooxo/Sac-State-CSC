package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import java.util.Observable;;

public interface IObserver {
	public void update (Observable o, Object arg);
}
