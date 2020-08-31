package ecommerce;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	private List<Observer> observerList = new ArrayList<Observer>();
	
	public void addObserver(Observer observer) {
		if(!observerList.contains(observer))
			observerList.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	public void notifyAllObservers(String message) {
		for(Observer observer : observerList) {
			observer.update(message);
		}
	}
	
}
