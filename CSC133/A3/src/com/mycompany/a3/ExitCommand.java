package com.mycompany.a3;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 3 [Bad-Squirrel]
* 
*/

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command{
	private GameWorld gw;

	public ExitCommand(String s, GameWorld gWorld){
	
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		Boolean bOK = Dialog.show("Exit", "Are you sure you want to exit?", "Yes", "Cancel");
		
		if(bOK) {
			Display.getInstance().exitApplication();
		}
	}
}

