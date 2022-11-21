package observer;

public interface CompetitionObservable {
	
	public void addObservers (Observer observer);
	public void removeObersver (Observer observer);
	public void notifyObserver();
	public void state(String msg);
		
}
