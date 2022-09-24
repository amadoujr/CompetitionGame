package competition;

import java.util.*;


import competitor.Competitor;
import match.*;

public class Tournament extends Competition {
	private List<Competitor> qualify ;
	private Competitor winner ;
	
	public Tournament(List<Competitor> competitors) {
		super(competitors);
	}

	public List<Competitor> getQualify() {
		return qualify;
	}

	
//	public apresMatch(Competitor c1,Competitor c2) {
		
//	}
	
	public void play(List<Competitor> compet) {
		this.qualify = compet ;
		while (this.qualify.size() > 1) {
			int l = this.qualify.size() ;
			Collections.shuffle(this.qualify);
			int n = 0 ;
			for (int i=0 ; i<(l/2) ; i++) {
//				apresMatch(this.qualify.get(n),this.qualify.get(n+1));	
				n += 2 ;
			}
		this.winner = this.qualify.get(0) ;
		}
	}

	
}
