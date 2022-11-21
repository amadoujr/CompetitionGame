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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(CompetitionObservable observable) {
		// TODO Auto-generated method stub
		
	}

}
