package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideWithNpcCommand extends Command{

	private GameWorld gw;

	public CollideWithNpcCommand(String s, GameWorld gWorld){
	
		super(s);
		this.gw = gWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Collision with NPC");
		
		if(gw != null){
			gw.collideWithNpc();
		}
	}
}
