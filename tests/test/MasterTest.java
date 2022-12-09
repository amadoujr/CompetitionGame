package test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import competition.Competition;
import competition.Master;
import competitor.Competitor;
import match.Match;
import partition.Partition;
import partition.PartitionXByStage;

class MasterTest extends CompetitionTest {

	private  MockSelectionTwoBestCompet selection;

	@Override
	protected Competition createCompet() {
		List<Competitor> c = new ArrayList<Competitor>();
		int i = 0;
		for (i = 0 ; i < 8 ; i++) {
			c.add(new Competitor("competitor "+i,i));    // Adding competitors to the competition
		}
		Match match = new MockMatch();
		Partition partition = new PartitionXByStage(4);
		this.selection = new MockSelectionTwoBestCompet();
		return new Master(c,match,selection,partition);
	}
	
	@Test
	public void playAndSTrategySelectionTest() {
		
		assertTrue(selection.compteur == 0);
		this.compet.play();
		assertTrue(selection.compteur == 1);
		
	}
}
