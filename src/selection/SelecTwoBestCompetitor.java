package selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import competition.*;
import competitor.Competitor;

public class SelecTwoBestCompetitor implements Selection {


	/**
	 * keep only the best of each pools for the next round
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
		Competition.displayer.displaymsg("Here is the best two competitor of each pool : ");
		System.out.println();
		System.out.println("\t" + qualifiedcompet);
		System.out.println();
		return qualifiedcompet;
	}
	/**
	 * @param map contains all competitors and their score
	 * @return a list which contains the two best player of each pools
	 */
	public List<Competitor> selectPlayer(Map<Competitor, Integer> map) {
		Set<Competitor> iter = map.keySet();
		Iterator<Competitor> it = iter.iterator();
		Competitor comp1 = it.next();  // take the first player who has the most points
		Competitor comp2 = it.next();  // take the second player who has the most points 
		List<Competitor> qualif = new ArrayList<>();
		qualif.add(comp1);
		qualif.add(comp2);
		return qualif;
		
	}
}
