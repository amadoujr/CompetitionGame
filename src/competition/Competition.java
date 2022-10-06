package competition;
import java.util.*;

import competitor.Competitor;
import display.Display;
import match.*;


public abstract class Competition {
	
	// Attribute

	protected Match m1;
	protected final List<Competitor> competitors;
	protected boolean finished ;
	public static final Display displayer = new Display();
	
	/**
	 * initialize the constructor
	 */
	
	public Competition(List<Competitor> competitors) {
		this.m1 = new RandomVictoryMatch();
		this.competitors = competitors;
	}
	
	/**
	 * this methods runs a competition till the end
	 */
	 
	public void play() {
		while(!this.isFinished()) {   // end of the game reached ?
			this.play(competitors);   // start the competition
			this.finished = true;    
		}
		System.out.println();
		this.ranking(); // display the ranking of the tournament
	}
	
	/**
	 * @return true if the game is finished otherwise false
	 */
	private boolean isFinished() {
		// TODO Auto-generated method stub
		return this.finished;
	}

	/**
	 * make each competitor play against each other
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	protected void playMatch(Competitor c1, Competitor c2) {
		if (this.m1.winnerOfTheGame(c1, c2).equals(c1)) {
			c2.setQualification(false) ;
			c1.setScore(c1.getScore() + 1);
			this.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c1 +" win!!");
		}
		else {
			c1.setQualification(false) ;
			c2.setScore(c2.getScore() + 1) ;
			this.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c2 +" win!!");
		}
	}
	
	/** 
	 * organize match between competitors
	 * @param competitor
	 */

	protected abstract void play(List<Competitor> competitors);
	
	/**
	 * @return ranking of each competitors
	 */
	public Map<Competitor,Integer> ranking(){
		System.out.println("*** Ranking ***");
		
		
		Map<Competitor,Integer> ranks = new HashMap<>();
		for (Competitor c : competitors) {
			ranks.put(c, c.getScore());
		} 
		ranks = MapUtil.sortByDescendingValue(ranks);
		System.out.println();
		for( Map.Entry <Competitor, Integer> entry : ranks.entrySet()) {
			Competition.displayer.displaymsg(entry.getKey() + " - "+ entry.getValue());
		}
		return ranks;
		
		
		
		
	}
	
}
