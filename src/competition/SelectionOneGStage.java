package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;

public class SelectionOneGStage implements Selection {


	@Override
	public void selectionType(List<Competitor> competitors) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * this methods partition the list of competitors into  4 sublist of 4 competitors 
	 * @param competitors all competitors
	 * @return number of group stage
	 */
	public List<List<Competitor>> doPartition(List <Competitor> competitors){
		List<List<Competitor>> gstage = new ArrayList<List<Competitor>>();
		// To do...
		int nb = 4;                       // correspond to the size of each partitioning
		int size = competitors.size();
		
		for (int i = 0; i < size ; i += nb ){
			gstage.add(competitors.subList(i, Math.min(size, i + nb)));	
		}
		return gstage;
	}
}
