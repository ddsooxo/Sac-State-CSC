package com.mycompany.a2;

/**
*
* @author Dechen Chuteng
* CSC133 - Assignment 2 [Bad-Squirrel]
* 
*/ 

import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.Toolbar;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.ComponentSelector;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;


/**
 *
 * @author Dechen Chuteng
 * CSC133 - Assignment 2 [Bad-Squirrel]
 * 
 */ 

public class Game extends Form {
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private String gameTitle = "Bad Squirrel!";
	private Toolbar menuBar = new Toolbar();

	
	/* Game Constructor*/
	public Game() {	
		gw = new GameWorld();   // create "Observable" GameWorld
		mv = new MapView();     // create an "Observable" for the map
		sv = new ScoreView();   // create an "Observable" for the game/player-squirrel state + datas
	
		gw.addObserver(mv);     // register the map observer
		gw.addObserver(sv);     // register the score observer
		this.show();
		
		/*Layout Manager */
		setToolbar(menuBar);
		this.setLayout(new BorderLayout());
		menuBar.setTitle(gameTitle);
		this.gw.setDimensions(mv.getWidth(), mv.getHeight()); 
		
		/* North Area*/
		Container northNavBar = new Container(new FlowLayout(Component.CENTER));
		this.add(BorderLayout.NORTH, northNavBar);
		northNavBar.add(sv);
		ComponentSelector.$("Label", northNavBar).getAllStyles().setPadding(Component.RIGHT, 5);
		ComponentSelector.$("Label", northNavBar).setFgColor(ColorUtil.BLUE);
		
		/* Center Area */
		Container centerMap = new Container();
		this.add(BorderLayout.CENTER, centerMap);
		centerMap.add(mv);
		centerMap.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(255,0,0)));
	
		/* West Area */
		Container westMenuBar = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		this.add(BorderLayout.WEST, westMenuBar);
		Button accelerateButton = new Button("Accelerate");
		westMenuBar.add(accelerateButton);
		Button steerLeftButton = new Button("Left");
		westMenuBar.add(steerLeftButton);
		Button changeStratButton = new Button("Change Strategies");
		westMenuBar.add(changeStratButton);
		westMenuBar.getAllStyles().setPadding(Component.TOP, 100);
			
		/* East Area */
		Container eastMenuBar = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		this.add(BorderLayout.EAST, eastMenuBar);
		Button brakeButton = new Button("Brake");
		eastMenuBar.add(brakeButton);
		Button steerRightButton = new Button("Right");
		eastMenuBar.add(steerRightButton);
		eastMenuBar.getAllStyles().setPadding(Component.TOP, 100);
		
		/* South Area */
		Container southMenuBar = new Container(new FlowLayout(Component.CENTER));
		this.add(BorderLayout.SOUTH, southMenuBar);
		Button collideWithNPCButton = new Button("Collide with NPC");
		southMenuBar.add(collideWithNPCButton);
		Button collideWithNutButton = new Button("Collide with Nut");
		southMenuBar.add(collideWithNutButton);
		Button collideWithTomatoButton = new Button("Collide with Tomato");
		southMenuBar.add(collideWithTomatoButton);
		Button collideWithBirdButton = new Button("Collide with Bird");		
		southMenuBar.add(collideWithBirdButton);
		Button tickButton = new Button("Tick");
		southMenuBar.add(tickButton);
	
		/* Add Commands and Key Listeners */
		Command accelerateCommand = new AccelerateCommand("Accelerate", gw);
		accelerateButton.setCommand(accelerateCommand);
		addKeyListener('a', accelerateCommand);
		Command brakeCommand = new BrakeCommand("Brake", gw);
		brakeButton.setCommand(brakeCommand);
		addKeyListener('b', brakeCommand);
		Command steerLeftCommand = new SteerLeftCommand("Left", gw);
		steerLeftButton.setCommand(steerLeftCommand);
		addKeyListener('l', steerLeftCommand);
		Command steerRightCommand = new SteerRightCommand("Right", gw);
		steerRightButton.setCommand(steerRightCommand);
		addKeyListener('r', steerRightCommand);
		Command collideWithTomatoCommand = new CollideWithTomatoCommand("Collide With Tomato", gw);
		collideWithTomatoButton.setCommand(collideWithTomatoCommand);
		addKeyListener('e', collideWithTomatoCommand);
		Command collideWithBirdCommand = new CollideWithBirdCommand("Collide With Bird", gw);
		collideWithBirdButton.setCommand(collideWithBirdCommand);
		addKeyListener('g', collideWithBirdCommand);
		Command tickCommand = new TickCommand("Tick", gw);
		tickButton.setCommand(tickCommand);
		addKeyListener('t', tickCommand);
		Command changeStrategiesCommand = new ChangeStrategiesCommand("Change Strategies", gw);
		changeStratButton.setCommand(changeStrategiesCommand);
		Command collideWithNpcCommand = new CollideWithNpcCommand("Collide With NPC", gw);
		collideWithNPCButton.setCommand(collideWithNpcCommand);
		Command collideWithNutCommand = new CollideWithNutCommand("Collide With Nut", gw);
		collideWithNutButton.setCommand(collideWithNutCommand);		
		
		/* (Hamburger) Sidemenu bar*/
		Command soundCommand = new SoundCommand("Toggle Sound", gw);
		Command aboutCommand = new AboutCommand("About", gw);
		Command helpCommand = new HelpCommand("Help", gw);		
		Command exitCommand = new ExitCommand("Exit", gw);
		
		menuBar.addCommandToSideMenu(accelerateCommand);
		CheckBox soundBox = new CheckBox("Toggle Sound");
		soundBox.getAllStyles().setBgTransparency(255);
		soundBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundBox.getAllStyles().setFgColor(ColorUtil.WHITE);
		soundBox.setCommand(soundCommand);
		menuBar.addComponentToSideMenu(soundBox);		 
		menuBar.addCommandToSideMenu(aboutCommand);
		menuBar.addCommandToRightBar(helpCommand);		
		menuBar.addCommandToSideMenu(exitCommand);
		
		/* Styling the Buttons */
		String b = "Button"; 
		ComponentSelector.$(b).setBgTransparency(255);
		ComponentSelector.$(b).setBgColor(ColorUtil.BLUE);
		ComponentSelector.$(b).setFgColor(ColorUtil.WHITE);
		ComponentSelector.$(b).getAllStyles().setPadding(4, 4, 2, 2);
		ComponentSelector.$(b).getAllStyles().setAlignment(CENTER);
		ComponentSelector.$(b, westMenuBar).getAllStyles().setMargin(Component.BOTTOM, 10);
		ComponentSelector.$(b, eastMenuBar).getAllStyles().setMargin(Component.BOTTOM, 10);
		ComponentSelector.$(b, southMenuBar).getAllStyles().setMargin(Component.RIGHT, 5);
		
		this.show();
		gw.init();
		
		}//end of Game constructor
	
	}// end Game class
	