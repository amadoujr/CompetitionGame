package tests;


import competitor.Competitor;
import observer.BookMakers;


public class MockCompetitionObserver extends BookMakers {
	
	private int n ;
	
	public int getN() {
		return n;
	}
	
	public void reactToMatch(Competitor c1,Competitor c2) {
		this.n = n+1 ;
		super.reactToMatch(c1, c2);
	}
	
	
}
