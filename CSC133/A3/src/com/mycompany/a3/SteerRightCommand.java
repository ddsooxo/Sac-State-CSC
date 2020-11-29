package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/ 

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SteerRightCommand extends Command {
	private GameWorld gw;
	
	public SteerRightCommand(String s, GameWorld gWorld){
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Squirrel turned right.");
		if(gw!=null) {
			gw.steerRight();
		}
	}
}