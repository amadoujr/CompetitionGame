package selection;

import java.util.ArrayList;
import java.util.List;
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
		List<Competitor> qualifiedcompet = new ArrayList<>();
		for (League l : qualified) {
			l.play();
			System.out.println();
			qualifiedcompet.add(l.getCompetitors().get(0));
		}
		System.out.println(qualifiedcompet);
		return qualifiedcompet;
	}

}
