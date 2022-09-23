package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.League;
import competitor.Competitor;
import match.Match;

class LeagueTest {
	
	private League league;
	private Match match;
	private List<Competitor> competitors;
	
	@BeforeEach
	void setUp() throws Exception {
		this.league = new League(competitors);
		this.competitors = new ArrayList<>();
		
		
	}

	@Test 
	public void WinnerOfheLeagueTest() { 
	}
	
	@Test
	public void PlayMatchTest(){
		Competitor c1 = new Competitor("jean");
		Competitor c2 = new Competitor("pierre");
		this.league.playMatch(c1, c2);
		assertEquals(c1.getScore(), 1);
	}
}
