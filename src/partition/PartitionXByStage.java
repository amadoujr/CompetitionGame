package partition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;

public class PartitionXByStage implements Partition {
	
	private int nb_competitor;
	 
	public PartitionXByStage (int x) {
		this.nb_competitor = x ;
	}
	/**
	 * this methods partition the list of competitors into  sublists of x competitors 
	 * @param competitors all competitors
	 * @return number of group stage
	 */
	public List<List<Competitor>> doPartition(List <Competitor> competitors ){
		List<List<Competitor>> gstage = new ArrayList<List<Competitor>>();
		// To do...                     
		int size = competitors.size();
		for (int i = 0; i < size ; i += this.nb_competitor ){
			gstage.add(competitors.subList(i, Math.min(size, i + this.nb_competitor )));	
		}
		return gstage;
	}

}
