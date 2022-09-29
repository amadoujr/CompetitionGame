package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import competition.League;
import competition.Tournament;
import competitor.Competitor;
import match.Match;
import match.RandomVictoryMatch;
import java.util.*;

class TournamentTest {
	
	private Tournament tournament;
	private List<Competitor> competitors;
	private Match m1; 

	@BeforeEach
	void setUp() throws Exception { 
		this.competitors = new ArrayList<>();
		this.m1 = new RandomVictoryMatch();
		this.tournament = new Tournament(competitors , m1);
	}
	
	@Test
	public void apresMatchTestOK() {
		Competitor c1 = new Competitor("madrid");
		Competitor c2 = new Competitor("barcelone");
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.tournament.setQualify(this.competitors);
		this.tournament.apresMatch(c1, c2);
		assertTrue(this.tournament.getQualify().size() == 1);
		
	}
	
	@Test 
	public void playTournamentTestOK() {
		Competitor c1 = new Competitor("madrid");
		Competitor c2 = new Competitor("barcelone");
		Competitor c3 = new Competitor("valence");
		Competitor c4 = new Competitor("séville");
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		this.tournament.play(this.competitors);
//		assertTrue(this.tournament.getQualify().size() == 1);
	}

}
