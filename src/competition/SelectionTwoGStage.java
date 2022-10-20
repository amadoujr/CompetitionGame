package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;

public class SelectionTwoGStage implements Selection{


	@Override
	public void selectionType(List<Competitor> competitors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<List<Competitor>> doPartition(List<Competitor> competitors) {
		// TODO Auto-generated method stub
			List<List<Competitor>> gstage = new ArrayList<List<Competitor>>();
			// To do...
			int nb = 8;                       // correspond to the size of each partitioning
			int size = competitors.size();
			
			for (int i = 0; i < size ; i += nb ){
				gstage.add(competitors.subList(i, Math.min(size, i + nb)));	
			}
			return gstage;
		}

	@Override
	public List<Competitor> getFinalist(List<List<Competitor>> qualified) {
		// TODO Auto-generated method stub
		return null;
	}

}
