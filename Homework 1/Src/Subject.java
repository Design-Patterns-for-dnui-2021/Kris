import java.util.ArrayList;

public abstract class Subject {
 
	private ArrayList<Observer> observer;
	
	public Subject() {
		observer = new ArrayList<Observer>();
	}
	 
	public void registerObserver(Observer observer) {
		this.observer.add(observer);
	}
	 
	public void deleteObserver(Observer observer) {
		this.observer.remove(observer);
	}
	 
	public void notifyObservers() {
		for (var observer : observer) {
			observer.update();
		}
	}
}
 
