package competition;
import java.util.*;

import competitor.Competitor;
import display.Display;
import match.*;


public abstract class Competition {
	
	// Attribute

	protected Match match;
	protected final List<Competitor> competitors;
	protected boolean finished ;
	public static final Display displayer = new Display();
	protected int compteur;
	protected Map<Competitor,Integer> score;
	/**
	 * initialize the constructor
	 */
	
	public Competition(List<Competitor> competitors, Match m1) {
		this.match = m1;
		this.competitors = competitors;
		this.compteur=0;
		this.score = new HashMap<>();
		this.initializeScore();
	}
	
	/**
	 * 
	 * @return the list of competitors
	 */
	public List<Competitor>getCompetitors() { 
		return this.competitors ;
	}
	/**
	 * 
	 * @return a map which contains names and scores of each competitors
	 */
	public Map<Competitor, Integer> getScore() {
		return score;
	}
	/**
	 * set score of competitors
	 * @param score
	 */
	public void setScore(Map<Competitor, Integer> score) {
		this.score = score;
	}
	/**
	 * Used Just for the JUnit test
	 * @return 
	 */
	public int getcompteur() {
		return this.compteur;
	}
	
	/**
	 * reset the score of competitors to zero before the next competition
	 */
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
				e.printStackTrace();
				System.exit(0);
			}   
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
		if (this.match.winnerOfTheGame(c1, c2).equals(c1)) {
			c2.setQualification(false) ; 
			this.score.put(c1, this.score.get(c1)+1) ;
			Competition.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c1 +" win!!");
		}
		else {
			c1.setQualification(false) ;
			this.score.put(c2, this.score.get(c2)+1) ;
			Competition.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c2 +" win!!");
		}
	}
	
	/** 
	 * organize match between competitors
	 * @param competitor
	 */
	protected abstract void play(List<Competitor> competitors) throws NotRowofTwoException;
	
	/**
	 * sort competitors by points descendant;
	 * @return ranking of each competitors
	 */
	public Map<Competitor,Integer> ranking(){
		score = MapUtil.sortByDescendingValue(score);
		return score;
	}
	
	/**
	 * display ranking of the competition
	 */
	public void displayRanking() {
		System.out.println("*** Ranking ***");
		System.out.println();
		for( Map.Entry <Competitor, Integer> entry : this.ranking().entrySet()) {
			Competition.displayer.displaymsg(entry.getKey() + " - "+ entry.getValue());
		}
	}
	
}
