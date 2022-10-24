package competition;

import java.util.List;

import competitor.Competitor;
import match.*;

public class League extends Competition {
	
	/**
	 *  match correspond to the type of match (RandomVictoryMatch in our case ) that competitors will play
	 *  finished  : help us to know if the leagues is over or not
	 */
	
	

	/**
	 * Initialize the constructor
	 * @param competitors a list contains all competitors
	 */
	public League(List<Competitor> competitors, Match match) {
		super(competitors,match);  
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
					playMatch(comp1,comp2);
				}
			}
		}
		this.compteur++;  /*used for testing Cmpetitions play()*/
	}
	
	
	

}
