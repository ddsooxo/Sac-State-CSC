package com.mycompany.a3;

/**
 *
 * @author Dechen Chuteng
 * CSC133 - Assignment 3 [Bad-Squirrel]
 * 
 */ 

import com.codename1.ui.Display;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
/** This method constructs a Media object from the specified file, then plays the Media.*/

public class BGSound implements Runnable{
	private Media m;
//	
//	public BGSound(String fileName) {
//		if (Display.getInstance().getCurrent() == null){
//			System.out.println("Error: Create sound objects after calling show()!");
//			System.exit(0);}
//		try{
//		InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
//		m = MediaManager.createMedia(is, "audio/wav", this);}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	public void pause() {
//		m.pause();
//	}
//	
//	public void play() {
//		m.play();
//	}
//
	@Override
	public void run() {
		m.setTime(0);
		m.play();
	}
}