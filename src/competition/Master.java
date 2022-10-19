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
	
	
	public List<List<Competitor>> setpools(int nb_pool_voulue){
		int compteur =0;
		int nb_pool_player = this.competitors.size()/nb_pool_voulue ;
		List<List<Competitor>> pools_list = new ArrayList<>();
		while(pools_list.size()!= nb_pool_voulue) 
		{ 
			List<Competitor> elem = new ArrayList<Competitor>();
			for(int i = 0 + compteur;i<nb_pool_player+compteur;i++)
			{
				
				elem.add(this.competitors.get(i));
				
			}
			pools_list.add(elem);
			this.compteur +=nb_pool_voulue;
		}
		
		return pools_list;
	}
	public void launchpools(List<List<Competitor>> pools) {
		for(List<Competitor> c :pools) {
			 this.leagues.add(new League(c,this.m1));
		}
	}
	
	/* applique les regles de selections au pool */
	public void selection_rules() {}

}
