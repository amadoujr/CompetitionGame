package match;

import java.util.Random;

import competitor.Competitor;

public class RandomVictoryMatch extends Match {
	 
	public RandomVictoryMatch(){}
	
	
	/**
	 * à completer ...
	 * @param c1
	 * @param c2
	 */ 
	public Competitor winnerOfTheGame(Competitor c1 , Competitor c2) {
		
		Random random = new Random();
		float f = random.nextFloat();
		if (f<0.5){
			return c1;
		}
		else {
			return c2;
		}
	}
} 
