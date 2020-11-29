package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command{
	
	private GameWorld gw;

	public AboutCommand(String s, GameWorld gWorld){
	
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Dialog.show("Dechen Chuteng", "CSC 133 Assignmnet #2 - Design "
				+ "Patterns and GUIs", "OK", null);
	}
}

