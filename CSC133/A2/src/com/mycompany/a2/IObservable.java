package com.mycompany.a2;

public interface IObservable {

	public void addObserver(IObserver observer);
	public void notifyObserver();
	
}
