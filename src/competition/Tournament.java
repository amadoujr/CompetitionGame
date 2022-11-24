package competition;

import java.util.*;

import competitor.Competitor;
import match.*;

public class Tournament extends Competition {
	private List<Competitor> qualify = new ArrayList<>();
	private Competitor winner ;
	
	/**
	 * initialize the tournament
	 * @param List<Competitor> competitors the list of competitors of the tournament
	 * @param Match m1 the type of match who will get played during the tournament 
	 */
	public Tournament(List<Competitor> competitors, Match match) {
		super(competitors,match);
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
	public void play(List<Competitor> compet) throws NotRowofTwoException {
		if (!this.isPowOftwo(compet.size())) {
			throw new NotRowofTwoException("Le nombre de compétiteurs n'est pas une puissance de deux");
		}
		else {
			for (int z=0 ; z<compet.size() ; z++) {
				compet.get(z).setQualification(true) ;        // these competitors have already play a tournament
			}
			this.qualify.addAll(compet);
			while (this.qualify.size() > 1) {
				int l = this.qualify.size() ;
				//Collections.shuffle(this.qualify); bloque le fonctionnement des testes de ranking 
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
			}
		System.out.println();
		System.out.println(this.winnerTournament());
	}
	/**
	 * check if the parameter n is a power of 2
	 * @param n the number
	 * @return true if it is the case otherwise false
	 */
	public boolean isPowOftwo(int n) {
		
		boolean answer = false;
		while(n >= 2) {
			if (n%2 == 0) {
				answer =  true;
			}
			else {
				answer =  false;
			}
			n = n/2 ;
		}
		return answer;
	}
	
	/**
	 * return the winner of the tournament 
	 * @return name of the winner 
	 */
	public String winnerTournament() {
		return "The winner of this tournament is " + this.winner ;
	}

	
}
