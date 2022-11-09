package selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import competitor.Competitor;
import competition.*;

public class SelectionFive implements Selection {

	/**
	 * keep only the first four of each pools for the next round
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
			cpt += 1;
			qualifiedcompet.addAll(this.selectPlayer(l.getScore()));
			Competition.displayer.displaymsg("-----------------------------------------");
			Competition.displayer.displaymsg("ci-dessus, le classement du poule "+ cpt);
			Competition.displayer.displaymsg("-----------------------------------------");
			System.out.println();
		}
		Competition.displayer.displaymsg("here is the first four of each pool : ");
		System.out.println();
		System.out.println("\t" + qualifiedcompet);
		System.out.println();
		return qualifiedcompet;
	}

	/**
	 * @param map contains all competitors and their score
	 * @return a list which contains the first four of each pools
	 */
	public List<Competitor> selectPlayer(Map<Competitor, Integer> map) {
		List<Integer> score = new ArrayList<>() ;
		for (Map.Entry<Competitor, Integer> entry : map.entrySet()) {
            Integer points = entry.getValue();
            score.add(points);
		}
		Collections.sort(score);
		int n = 0;
		List<Competitor> qualif = new ArrayList<>();
		while (n!= 4) {
			for (Map.Entry<Competitor, Integer> entry : map.entrySet()) {
				Competitor c = entry.getKey() ;
	            Integer points = entry.getValue();
	            if (n==0) {
	            	if (points == score.get(score.size()-1)) {
	            		qualif.add(c);
	            		n += 1 ;
	            	}
	            }
	            if (n==1) {
	            	if (points == score.get(score.size()-2)) {
	            		qualif.add(c);
	            		n += 1 ;
	            	}
	            }
	            if (n==2) {
	            	if (points == score.get(score.size()-3)) {
	            		qualif.add(c);
	            		n += 1 ;
	            	}
	            }
	            if (n==3) {
	            	if (points == score.get(score.size()-4)) {
	            		qualif.add(c);
	            		n += 1 ;
	            	}
	            }
			}
		}
		return qualif;
	}

}