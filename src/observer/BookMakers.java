package observer;

import java.util.*;
import competitor.Competitor;

public class BookMakers implements Observer {
	
	/**
	 * contains odds of every competitor
	 */
	private Map<Competitor,Integer> odds; 
	
	public BookMakers() {
		this.odds = new HashMap<>();
	}

	@Override
	public void update(CompetitionObservable observable) {
		
	}

	@Override
	public void react_to_match() {
		// TODO Auto-generated method stub
		
	}

}
