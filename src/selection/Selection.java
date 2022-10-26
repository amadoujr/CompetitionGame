package selection;

import competitor.Competitor;
import java.util.*;
import competition.*;

public interface Selection {
	
	/**
	 * this methods return competitors who's reach the final stage
	 * @param qualified 
	 * @return
	 */
	public List<Competitor> getFinalist(List<League> qualified);
	
}