package partition;
import competitor.* ;
import java.util.* ;

public interface Partition {
	/**
	 * this methods partition the list of competitors sublist of  competitors 
	 * @param competitors all competitors
	 * @return number of group stage
	 */
	public List<List<Competitor>> doPartition ( List<Competitor> competitors) ;
}
