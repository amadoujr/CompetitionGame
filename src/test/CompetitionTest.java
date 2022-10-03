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
	
	private  List<Competitor> competitors ;
	private Match m1; 

	@BeforeEach
	void setUp() throws Exception {
		this.competitors = new ArrayList<Competitor>(); 
		this.m1= new RandomVictoryMatch();
	}

	@Test
	public void Playtest() {
		Competition tour = new Tournament (this.competitors, this.m1);
		CompetitionMock mock = new CompetitionMock(this.competitors);
		assertTrue(mock.getOccurence()== 0);
		tour.play();
		assertTrue(mock.getOccurence()== 1);
		
	}
	

}
