package competitor; 

public class Competitor {
	
	// attribute
	private String name;
	private int score;
	
	/**
	 * initialize the constructor
	 * @param name name of the competitor
	 * @param score score he obtains after a match
	 */
	public Competitor(String name){
		this.name = name;
	}
	
	
	// methods
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
