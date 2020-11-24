package com.mycompany.a2;


/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command{

	private GameWorld gw;

	public HelpCommand(String s, GameWorld gWorld){
	
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	 public void actionPerformed(ActionEvent e) {
		 
			Dialog.show("Help",
					"Keys Users Can Use : \n"
					+ "'a' to accelerate \n"
					+ "'b' to brake \n"
					+ "'l' to steer left \n"
					+ "'r' to steer right \n"
					+ "'e' to collide with a tomato \n"
					+ "'g' to collide with a bird \n"
					+ "'t' to tick the game clock \n",
					"Okay", null);
		}

	
}
