package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import competition.Competition;
import competition.NotRowofTwoException;
import competition.Tournament;
import competitor.Competitor;
import match.Match;
import match.RandomVictoryMatch;
import java.util.*;

class TournamentTest extends CompetitionTest {
	
	private Tournament tournament;
	

	@BeforeEach
	void setUp() throws Exception { 
		Match m = new MockMatch();
		this.tournament = new Tournament(competitors ,m);
	}
	 
	@Test
	public void getQualifyTestOK() {
		Competitor c1 = new Competitor("madrid");  Competitor c2 = new Competitor("barcelone");
		this.competitors.add(c1);  this.competitors.add(c2);
		this.tournament.setQualify(this.competitors);
		assertTrue(this.tournament.getQualify().equals(this.competitors));
		assertTrue(this.tournament.getQualify().size() == 2);
	}
	
	@Test
	public void setQualifyTestOK() {
		Competitor c1 = new Competitor("madrid");
		this.competitors.add(c1);
		this.tournament.setQualify(this.competitors);
		assertTrue(this.tournament.getQualify().equals(this.competitors));
		assertTrue(this.tournament.getQualify().size() == 1);
	}
	
	@Test
	public void getCompetitorsTestOK() {
		Competitor c1 = new Competitor("madrid");
		this.competitors.add(c1);
		assertTrue(this.tournament.getCompetitors().get(0).equals(c1));
		assertTrue(this.tournament.getCompetitors().size() == 1);  
	}

	
	

	



	@Test 
	public void playTournamentANDwinnerTournamentTestOK() { 
		Competitor c1 = new Competitor("madrid");  Competitor c2 = new Competitor("barcelone");
		Competitor c3 = new Competitor("valence"); Competitor c4 = new Competitor("séville");
	    this.competitors.add(c1); this.competitors.add(c2); 
	    this.competitors.add(c3); this.competitors.add(c4); 
	    try {
			this.tournament.play(this.competitors);
		} catch (NotRowofTwoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(this.tournament.getQualify());
	    assertTrue(this.tournament.getQualify().size() == 1);
	    assertTrue(this.tournament.winnerTournament().contains("Le vainqueur du tournoi est " + this.tournament.getWinner() )); 
	    assertTrue(this.tournament.getScore().get(c1) == 3);
	    System.out.println(this.tournament.getWinner());
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
		assertTrue(this.compet.getScore().get(c1)==2);
	}
	  

}
