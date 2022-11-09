package competitor;

import java.util.HashMap;
import java.util.Map;

public class Competitor {
	
	// attribute
	private String name;
	private boolean qualification;
	protected int scoreP;
	
	/**
	 * initialize the constructor
	 * @param name name of the competitor
	 * @param score score he obtains after a match
	 */
	public Competitor(String name){
		this.name = name;
		this.qualification = true ;
		this.scoreP = 0;
	}
	
	
	// methods
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScoreP(int scoreP) {
		this.scoreP = scoreP;
	}
	
	public int getScoreP() {
		return scoreP;
	}
	
	public boolean getQualification() {
		return this.qualification;
	}
	
	public void setQualification(boolean b) {
		this.qualification = b;
	}

	@Override
	public String toString() {
		return name ; 
	}
	
	
}
