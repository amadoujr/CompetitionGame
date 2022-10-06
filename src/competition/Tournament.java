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
	
/*	/**
	 * do the rank of the tournament of a competitors list and update him in the attribute rank
	 * @param List<Competitor> c
	 
	public void doingRank(List<Competitor> c) {
		Map<Competitor,Integer> m = new HashMap<>() ;
		for (int i = 0; i<this.competitors.size(); i++) {
			m.put(this.competitors.get(i),this.competitors.get(i).getScore());
		}
		this.rank = m.entrySet().stream().sorted((i1, i2)
                    -> i1.getValue().compareTo(
                       i2.getValue())).collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (e1, e2) -> e1, LinkedHashMap::new));
	} 
	*/

	/**
	 * do the tournament and update the qualify list 
	 * @param List<Competitor> compet
	 */
	public void play(List<Competitor> compet) {
		for (int z=0 ; z<this.qualify.size() ; z++) {
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
	}
	
	
	/**
	 * return the winner of the tournament 
	 * @return name of the winner 
	 */
	public String winnerTournament() {
		return "Le vainqueur du tournoi est " + this.winner ;
	}

	
}
