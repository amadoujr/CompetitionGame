package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.Competition;
import competition.Tournament;
import competitor.Competitor;
import match.Match;
import match.RandomVictoryMatch;

public abstract class CompetitionTest {
	
	protected Competition compet;
	private  List<Competitor> competitors ;
	private Match m1; 

	@BeforeEach
	void init() {
		this.compet = this.createCompet();
		this.competitors = new ArrayList<Competitor>(); 
		this.m1= new RandomVictoryMatch();
	}

	protected abstract Competition createCompet();

	
	/* on teste la methode play() de competition */
	@Test
	public void Playtest() {
		/*Competition tour = new Tournament (this.competitors, this.m1);*/
		CompetitionMock mock = new CompetitionMock(this.competitors);
		assertTrue(mock.getOccurence()== 0);
		mock.play();
		assertTrue(mock.getOccurence()== 1);
		
	}
	/* on test les methode play(List) de league  et tournois */
	@Test
	public void  playTest() {
		assertTrue(this.compet.getcompteur() == 0 );
		this.compet.play();
		assertTrue(this.compet.getcompteur() == 1 );
		
	}
	

}
