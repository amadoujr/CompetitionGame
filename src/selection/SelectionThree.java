package selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import competition.Competition;
import competition.League;
import competitor.Competitor;

public class SelectionThree implements Selection {
	
	
	/**
	 * keep only the best  of each pools and also the best third  if the number of leagues is 
	 * not a power of 2 for the next round
	 * @param qualified contains a list of leagues
	 * @return list of competitor.
	 */
	@Override
	public List<Competitor> getFinalist(List<League> qualified) {
		// TODO Auto-generated method stub
		int cpt =0;
		List<Competitor> qualifiedcompet = new ArrayList<>();
		for (League l : qualified) {
			l.play();
			qualifiedcompet.addAll(this.selectPlayer(l.getScore()));
			cpt+=1;
			Competition.displayer.displaymsg("-----------------------------------------");
			Competition.displayer.displaymsg("ci-dessus, le classement de la poule "+ cpt);
			Competition.displayer.displaymsg("-----------------------------------------");
			System.out.println();
		}
		if (qualifiedcompet.size()%2 !=0) {
			repeche(qualified, qualifiedcompet);
		}
		Competition.displayer.displaymsg("here is the best competitor of each pool : ");
		System.out.println();
		System.out.println("\t" + qualifiedcompet);
		System.out.println();
		return qualifiedcompet;
	}
	
	/**
	 * @param map contains all competitors and their score
	 * @return a list which contains the  best player of each pool
	 */
	@Override
	public List<Competitor> selectPlayer(Map<Competitor, Integer> map) {
		// TODO Auto-generated method stub
		Set<Competitor> iter = map.keySet();
		Iterator<Competitor> it = iter.iterator();
		Competitor comp1 = it.next();  // take the first player who has the most points
		List<Competitor> qualif = new ArrayList<>();
		qualif.add(comp1);
		return qualif;
		
	}
	/**
	 * 
	 * add the best_tird to the list for the tournament 
	 * @param quialified contains all the leagues , the list of the competitors for the tournament 
	 */
	public  void repeche(List<League> qualified ,List<Competitor> liste){
		Competitor best_tird = null;
		int score = 0 ;
		for (League l : qualified) {
			l.play();
			Set<Competitor> iter = l.getScore().keySet();
			Iterator<Competitor> it = iter.iterator();
			it.next(); it.next(); 
			Competitor comp =it.next();// take the third player who has the most points
			if (l.getScore().get(comp)> score ) {
				best_tird = comp;
				score = l.getScore().get(comp);
			}
			
	}
		liste.add(best_tird);
	}
		
		
		
		
		
		
		
		
		
		
		
		

	

}
