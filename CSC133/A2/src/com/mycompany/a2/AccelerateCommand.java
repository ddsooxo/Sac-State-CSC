package com.mycompany.a2;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
 

public class AccelerateCommand extends Command {
	private GameWorld gw;
	
	public AccelerateCommand(String s, GameWorld gWorld){
		
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		System.out.println("Squirrel Player speed is accelerated.");
		
		if(gw!= null){
			
			gw.acceleratePlayerSquirrel();
		}
		
	}
	
	
}
