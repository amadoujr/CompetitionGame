package competition;

import java.util.*;
import competitor.Competitor;
import match.*;

public class Tournament extends Competition {
	private List<Competitor> qualify = new ArrayList<>();
	private Competitor winner ;
	private Match match;
	
	public Tournament(List<Competitor> competitors, Match m1) {
		super(competitors);
		this.match = m1;	
	}

	/**
	 * return the list of qualify competitor 
	 * @return List<Competitor> qualify 
	 */
	public List<Competitor> getQualify() {
		return this.qualify;
	}
	
	public void setQualify(List<Competitor> c) {
		this.qualify.addAll(c);
	}
	
	public List<Competitor> getCompetitors() {
		return this.competitors;
	}
	
	/**
	 * play a match between two competitors and remove the looser of the qualify list 
	 * @param Competitor c1
	 * @param Competitor c2
	 */
	public void apresMatch(Competitor c1,Competitor c2) {
		if (this.match.winnerOfTheGame(c1, c2).equals(c1)) {
			c2.setScore(-1) ;
		}
		else {
			c1.setScore(-1) ;
		}
	}
	
	/**
	 * do the tournament and update the qualify list 
	 * @param List<Competitor> compet
	 */
	public void play(List<Competitor> compet) {
		this.qualify.addAll(compet);
		while (this.qualify.size() > 1) {
			int l = this.qualify.size() ;
			Collections.shuffle(this.qualify);
			for (int i=0 ; i<l ; i+=2) {
				apresMatch(this.qualify.get(i),this.qualify.get(i+1));	
			}
			for (Competitor c : this.qualify) {
				if (c.getScore()==-1) {
					this.qualify.remove(c);
				}
			}
		}
		this.winner = this.qualify.get(0) ;
	}
	
	
	/**
	 * return the name of the winner of the tournament 
	 * @return String name of the winner 
	 */
	public String winnerTournament() {
		return this.winner.getName() ;
	}

	
}
