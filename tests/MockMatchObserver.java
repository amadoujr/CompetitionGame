import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MockMatchObserver implements Observer {
	
	private int n ;
	
	public MockMatchObserver() {
		super() ;
		this.n = 0;
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	@Override
	public void rectToMatch(Competitor c1, Competitor c2) {
		this.n = this.n+1 ;
	}
}
