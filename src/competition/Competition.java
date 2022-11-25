package competition;
import java.util.*;
import competitor.Competitor;
import display.Display;
import match.*;
import observer.Observer;
import observer.CompetitionObservable;


public abstract class Competition implements CompetitionObservable {
	
	/*Lists of attributes necessary for the competition */

	protected Match match;
	protected final List<Competitor> competitors;
	protected boolean finished ;
	public static final Display displayer = new Display();
	protected Map<Competitor,Integer> score;
	protected List<Observer> observers;
	protected Map<Competitor,Integer> odds;
	protected String state;
	
	/**
	 * initialize the constructor
	 */
	public Competition(List<Competitor> competitors, Match m1) {
		this.match = m1;
		this.competitors = competitors;
		this.score = new HashMap<>();
		this.observers = new ArrayList<>();
		this.odds= new HashMap<>();
		this.initializeScore();
	}
	
	/**
	 * 
	 * @return the list of competitors
	 */
	public List<Competitor>getCompetitors() { 
		return this.competitors ;
	}
	/** 
	 * @return a map which contains names and scores of each competitors
	 */
	public Map<Competitor, Integer> getScore() {
		return score;
	}
	/**
	 * set score of competitors
	 * @param score
	 */
	public void setScore(Map<Competitor, Integer> score) {
		this.score = score;
	}
	
	
	/**
	 * reset the score of competitors to zero before the next competition
	 */
	public void initializeScore () {
		for (int i=0 ; i<this.competitors.size(); i++) {
			this.score.put(this.competitors.get(i), 0);
		}
	}
	
	/**
	 * this methods runs a competition till the end
	 */
	public void play() {
		while(!this.isFinished()) {   // end of the game reached ?
			try {
				this.play(competitors);
			} catch (NotRowofTwoException e) {
				e.printStackTrace();
				System.exit(0);
			}   
			this.finished = true;   
		}
		System.out.println();
		this.ranking(); 
		this.displayRanking(); // display the ranking of the tournament
		System.out.println();
	}
	
	/**
	 * @return true if the game is finished otherwise false
	 */
	private boolean isFinished() {
		// TODO Auto-generated method stub
		return this.finished;
	}

	/**
	 * make each competitor play against each other
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	public void playMatch(Competitor c1, Competitor c2) {
		if (this.match.winnerOfTheGame(c1, c2).equals(c1)) {
			c2.setQualification(false) ; 
			this.score.put(c1, this.score.get(c1)+1) ;
			c1.setScoreP(c1.getScoreP()+1);
			Competition.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c1 +" win!!");
		}
		else {
			c1.setQualification(false) ;
			this.score.put(c2, this.score.get(c2)+1) ;
			c2.setScoreP(c2.getScoreP()+1);
			Competition.displayer.displaymsg(c1 +" vs "+ c2 + " --> " + c2 +" win!!");
			
		}
	}
	
	/** 
	 * organize match between competitors
	 * @param competitor
	 */
	protected abstract void play(List<Competitor> competitors) throws NotRowofTwoException;
	
	/**
	 * sort competitors by points descendant;
	 * @return ranking of each competitors
	 */
	public Map<Competitor,Integer> ranking(){
		if (this instanceof Master ) {
			for (int i=0 ; i<this.competitors.size(); i++) {
				this.score.put(this.competitors.get(i), this.competitors.get(i).getScoreP());
			score = MapUtil.sortByDescendingValue(score);
			}
		}
		else {
			score = MapUtil.sortByDescendingValue(score);
		}
		return score;
	}
	
	/**
	 * display ranking of the competition
	 */
	public void displayRanking() {
		System.out.println("*** Ranking ***");
		System.out.println();
		for( Map.Entry <Competitor, Integer> entry : this.ranking().entrySet()) {
			Competition.displayer.displaymsg(entry.getKey() + " - "+ entry.getValue());
		}
	}
	
	/**
	 * this method add the observer to the competition and he will be able to do some kind of thing
	 * that we will define
	 * @param observer the observer to add
	 */
	public void addObservers (Observer observer) {
		this.observers.add(observer);
	};
	/**
	 * the method remove the observer from the competition
	 * @param observer the observer to remove
	 */
	public void removeObersver (Observer observer) {
		this.observers.remove(observer);
	};
	/**
	 * this method notify observers about changes happens on the competition
	 */
	public void notifyObserver() {
		for (Observer observer : this.observers) {
			observer.update(this);
		}
	}
	
	public void setState() {
		this.notifyObserver();
	}
	
	public String getState() {
		return this.state;
	}
	
	public void state(String state) {
		this.state = state;
	}
	
		
	
}
