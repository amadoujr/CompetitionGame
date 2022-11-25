import static org.junit.Assert.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import competition.Competition;
import competition.League;
import competitor.Competitor;
import match.Match;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class LeagueTest extends CompetitionTest {
	
	
	protected Competition createCompet(){
		
		Match match = new MockMatch();
		List<Competitor> competitors = new ArrayList<Competitor>();
		int i = 0;
		for (i = 0 ; i < 4 ; i++) {
			competitors.add(new Competitor("competitor "+i));    // Adding competitors to the competition
		}
		return new League(competitors, match);
		
	}

	
	@Test
	public void rankingTest() {
		System.out.println("-----------");
		super.rankingTest();
		Competitor c1 = compet.getCompetitors().get(0);
		System.out.println(c1);                                     // we have 4 competitors and we used a Mock for the match 
		assertThat(this.compet.getScore().get(c1),is(equalTo(3)));  // So each competitors had the same score 
	
	}
}
