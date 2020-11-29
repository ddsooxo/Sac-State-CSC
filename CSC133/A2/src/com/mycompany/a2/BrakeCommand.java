package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BrakeCommand extends Command {
	
	private GameWorld gw;
	
	public BrakeCommand(String s, GameWorld gWorld){
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Break.");
		
		if(gw!= null){
			gw.brakePlayerSquirrel();
		}
	}
}
