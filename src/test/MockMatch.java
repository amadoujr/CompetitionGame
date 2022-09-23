package test;

import competitor.Competitor;
import match.RandomVictoryMatch;

public class MockMatch extends RandomVictoryMatch {

	public void winnerOfTheGame(Competitor c1, Competitor c2) { 
		// TODO Auto-generated method stub
		
		c1.setScore(1);
	} 
	
	
}
