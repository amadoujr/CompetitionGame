package observer;

import java.util.ArrayList;
import java.util.List;

public class CompetitionObservable {
	
	private List<Observer> registred_observers ;
	public CompetitionObservable () {
		this.registred_observers = new ArrayList<Observer>();
	}
	
	public void addObservers (Observer observer) {
		this.registred_observers.add(observer);
	};
	
	public void removeObersver (Observer observer){
		this.registred_observers.remove(observer);
	};
	
	public void notifyObserver(){};
	
	
	public void Match_Played(){
		for (Observer o : this.registred_observers) {
			o.react_to_match();
		}
	};
	
	public void state(String msg){};
		
}
