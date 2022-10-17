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
	protected int compteur;
	Map<Competitor,Integer> score;
	/**
	 * initialize the constructor
	 */
	
	public Competition(List<Competitor> competitors) {
		this.m1 = new RandomVictoryMatch();
		this.competitors = competitors;
		this.compteur=0;
		this.score = new HashMap<>();
		this.initializeScore();
	}
	
	public Map<Competitor, Integer> getScore(
			) {
		return score;
	}
	public void setScore(Map<Competitor, Integer> score) {
		this.score = score;
	}
	public int getcompteur() {
		return this.compteur;
	}
	
	public void initializeScore () {
		for (int i=0 ; i<this.competitors.size(); i++) {
			this.score.put(this.competitors.get(i), 0);
		}
	}
	
	/**
	 * this methods runs a competition till the end
	 */
	 
	public void play() {
		while(!this.isFinished()) {   // end of the game reached ?
			try {
				this.play(competitors);
			} catch (NotRowofTwoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}   // start the competition
			this.finished = true;   
		}
		System.out.println();
		this.ranking(); 
		this.displayRanking(); // display the ranking of the tournament
		
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
			this.score.put(c1, this.score.get(c1)+1) ;
			this.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c1 +" win!!");
		}
		else {
			c1.setQualification(false) ;
			this.score.put(c2, this.score.get(c2)+1) ;
			this.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c2 +" win!!");
		}
	}
	
	/** 
	 * organize match between competitors
	 * @param competitor
	 */

	protected abstract void play(List<Competitor> competitors) throws NotRowofTwoException;
	
	/**
	 * @return ranking of each competitors
	 */
	public Map<Competitor,Integer> ranking(){
		Map<Competitor,Integer> ranks = new HashMap<>();
		for (Competitor c : competitors) {
			ranks.put(c, this.score.get(c));
		} 
		ranks = MapUtil.sortByDescendingValue(ranks);
		return ranks;
	}
	
	public void displayRanking() {
		System.out.println("*** Ranking ***");
		System.out.println();
		for( Map.Entry <Competitor, Integer> entry : this.ranking().entrySet()) {
			Competition.displayer.displaymsg(entry.getKey() + " - "+ entry.getValue());
		}
	}
	
}
