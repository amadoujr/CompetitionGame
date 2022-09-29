package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competitor.Competitor;

class CompetitorTest {
	
	private String name;
	private int score;
	private Competitor competitor;
	
	@BeforeEach
	void setUp() throws Exception { 
		this.name = "Grosthier";
		this.competitor = new Competitor(name);
	}
	
	@Test
	public void getNameTestOK() {
		assertTrue(this.competitor.getName().equals(this.name));
	}
	
	@Test
	public void setNameTestOK() {
		this.competitor.setName("BetonArmé");
		assertTrue(this.competitor.getName().equals("BetonArmé"));
	}
	
	@Test
	public void getScoreTestOK() {
		assertTrue(this.competitor.getScore() == 0);
	}
	
	@Test
	public void setScoreTestOK() {
		this.competitor.setScore(5);
		assertTrue(this.competitor.getScore() == 5);
	}
	
	@Test
	public void toStringTestOK() {
		assertTrue(this.competitor.toString().equals(this.competitor.getName()));
	}

}
