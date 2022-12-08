package observer;

import java.util.*;
import competitor.Competitor;

public class BookMakers implements Observer {
	
	/**
	 * contains odds of every competitor
	 */
	private Map<Competitor,Integer> odds; 
	
	public Map<Competitor, Integer> getOdds() {
		return odds;
	}

	public void setOdds(Map<Competitor, Integer> odds) {
		this.odds = odds;
	}

	public BookMakers() {
		this.odds = new HashMap<>();
		}

	/** */
	public void reactToMatch(Competitor c1,Competitor c2) {
		this.odds.put(c1,c1.getOdd()-1);
		c1.setOdd(c1.getOdd()-1);
		this.odds.put(c2,c2.getOdd()+1);
		c2.setOdd(c2.getOdd()+1);
		System.out.println(this.toString()+" : " +c1 +" 's actually quotation is "+this.odds.get(c1) +" | "+ c2 +"' s actual quotation is "
		+ this.odds.get(c2));
	}

	@Override
	public String toString() {
		return "BookMakers ";
	}
	

}
