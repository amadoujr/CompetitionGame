package competition;

import java.util.List;

import competitor.Competitor;
import match.*;

public class League extends Competition {
	
	// match correspond to the type of match (RandomVictoryMatch in our case ) that competitors will play
	
	
	private Match match;


	/**
	 * Initialize the constructor
	 * @param competitors a list contains all competitors
	 */
	public League(List<Competitor> competitors, Match m1) {
		super(competitors);  
		this.match = m1;
	}
	

	/**
	 * make each competitor play against each other and
	 * add one point to the winner
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	public void play(List<Competitor> competitors){
		
		Competitor winner;
		for (Competitor comp1 : competitors) {         
			for (Competitor comp2 : competitors) {
				if (comp1 != comp2) {	
					winner = this.match.winnerOfTheGame(comp1, comp2);      // affect to winner the winner between comp1 & comp2
					winner.setScore(winner.getScore()+1);              // add one point to the winner
				}
			}
		}
		
	}
	
	
	

}
