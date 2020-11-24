package com.mycompany.a2;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 


import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;

public class CollideWithNutCommand extends Command{
	
	private GameWorld gw;

	public CollideWithNutCommand(String s, GameWorld gWorld){
	
		super(s);
		this.gw = gWorld;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("CollisionWithNut Command invoked.");
		
		Command cOk = new Command("Ok");
		TextField myTF = new TextField();
		
		Dialog.show("Please enter nut sequence to collide: " , myTF, cOk);
		gw.collideWithNuts(Integer.parseInt(myTF.getText()));
		

	}
}
		