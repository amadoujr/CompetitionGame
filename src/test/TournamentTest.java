package test;

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
	
	/**
	 * test proper to tournament
	 */
	@Test 
	public void playTournamentANDwinnerTournamentTestOK() { 
		List<Competitor> competitors = new ArrayList<>();
		Competitor c1 = new Competitor("madrid");  Competitor c2 = new Competitor("barcelone");
		Competitor c3 = new Competitor("valence"); Competitor c4 = new Competitor("séville");
	    competitors.add(c1); competitors.add(c2); 
	    competitors.add(c3); competitors.add(c4); 
		Match m = new MockMatch();
		this.tournament = new Tournament(competitors ,m);

	    try {
			this.tournament.play(competitors);
		} catch (NotRowofTwoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    assertTrue(this.tournament.getQualify().size() == 1);
	    assertTrue(this.tournament.getScore().get(c1) == 2);
	}

	@Override
	protected Competition createCompet() {
		List<Competitor> c = new ArrayList<Competitor>();
		Competitor c1 = new Competitor("jean");
		Competitor c2 = new Competitor("pierre");
		Competitor c3 = new Competitor("jonas");
		Competitor c4 = new Competitor("jacob");


		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		Match match = new MockMatch();
		return new Tournament(c, match);
		} 
	
	@Test
	public void playTest() {
		super.playTest();
		
	} 
	@Test
	public void rankingTest() {
		System.out.println("-----------");
		System.out.println(this.compet.ranking());
		super.rankingTest();
		Competitor c1 = compet.getCompetitors().get(0);
		System.out.println(c1);
		assertTrue(c1.getScoreP()==2);
	}
	  

}
