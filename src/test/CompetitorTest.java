package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competitor.Competitor;

class CompetitorTest {
	
	private String name;
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
	public void getQualificationTestOK() {
		assertTrue(this.competitor.getQualification() == true);
	}
	
	@Test
	public void setQualificationTestOK() {
		this.competitor.setQualification(false);
		assertTrue(this.competitor.getQualification() == false);
	}
	
	@Test
	public void toStringTestOK() {
		assertTrue(this.competitor.toString().equals(this.competitor.getName()));
	}

}
