package competition;
import competitor.Competitor;
import java.util.*;

public interface Selection {
	
	/**
	 * this methods return competitors who's reach the final stage
	 * @param qualified 
	 * @return
	 */
	public List<Competitor> getFinalist(List<League> qualified);
	
}
