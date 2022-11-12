package main;

import java.util.*;


import competition.Competition;
import competition.League;
import competition.Tournament;
import competitor.Competitor;
import match.Match;
import match.RandomVictoryMatch;
import partition.PartitionXByStage;
import selection.SelectionFive;
import selection.SelectionFour;
import selection.SelectionOne;
import selection.SelectionThree;
import selection.SelectionTwo;
import competition.*;

public class MainCompet {

	public static void main(String[] args) {
		
		
		/**
		 * allow user to enter numbers of competitors 
		 */ 
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Please choose number of competitors : ");

		int res = scan.nextInt();
		
		List<Competitor> competitors = new ArrayList<>();
		int i = 0;
		for (i = 0 ; i< res ; i++) {
			competitors.add(new Competitor("competitor "+i));    // Adding competitors to the competition
		}
		Match match = new RandomVictoryMatch();
		Competition compet ;
		@SuppressWarnings("resource")
		Scanner scan1 = new Scanner(System.in);

		System.out.println("Please choose on of those competition : 1.leagues - 2.tournois - 3.master - 4.quit the game\n");
		System.out.println("About the master, we advice you to choose a number of competitor and partition methode that make the tournament avalaible");
		System.out.println("For example, having 12 competitors and partitionning it in 3 pools to just select 2 best player of each pool will not work");
		System.out.println("Try to find on own way why...");
		int answer = scan1.nextInt();
		
		switch(answer) {
			case 1 :  
				compet = new League(competitors , match);
				compet.play();
				break;
				
			case 2 :
				compet = new Tournament(competitors , match);
				compet.play();
				break;
				
			case 3 :
				Scanner scan3 = new Scanner(System.in);
				System.out.println("choose number of competitors in each pools");
				int nbpools = scan3.nextInt();
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Please choose one of those selections : 1(the best 2 of each league)  - 2(the last 2 of each league) - 3(the best of each league with repeche) - 4(the first and the last of each group) - 5(the first four of each group)");
				int answer2 = scan2.nextInt();
				
				
				switch(answer2) {
				case 1 :
					compet = new Master(competitors,match,new SelectionOne(),new PartitionXByStage(nbpools));
					compet.play();
					break;
				case 2 :
					compet = new Master(competitors,match,new SelectionTwo(),new PartitionXByStage(nbpools));
					compet.play();
					break;
				case 3 :
					compet = new Master(competitors,match,new SelectionThree(),new PartitionXByStage(nbpools));
					compet.play();
					break;
				case 4 :
					compet = new Master(competitors,match,new SelectionFour(),new PartitionXByStage(nbpools));
					compet.play();
					break;
				case 5 :
					compet = new Master(competitors,match,new SelectionFive(),new PartitionXByStage(nbpools));
					compet.play();
					break;
				}
			case 4:
				System.exit(0);
			default:
		           System.out.println("bad choose. Try it again");
		           break;
		}
		
		
	}

}
