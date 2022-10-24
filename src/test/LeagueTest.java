package test;

import static org.junit.Assert.assertTrue;
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
	


	 
	@Test
	/*public void PlayMatchTest(){
		
		int nb_points  = 0;
		assertEquals(c1.getScore(), nb_points);
		league.play(competitors);
		System.out.println(c1.getScore());
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
		Match match = new MockMatch();
		
		
		// TODO Auto-generated method stub
		return new League(c, match);
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
		assertTrue(this.compet.getScore().get(c1)==3);
	}
}
