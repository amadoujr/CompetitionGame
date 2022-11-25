
import competitor.Competitor;
import match.RandomVictoryMatch;

class MockMatch extends RandomVictoryMatch {

	public Competitor winnerOfTheGame(Competitor c1 , Competitor c2) {
		
		return c1;
	}

}
