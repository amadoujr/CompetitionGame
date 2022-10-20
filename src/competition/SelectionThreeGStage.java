package competition;
import competitor.Competitor;
import java.util.*;

public class SelectionThreeGStage implements Selection {
	
	
	public SelectionThreeGStage() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	/**
	 * this methods partition the list of competitors into  8 sublist of 4 competitors 
	 * @param competitors all competitors
	 * @return number of group stage
	 */
	public void selectionType(List <Competitor> competitors){}

	@Override
	public List<List<Competitor>> doPartition(List<Competitor> competitors) {
			List<List<Competitor>> gstage = new ArrayList<List<Competitor>>();
			// To do...
			int nb = 4;                       // correspond to the size of each partitioning
			int size = competitors.size();
			
			for (int i = 0; i < size ; i += nb ){
				gstage.add(competitors.subList(i, Math.min(size, i + nb)));	
			}
			return gstage;
		
	}

	@Override
	public List<Competitor> getFinalist(List<List<Competitor>> qualified) {
		// TODO Auto-generated method stub
		List<Competitor> qualifiedcompetitor = new ArrayList<>();
		return null;
	}
	
	
	


}


