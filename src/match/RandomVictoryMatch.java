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
	public void winnerOfTheGame(Competitor c1 , Competitor c2) {
		
		Random random = new Random();
		float f = random.nextFloat();
		if (f<0.5){
			System.out.println(c1.getName()+ " vs " + c2.getName()+ " --> " + c1.getName() + " wins! ");
			c1.setScore(c1.getScore()+1);
		}
		else {
			System.out.println(c1.getName() + " vs " + c2.getName() + " --> " + c2.getName() + " wins! ");
			c2.setScore(c2.getScore()+1);
		}
	}
} 
