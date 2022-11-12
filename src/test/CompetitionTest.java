package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import competition.Competition;
import competitor.Competitor;
import match.Match;

public abstract class CompetitionTest {
	
	protected Competition compet;
	protected   List<Competitor> competitors ;

	@BeforeEach
	void init() {
		this.compet = this.createCompet();
		this.competitors = new ArrayList<Competitor>(); 
	}

	protected abstract Competition createCompet();

	
	/* testing methods play of  competition */
	@Test
	public void PlaytestCompet() {
		/*Competition tour = new Tournament (this.competitors, this.m1);*/
		Match m = new MockMatch();
		CompetitionMock mock = new CompetitionMock(this.competitors,m);
		assertTrue(mock.getOccurence()== 0);
		mock.play();
		assertTrue(mock.getOccurence()== 1);
		
	}
	/* Testing methods play(List) of leagues and tournament */
	@Test
	public void  playTest() {
		assertTrue(this.compet.getcompteur() == 0 );
		this.compet.play();
		assertTrue(this.compet.getcompteur() == 1 );

		
	}
	@Test
	public void rankingTest() {
		System.out.println(this.competitors);
		this.compet.play();
		
		
	}
	

}
