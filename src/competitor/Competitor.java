package competitor;

public class Competitor {
	
	// attribute
	private String name;
	private boolean qualification;
	private  int scoreP;
	private int odd;
	
	


	/**
	 * initialize the constructor
	 * @param name name of the competitor
	 * @param score score he obtains after a match
	 */
	public Competitor(String name,int cote){
		this.name = name;
		this.qualification = true ;
		this.scoreP = 0;
		this.odd =cote ;
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
	
	
	public int getOdd() {
		return odd;
	}


	public void setOdd(int odd) {
		this.odd = odd;
	}
	
	
}
