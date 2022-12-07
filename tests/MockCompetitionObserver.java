import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MockCompetitionObserver implements CompetitionObserver {
	
	private int n ;
	
	public int getN() {
		return n;
	}
	
	public void setN() {
		this.n = n;
	}
	
	@Override 
	public void update(Competition c) {
		this.n = n+1;
	}
}
