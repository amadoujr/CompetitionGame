package main;

import java.util.*;

import competition.Competition;
import competition.League;
import competition.Tournament;
import competitor.Competitor;
import match.Match;
import match.RandomVictoryMatch;

public class MainCompet {

	public static void main(String[] args) {
		/**
		 * allow user to enter numbers of competitors 
		 */
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de compétiteurs : ");
		int res = scan.nextInt();
		
		List<Competitor> competitors = new ArrayList<>();
		int i = 0;
		for (i = 0 ; i< res ; i++) {
			competitors.add(new Competitor("competitor "+i));
		}
		Match match = new RandomVictoryMatch();
		Competition compet ;
		@SuppressWarnings("resource")
		Scanner scan1 = new Scanner(System.in);

		System.out.println("Veuillez saisir le type de competition : leagues - tournois");
		String answer = scan1.nextLine();
		
		if (answer.equalsIgnoreCase("leagues")) {
			compet = new League(competitors , match);
		} 
		else {
			compet = new Tournament(competitors , match);
		}
		
		compet.play();
	}

}
