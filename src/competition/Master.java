package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;

public class Master extends Competition {
	
		private League league;
		private Tournament tournament ;
		private List<Competitor> league_competitors ;/* tout les competiteurs */
		private List<Competitor> tournament_competitors;/* qualifiés pour seconde manche */
		

	public Master(List<Competitor> competitors) {
		super(competitors);
		this.league= new League(this.competitors, m1);
		this.tournament = new Tournament(this.competitors,m1);
		this.league_competitors = new ArrayList<>();
		this.tournament_competitors = new ArrayList<>();
	}

	@Override
	protected void play(List<Competitor> competitors) {
		// TODO Auto-generated method stub
		
	}

}
