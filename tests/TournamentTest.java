import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import competition.Competition;
import competition.NotRowofTwoException;
import competition.Tournament;
import competitor.Competitor;
import match.Match;
import java.util.*;

class TournamentTest extends CompetitionTest {
	
	private Tournament tournament;
	
	@Override
	protected Competition createCompet() {
		List<Competitor> c = new ArrayList<Competitor>();
		int i = 0;
		for (i = 0 ; i < 4 ; i++) {
			c.add(new Competitor("competitor "+i));    // Adding competitors to the competition
		}
		Match match = new MockMatch();
		return new Tournament(c, match);
		}
	
	/**
	 * test proper to tournament
	 */
	
	@Test 
	public void playTournamentANDwinnerTournamentTestOK() { 
		List<Competitor> competitors = new ArrayList<>();
		Competitor c1 = new Competitor("madrid");  Competitor c2 = new Competitor("barcelone");
		Competitor c3 = new Competitor("valence"); Competitor c4 = new Competitor("séville");
	    competitors.add(c1); competitors.add(c2); 
	    competitors.add(c3); competitors.add(c4); 
		Match m = new MockMatch();
		this.tournament = new Tournament(competitors ,m);

	    try {
			this.tournament.play(competitors);
		} catch (NotRowofTwoException e) {
			e.printStackTrace();
		}
	    
	    assertTrue(this.tournament.getQualify().size() == 1);
	    assertTrue(this.tournament.getScore().get(c1) == 2);
	}
	
	/**
	 * doesn't function due to the asserthrows ... 
	  
	@Test
	public void playTournamentWithNotPowOfTwo() {
		List<Competitor> competitors = new ArrayList<>();
		int i = 0;
		for (i = 0 ; i < 3 ; i++) {
			competitors.add(new Competitor("competitor "+i));    // Adding competitors to the competition
		}
		Match m = new MockMatch();
		this.tournament = new Tournament(competitors,m);
		assertThrows(NotRowofTwoException.class,()->{
			this.tournament.play(); 
			});
	}
	*/
	
	
	@Test
	public void rankingTest() {
		System.out.println("-----------");
		super.rankingTest();
		Competitor c1 = compet.getCompetitors().get(0);
		System.out.println(c1);
		assertTrue(c1.getScoreP()==2);
	}
	  

}
