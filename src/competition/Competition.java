package competition;
import java.util.*;

import competitor.Competitor;


public abstract class Competition {
	
	/**
	 * a list who contains all competitors
	 */
	
	protected final List<Competitor> competitors;

	/**
	 * initialize the constructor
	 */
	
	public Competition(List<Competitor> competitors) {
		
		this.competitors = competitors;
	}
	
	//methods
	
	public void play() {};
	
	/**
	 * make each competitor play against each other
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	public abstract void playMatch(Competitor c1, Competitor c2);
	
	/**
	 * organize match between competitors
	 * @param competitor
	 */
	public abstract void play(List<Competitor>competitor);
	
	/**
	 * @return ranking of each competitors
	 */
	public Map<Competitor,Integer> ranking (){
		return null;
		
	}
	
}
