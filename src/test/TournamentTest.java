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
	private List<Competitor> qualify;

	@BeforeEach
	void setUp() throws Exception { 
		this.competitors = new ArrayList<>();
		this.m1 = new MockMatch();
		this.tournament = new Tournament(competitors , m1,qualify);
	}
	
	@Test
	public void apresMatchTestOK() {
		Competitor c1 = new Competitor("madrid");
		Competitor c2 = new Competitor("barcelone");
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.qualify = new ArrayList<Competitor>(this.competitors);
		assertTrue(this.qualify.size() == 2);
		this.tournament.apresMatch(c1, c2);
		assertTrue(this.qualify.size() == 1);
	}

}
