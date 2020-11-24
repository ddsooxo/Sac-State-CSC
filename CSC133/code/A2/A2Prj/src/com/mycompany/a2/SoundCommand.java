package com.mycompany.a2;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
	
	private CheckBox soundCheckBox;
	private GameWorld gw;
	private Game g;
	
	
	public SoundCommand(String s, GameWorld gWorld) {
		
		super(s);
		this.gw = gWorld;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.toggleSound();
	
	}

}
