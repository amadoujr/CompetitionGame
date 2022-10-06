package competitor; 

public class Competitor {
	
	// attribute
	private String name;
	private int score;
	private boolean qualification;
	
	/**
	 * initialize the constructor
	 * @param name name of the competitor
	 * @param score score he obtains after a match
	 */
	public Competitor(String name){
		this.name = name;
		this.qualification = true ;
	}
	
	
	// methods
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
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
