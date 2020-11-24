package com.mycompany.a2;


import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command{

	private GameWorld gw;

	public TickCommand(String s, GameWorld gWorld){
	
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.tickCommand();
		System.out.println("Clock is ticking");
		
		
	}

}
