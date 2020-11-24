package com.mycompany.a2;

import java.util.Observable;;


public interface IObserver {
	public void update (Observable o, Object arg);
}
