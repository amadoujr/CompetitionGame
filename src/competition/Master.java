package competition;

import java.util.ArrayList;
import java.util.List;
import selection.*;
import competitor.Competitor;
import match.Match;
import observer.Canal;
import observer.Observer;
import partition.Partition;

public class Master extends Competition {

	/**
	 * Attribute selection - will allow us to choose the type of selection methods
	 * we want partition - will allow us to choose the type or partition methods we
	 * want
	 */
	private List<League> leagues;
	private Selection selection;
	private Partition partition;
	private Tournament tournament;

	/**
	 * Initialize the constructor
	 * 
	 * @param competitors number of competitors
	 * @param match       type of match
	 * @param selection   type of selection methods we want
	 * @param partition   type or partition methods we want
	 */
	public Master(List<Competitor> competitors, Match match, Selection selection, Partition partition) {
		super(competitors, match);
		this.leagues = new ArrayList<League>();
		this.selection = selection;
		this.partition = partition;
	}

	/**
	 * this methods generate pools and selection qualified competitor for the second
	 * phase in order to make them play the tournament
	 * 
	 * @param competitors
	 */
	protected void play(List<Competitor> competitors) {

		List<List<Competitor>> pools = new ArrayList<>();
		pools = this.partition.doPartition(competitors);
		this.launchpools(pools);
		this.poolPlay();
		List<Competitor> qualified = this.selection.getFinalist(leagues);
		this.tournament = new Tournament(qualified, this.match);
		for (Observer o : this.observers) {
			this.tournament.addObservers(o);
		}
		this.tournament.play();
	}

	/**
	 * create pools for the leagues and play them by the way
	 * 
	 * @param pools correspond to the pools
	 */
	public void launchpools(List<List<Competitor>> pools) {
		for (List<Competitor> c : pools) {
			League l = new League(c, this.match);
			this.leagues.add(l);
			for (Observer o : this.observers) {
				l.addObservers(o);
			}
		}
		
	}

	public void poolPlay() {
		for (League l : this.leagues) {
			l.play();
		}
	}

	/**
	 * this method add the observer to the competition and he will be able to do
	 * some kind of thing that we will define
	 * 
	 * @param observer the observer to add
	 */
	public void addObservers(Observer observer) {
		super.addObservers(observer);
		if (!this.leagues.isEmpty()) {
			for (League l : this.leagues) {
				l.addObservers(observer);
			}
		}
		/*if(! this.tournament.equals(null)) {
			this.tournament.addObservers(observer);
		}*/
		
		
	};

	/**
	 * the method remove the observer from the competition
	 * 
	 * @param observer the observer to remove
	 */
	public void removeObserver(Observer observer) {
		super.removeObserver(observer);
		if (!this.leagues.isEmpty()) {
			for (League l : this.leagues) {
				l.removeObserver(observer);
			}
		}
		/*if(! this.tournament.equals(null)) {
			this.tournament.removeObserver(observer);
			}*/
	};

}
