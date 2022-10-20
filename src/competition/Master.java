package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;

public class Master extends Competition {
		
	
		private List<League> leagues ;
		private Selection selection;   // will allow us to use the type of selection methods we want 
		

	public Master(List<Competitor> competitors, Selection selection) {
		super(competitors);
		this.leagues= new ArrayList<League>();
		this.selection = selection;
	}

	@Override
	protected void play(List<Competitor> competitors) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * this methods partition the list of competitors sublist of  competitors 
	 * @param competitors all competitors
	 * @return number of group stage
	 */
	public List<List<Competitor>> setpools(int nb_pool_voulue){
		int compteur =0;
		int nb_pool_player = this.competitors.size()/nb_pool_voulue ;
		List<List<Competitor>> pools_list = new ArrayList<>();
		while(pools_list.size()!= nb_pool_voulue) 
		{ 
			List<Competitor> elem = new ArrayList<Competitor>();
			for( int i = 0 + compteur;i<nb_pool_player+compteur;i++)
			{
				
				elem.add(this.competitors.get(i));
				
			}
			pools_list.add(elem);
			compteur +=nb_pool_player;
		}
		
		return pools_list;
	}
	
	
	public void launchpools(List<List<Competitor>> pools) {
		for(List<Competitor> c :pools) {
			 this.leagues.add(new League(c,this.m1));
		}
	}
	
	

}
