package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import competition.Tournament;
import competitor.Competitor;
import match.Match;
import java.util.*;

class TournamentTest {
	
	private Tournament tournament;
	private List<Competitor> competitors;
	private Match m1; 

	@BeforeEach
	void setUp() throws Exception { 
		this.competitors = new ArrayList<>();
		this.m1 = new MockMatch();
		this.tournament = new Tournament(competitors , m1);
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
	
	
/*	@Test
	public void apresMatchTestOK() {
		Competitor c1 = new Competitor("madrid");  Competitor c2 = new Competitor("barcelone");
		this.competitors.add(c1);  this.competitors.add(c2);
		this.tournament.setQualify(this.competitors);
		this.tournament.playMatch(c1, c2);
		assertTrue(c2.getQualification() == false);
		assertTrue(c1.getScore() == 1);
		assertTrue(c1.getQualification() == true) ;
		
	}*/
	
	@Test 
	public void playTournamentANDdoingRankANDwinnerTournamentTestOK() { 
		Competitor c1 = new Competitor("madrid");  Competitor c2 = new Competitor("barcelone");
		Competitor c3 = new Competitor("valence"); Competitor c4 = new Competitor("séville");
	    this.competitors.add(c1); this.competitors.add(c2); 
	    this.competitors.add(c3); this.competitors.add(c4); 
	    this.tournament.play(this.competitors);
	    assertTrue(this.tournament.getQualify().size() == 1);
	    assertTrue(this.tournament.winnerTournament().contains("Le vainqueur du tournoi est " + this.tournament.getWinner() )); 
	    assertTrue(this.tournament.getWinner().getScore() == 2);
	    System.out.println(this.tournament.getWinner());
	} 
	  
	 

}
