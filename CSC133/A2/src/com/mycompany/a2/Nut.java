package com.mycompany.a2;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

public class Nut extends Fixed {
	private int sequenceNumber;

	/* Nut Constructor */
	public Nut(int sNo) {
		setColor(255,255,0); //yellow 
		setSize(10);
		this.sequenceNumber = sNo;
	}
	
	/* accesor method */
	public int getSeqNum() {
		return sequenceNumber;
	}
	
	public void setSeqNum(int sNo) {
		this.sequenceNumber = sNo;
	}
	
	/* printing string data about Nut */
	@Override
	public String toString() {
		
		String parentString = super.toString();
		String nutString = " size =" + super.getSize() + " seqNum=" + getSeqNum();
		
		
		return "Nut: " + parentString + nutString;
	}
}
