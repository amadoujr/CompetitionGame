package competition;

import java.util.*;
import java.util.stream.*;

import competitor.Competitor;
import match.*;

public class Tournament extends Competition {
	private List<Competitor> qualify = new ArrayList<>();
	private Competitor winner ;
	private Match match;
	
	/**
	 * initialize the tournament
	 * @param List<Competitor> competitors the list of competitors of the tournament
	 * @param Match m1 the type of match who will get played during the tournament 
	 */
	public Tournament(List<Competitor> competitors, Match m1) {
		super(competitors);
		if( competitors.size() % 2 != 0) {
			System.out.println("le nombre de compétiteurs doit être une puissance de 2");
			System.exit(0);
		}
		this.match = m1;	
	}

	/**
	 * return the list of qualify competitor 
	 * @return List<Competitor> qualify 
	 */
	public List<Competitor> getQualify() {
		return this.qualify;
	}
	
	/**
	 * add a list of competitors at the list of qualify
	 * @param List<Competitor> c
	 */
	public void setQualify(List<Competitor> c) {
		this.qualify.addAll(c);
	}
	
	/**
	 * return the list of competitors
	 * @return List<Competitor> competitors
	 */
	public List<Competitor> getCompetitors() {
		return this.competitors;
	}
	
	/**
	 * return this.winner
	 * @return Competitor winner
	 */
	public Competitor getWinner() {
		return this.winner ;
	}
	
	/**
	 * do the tournament and update the qualify list 
	 * @param List<Competitor> compet
	 */
	public void play(List<Competitor> compet) {
		for (int z=0 ; z<compet.size() ; z++) {
			compet.get(z).setScore(0) ;         // reset the score of tournament and the attribute qualification in case
			compet.get(z).setQualification(true) ;        // these competitors have already play a tournament
		}
		this.qualify.addAll(compet);
		while (this.qualify.size() > 1) {
			int l = this.qualify.size() ;
			Collections.shuffle(this.qualify);
			for (int i=0 ; i<l ; i+=2) {
				playMatch(this.qualify.get(i),this.qualify.get(i+1));	
			}
			List <Competitor > deleteCompetitors = new ArrayList<>() ;
			for (Competitor c : this.qualify) {
			    if (c.getQualification() == false) {
			    	deleteCompetitors.add(c);
			    }
			 }
			for (Competitor c : deleteCompetitors) {
			    this.qualify.remove(c);
			 }
		}
		this.winner = this.qualify.get(0) ;
		this.compteur++;
	}
	
	
	/**
	 * return the winner of the tournament 
	 * @return name of the winner 
	 */
	public String winnerTournament() {
		return "Le vainqueur du tournoi est " + this.winner ;
	}

	
}
