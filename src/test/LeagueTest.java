package test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.Competition;
import competition.League;
import competitor.Competitor;
import match.Match;
import match.RandomVictoryMatch;

class LeagueTest extends CompetitionTest {
	
	private League league;
	private List<Competitor> competitors;
	private Match m1; 
	
	@BeforeEach
	void setUp() throws Exception { 
		this.competitors = new ArrayList<>();
		this.m1 = new MockMatch();
		this.league = new League(competitors , m1);
	}

	@Test 
	public void WinnerOfheLeagueTest() { 
	}
	 
	@Test
	/*public void PlayMatchTest(){
		// create competitors
		Competitor c1 = new Competitor("jean");
		Competitor c2 = new Competitor("pierre");
		Competitor c3 = new Competitor("jonas");
		Competitor c4 = new Competitor("jacob");
		
		// adding competitors to the competitions
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		
		int nb_points  = 0;
		assertEquals(c1.getScore(), nb_points);
		this.league.play(competitors);
		assertEquals(c1.getScore() , 3);  // all competitors have the same points due to the use of a MockClass
		
	}*/

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
		Match match = new RandomVictoryMatch();
		
		
		// TODO Auto-generated method stub
		return new League(c, match);
	}
	@Test
	public void playTest() {
		super.playTest();
	}
}
