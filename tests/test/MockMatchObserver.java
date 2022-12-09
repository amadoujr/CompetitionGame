package test;

import competitor.Competitor;
import observer.Canal;

public class MockMatchObserver extends Canal {
	
	private int n ;
	
	public int getN() {
		return n;
	}
	
	public void reactToMatch(Competitor c1, Competitor c2) {
		this.n = this.n+1 ;
		super.reactToMatch(c1, c2);
	}


}
