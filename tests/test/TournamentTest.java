package test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import competition.Competition;
import competition.NotRowofTwoException;
import competition.Tournament;
import competitor.Competitor;
import match.Match;


import java.util.*;

class TournamentTest extends CompetitionTest {
	
	private Tournament tournament;
	
	@Override
	protected Competition createCompet() {
		List<Competitor> c = new ArrayList<Competitor>();
		int i = 0;
		for (i = 0 ; i < 4 ; i++) {
			c.add(new Competitor("competitor "+i,i));    // Adding competitors to the competition
		}
		Match match = new MockMatch();
		return new Tournament(c, match);
		}
	
	/**
	 * test proper to tournament
	 */
	
	@Test 
	public void playTournamentANDwinnerTournamentTestOK() { 
		List<Competitor> competitors = new ArrayList<>();
		Competitor c1 = new Competitor("madrid", 0);  Competitor c2 = new Competitor("barcelone",1);
		Competitor c3 = new Competitor("valence",2); Competitor c4 = new Competitor("séville",3);
	    competitors.add(c1); competitors.add(c2); 
	    competitors.add(c3); competitors.add(c4); 
		Match m = new MockMatch();
		this.tournament = new Tournament(competitors ,m);

	    try {
			this.tournament.play(competitors);
		} catch (NotRowofTwoException e) {
			e.printStackTrace();
		}
	    assertFalse(this.tournament.getQualify().size() != 1);
	    assertFalse(this.tournament.getScore().get(c1) != 2);
	}
	
	
	@Test
	public void rankingTest() {
		System.out.println("-----------");
		super.rankingTest();
		Competitor c1 = compet.getCompetitors().get(0);
		System.out.println(c1);
		assertTrue(c1.getScoreP()==2);
	}
	  
	@Test
	public void observersCompetitionTest() {
		MockMatchObserver mockMO = new MockMatchObserver();
		MockCompetitionObserver mockCO = new MockCompetitionObserver() ;
		this.compet.addObservers(mockMO);
		this.compet.addObservers(mockCO);
		int total = 0;
		this.compet.play();
		for(Competitor c : this.compet.getCompetitors()) {
			total = total + this.compet.ranking().get(c);
		}
		assertTrue(total  == mockCO.getN());
		assertTrue(total  == mockMO.getN());
	}
}
