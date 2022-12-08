package observer;

import competitor.Competitor;

public class Canal implements Observer {


	public void reactToMatch(Competitor c1,Competitor c2) {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+" : "+ c1 +" won the match over " +c2);
	}

	@Override
	public String toString() {
		return "canal+ ";
	}

}
