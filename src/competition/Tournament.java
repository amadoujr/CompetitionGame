package competition;

import java.util.*;
import competitor.Competitor;
import match.*;

public class Tournament extends Competition {
	private List<Competitor> qualify ;
	private Competitor winner ;
	private Match match;
	
	public Tournament(List<Competitor> competitors, Match m1,List<Competitor> qualify) {
		super(competitors);
		this.match = m1;
		this.qualify = new ArrayList<Competitor>(this.competitors);
	}

	/**
	 * return the list of qualify competitor 
	 * @return List<Competitor> qualify 
	 */
	public List<Competitor> getQualify() {
		return qualify;
	}

	
	/**
	 * play a match between two competitors and remove the looser of the qualify list 
	 * @param Competitor c1
	 * @param Competitor c2
	 */
	public void apresMatch(Competitor c1,Competitor c2) {
		Competitor c = this.match.winnerOfTheGame(c1,c2);
		if (c.equals(c1)) {
			this.qualify.remove(c2) ;
		}
		else {
			this.qualify.remove(c1) ;
		}
	}
	
	/**
	 * do the tournament and update the qualify list 
	 * @param List<Competitor> compet
	 */
	public void play(List<Competitor> compet) {
		this.qualify = new ArrayList<Competitor>(compet);
		while (this.qualify.size() > 1) {
			int l = this.qualify.size() ;
			Collections.shuffle(this.qualify);
			for (int i=0 ; i<l ; i+=2) {
				apresMatch(this.qualify.get(i),this.qualify.get(i+1));	
			}
		this.winner = this.qualify.get(0) ;
		}
	}
	
	/**
	 * return the name of the winner of the tournament 
	 * @return String name of the winner 
	 */
	public String winnerTournament() {
		return this.winner.getName() ;
	}

	
}
