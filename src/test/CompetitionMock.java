package test;

import java.util.List;

import competition.Competition;
import competitor.Competitor;

public class CompetitionMock extends Competition {
	
	private int occurence ;
	
	
	public CompetitionMock(List<Competitor> c) {
		super(c);
		this.occurence = 0;
		
	}

	@Override
	protected void play(List<Competitor> competitors) {
		/*// TODO Auto-generated method stub
		super.play();
		this.occurence++;*/
		
		
	}
	public void play () {
		this.occurence++;
		super.play();
	}
	public int getOccurence() {
		return this.occurence;
	}
	public void setOccurence(int nb) {
		this.occurence = nb;
		}
	

}
