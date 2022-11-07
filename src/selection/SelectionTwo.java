package selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competitor.Competitor;
import competition.*;

public class SelectionTwo implements Selection {

	/**
	 * keep only the two last of each pools for the next round
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
			int taille = l.getCompetitors().size() ;
			qualifiedcompet.add(l.getCompetitors().get(taille-2));
			qualifiedcompet.add(l.getCompetitors().get(taille-1));
		}
		System.out.println(qualifiedcompet);
		return qualifiedcompet;
	}

	@Override
	public List<Competitor> selectPlayer(Map<Competitor, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
