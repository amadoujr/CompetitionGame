import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import competition.Competition;
import competitor.Competitor;

public abstract class CompetitionTest {
	
	protected Competition compet;
	protected Match mockMO ;
	protected Match mockCO ;

	@BeforeEach
	void initialisation() {
		this.compet = this.createCompet();
		this.mockMO = new MockMatchObserver();
		this.mockCO = new MockCompetitionObserver();
	}
	
	/**
	 * this methods create an instance of Competition from the subclasses
	 * @return an instance of Competition
	 */
	protected abstract Competition createCompet();

	
	/**
	 *  testing methods playMatch of competition  
	 */
	@Testc
	public void PlayMatchTestCompetition() {
		
		Set <Competitor> c = this.compet.getScore().keySet();
		Iterator <Competitor> iter = c.iterator();
		Competitor c1 = iter.next();
		Competitor c2 = iter.next();
		assertTrue(c1.getScoreP() == 0);
		this.compet.playMatch(c1, c2);
		assertTrue(c1.getScoreP() == 1);
		
	}
	
	@Test
	public void rankingTest() {
		System.out.println(this.compet);
		this.compet.play();
			
	}
	
	@Test
	public void observersCompetitionTest() {
		this.mockMO.setN(0) ;
		this.mockCO.setN(0) ;
		int total = 0;
		this.compet.play();
		for(Competitor c : this.compet.getCompetitors()) {
			total = total + this.compet.ranking().get(c);
		}
		assertTrue(total ==this.mockMO.getN());
		assertTrue(this.mockCO.getN() >= 2);
	}
	
	

}
