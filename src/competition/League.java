package competition;

import java.util.List;

import competitor.Competitor;
import match.*;

public class League extends Competition {
	
	// match correspond to the type of match (RandomVictoryMatch in our case ) that competitors will play
	private Match match ;
	
	/**
	 * Initialize the constructor
	 * @param competitors a list contains all competitors
	 */
	public League(List<Competitor> competitors) {
		super(competitors); 
		this.match = new RandomVictoryMatch();
	}
	

	/**
	 * make each competitor play against each other and
	 * add one point to the winner
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	public void playMatch(Competitor c1, Competitor c2) {
		
	}

	/**
	 * 
	 */
	public void play(List<Competitor> competitor) {
		// TODO Auto-generated method stub
		
	}

}
