package tests;
import java.util.List;

import competition.League;
import competitor.Competitor;
import selection.SelecTwoBestCompetitor;

public class MockSelectionTwoBestCompet extends SelecTwoBestCompetitor {
		
		public int compteur;
		
		public List<Competitor> getFinalist(List<League> qualified) {
			this.compteur += 1;
			return super.getFinalist(qualified);
		}

}
