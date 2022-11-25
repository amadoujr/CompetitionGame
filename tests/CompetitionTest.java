import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import competition.Competition;
import competitor.Competitor;

public abstract class CompetitionTest {
	
	protected Competition compet;

	@BeforeEach
	void initialisation() {
		this.compet = this.createCompet();
	}
	
	/**
	 * this methods create an instance of Competition from the subclasses
	 * @return an instance of Competition
	 */
	protected abstract Competition createCompet();

	
	/**
	 *  testing methods playMatch of competition  
	 */
	@Test
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
	

}
