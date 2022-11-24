package observer;

import competition.Competition;

public class BeinSport implements Observer {
	
	@Override
	public void update(CompetitionObservable observable) {
		System.out.println("Début de la Compétition \n");
		
		((Competition)observable).state("BeinSport ");
		((Competition)observable).play();
		System.out.println();
		System.out.println("ci-dessus le classement finale de la competition");
		 
	}

	@Override
	public void react_to_match() {
		// TODO Auto-generated method stub
		
	}
}
