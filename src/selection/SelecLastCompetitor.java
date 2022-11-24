package selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import competitor.Competitor;
import competition.*;

public class SelecLastCompetitor implements Selection {

	/**
	 * keep only the two last of each pools for the next round
	 * the number of competitor must be a power of 2.
	 * @param qualified contains a list of leagues
	 * @return list of competitor.
	 */
	public List<Competitor> getFinalist(List<League> qualified) {
		List<Competitor> qualifiedcompet = new ArrayList<>();
		for (League l : qualified) {
			qualifiedcompet.addAll(this.selectPlayer(l.getScore()));
			System.out.println();
		}
		Competition.displayer.displaymsg("here is the last two competitor of each pool : ");
		System.out.println();
		System.out.println("\t" + qualifiedcompet);
		System.out.println();
		return qualifiedcompet;
	}

	/**
	 * @param map contains all competitors and their score
	 * @return a list which contains the two last player of each pools
	 */
	public List<Competitor> selectPlayer(Map<Competitor, Integer> map) {
		List<Integer> score = new ArrayList<>() ;
		for (Map.Entry<Competitor, Integer> entry : map.entrySet()) {    // retrieving scores from a list 
            Integer points = entry.getValue();
            score.add(points);
		}
		Collections.sort(score);										// sorting scores in ascending order
		int n = 0;
		List<Competitor> qualif = new ArrayList<>();
		while (n!= 2) {
			for (Map.Entry<Competitor, Integer> entry : map.entrySet()) {   
				Competitor c = entry.getKey() ;
	            Integer points = entry.getValue();
	            if (n==0) {
	            	if (points == score.get(0)) {  // check if score competitor is equal to the desired score 
	            		qualif.add(c);				
	            		n += 1 ;
	            	}
	            }
	            if (n==1) {
	            	if (points == score.get(1) && ! qualif.contains(c) ) {
	            		qualif.add(c);
	            		n += 1 ;
	            	}
	            }
			}
		}
		return qualif;
	}

}
