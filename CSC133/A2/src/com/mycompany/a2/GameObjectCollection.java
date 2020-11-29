package com.mycompany.a2;

import java.util.Vector;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 


public class GameObjectCollection implements ICollection{
	private Vector<GameObject> gameObjectCollection;
	private int nutCount;
	private int birdCount;
	private int npcCount;
	
	
	public GameObjectCollection() {
		gameObjectCollection = new Vector<GameObject>();
		this.setNutCount(0);
		this.setBirdCount(0);
		this.setNpcCount(0);
		
	}
	
	public void add(GameObject newGameObject) {
		gameObjectCollection.addElement(newGameObject); 
	}
	
	public void remove(GameObject gameObject) {
		gameObjectCollection.removeElement(gameObject);
	}
	
	public IIterator getIterator() {
		return new GameObjectIterator () ;  
	}
	
	
	public int getNpcCount() {
		return npcCount;
	}

	public void setNpcCount(int npcCount) {
		this.npcCount = npcCount;
	}


	public int getBirdCount() {
		return birdCount;
	}

	public void setBirdCount(int birdCount) {
		this.birdCount = birdCount;
	}


	public int getNutCount() {
		return nutCount;
	}

	public void setNutCount(int nutCount) {
		this.nutCount = nutCount;
	}


	private class GameObjectIterator implements IIterator {
		
		private int currElementIndex;
		
		public GameObjectIterator() {
			currElementIndex = -1;
		}
		
		public boolean hasNext() {
			if (gameObjectCollection.isEmpty())		return false;
			
			if (currElementIndex == gameObjectCollection.size() - 1 ) {
				return false;
			}
			return true;
		}
		
		public GameObject getNext() {
				currElementIndex ++ ;
				return (gameObjectCollection.elementAt(currElementIndex));
		}
	}
}
	