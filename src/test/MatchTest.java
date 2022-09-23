package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competitor.Competitor;

class MatchTest {
	
	Competitor c1,c2;
	MockMatch m1;
	 
	
	@BeforeEach
	void setUp(){
		this.m1 = new MockMatch();
		this.c1 = new Competitor("competitor 1");
		this.c2 = new Competitor("competitor 2");
	} 

	@Test
	public void WinnerBetweenTwoCompetitors(){
		int points_c1 = c1.getScore();
		assertEquals(c1.getScore(),points_c1);
		this.m1.winnerOfTheGame(c1,c2);
		assertEquals(c1.getScore(), points_c1 + 1);
	}
}