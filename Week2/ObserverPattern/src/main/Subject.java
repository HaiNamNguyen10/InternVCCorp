package main;
import java.util.ArrayList;
public class Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	public void notifyChange(String message) {
		for(Observer observer : observers) {
			observer.update(message);
		}
	}
}
