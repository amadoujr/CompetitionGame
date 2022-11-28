package observer;

import competitor.Competitor;

public class Canal implements Observer {

	@Override
	public void update(CompetitionObservable observable) {
		System.out.println("Début de la Compétition \n");
		
		
		System.out.println();
		System.out.println("ci-dessus le classement finale de la competition");
		 
	}

	@Override
	public void react_to_match(Competitor c1,Competitor c2) {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+" : "+ c1 +" won the match over " +c2);
		
	}

	@Override
	public String toString() {
		return "canal+ ";
	}

}
