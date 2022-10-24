package competition;
import competitor.Competitor;
import java.util.*;

public interface Selection {
	
	
	public void selectionType( List<Competitor> competitors);
	
	public List<List<Competitor>> doPartition(List<Competitor> competitors);
	
	public List<Competitor> getFinalist(List<List<Competitor>> qualified);
	
}
