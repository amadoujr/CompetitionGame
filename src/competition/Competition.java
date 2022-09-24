package competition;
import java.util.*;

import competitor.Competitor;
import match.*;


public abstract class Competition {
	
	// Attribute

	protected Match m1;
	protected final List<Competitor> competitors;
 
	/**
	 * initialize the constructor
	 */
	
	public Competition(List<Competitor> competitors) {
		this.m1 = new RandomVictoryMatch();
		this.competitors = competitors;
	}
	
	//methods 
	 
	public void play() {};
	
	/**
	 * make each competitor play against each other
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	protected void playMatch(Competitor c1, Competitor c2) {
		
	}
	
	/** 
	 * organize match between competitors
	 * @param competitor
	 */
	protected abstract void play(List<Competitor>competitor);
	
	/**
	 * @return ranking of each competitors
	 */
	public Map<Competitor,Integer> ranking(){
		Map<Competitor,Integer> ranks = new HashMap<>();
		for (Competitor c : competitors) {
			ranks.put(c, c.getScore());
		}
		return ranks;
		
	}
	
}
