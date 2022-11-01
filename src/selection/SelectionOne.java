package selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import competition.*;
import competitor.Competitor;

public class SelectionOne implements Selection {


	/**
	 * keep only the best of each pools for the next round
	 * the number of competitor must be a power of 2.
	 * @param qualified contains a list of leagues
	 * @return list of competitor.
	 */
	public List<Competitor> getFinalist(List<League> qualified) {
		// TODO Auto-generated method stub
		int cpt = 0;
		List<Competitor> qualifiedcompet = new ArrayList<>();
		for (League l : qualified) {
			l.play();
			qualifiedcompet.addAll(this.selecTwoBestPlayer(l.getScore()));
			cpt+=1;
			Competition.displayer.displaymsg("-----------------------------------------");
			Competition.displayer.displaymsg("ci-dessus, le classement du poule "+ cpt);
			Competition.displayer.displaymsg("-----------------------------------------");
			System.out.println();
		}
		Competition.displayer.displaymsg("here is the best two competitor of each pool : ");
		System.out.println();
		System.out.println("\t" + qualifiedcompet);
		System.out.println();
		return qualifiedcompet;
	}
	/**
	 * @param map contains all competitors and their score
	 * @return a list which contains the two best player of each pools
	 */
	public List<Competitor> selecTwoBestPlayer(Map<Competitor, Integer> map) {
		Set<Competitor> iter = map.keySet();
		List<Competitor> qualif = new ArrayList<>();
		Iterator<Competitor> it = iter.iterator();
		Competitor comp1 = it.next();
		Competitor comp2 = it.next();
		qualif.add(comp1);
		qualif.add(comp2);
		return qualif;
		
	}
}
