package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class PauseCommand extends Command {
	private GameWorld gw;
	
	public PauseCommand(String s, GameWorld gWorld){
		
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Dialog.show("Game Paused", "Click continue to resume game", "Resume", null);
		
	}
	
	
}