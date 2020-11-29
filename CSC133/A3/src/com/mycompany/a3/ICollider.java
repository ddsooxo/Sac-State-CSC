package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/ 


public interface ICollider {

	boolean collidesWith(GameObject otherObject);
	void handleCollision(GameObject otherObject);

}
