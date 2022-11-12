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
import selection.Selection;
import selection.SelectionThree;

class MasterTest extends CompetitionTest {

	

	@Override
	protected Competition createCompet() {
		// TODO Auto-generated method stub
		List<Competitor> c = new ArrayList<Competitor>();
		Competitor c1 = new Competitor("jean");
		Competitor c2 = new Competitor("pierre");
		Competitor c3 = new Competitor("jonas");
		Competitor c4 = new Competitor("jacob");


		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		Match match = new MockMatch();
		
		Selection selection = new SelectionThree();
		Partition partition = new PartitionXByStage(2);
		
		
		return new Master(c,match,selection,partition);
	}
	
	@Test
	public void PlayTest() {
		List<Competitor> c = new ArrayList<Competitor>();
		Competitor c1 = new Competitor("jean");
		Competitor c2 = new Competitor("pierre");
		Competitor c3 = new Competitor("jonas");
		Competitor c4 = new Competitor("jacob");


		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		Match match = new MockMatch();
		
		Selection selection = new SelectionThree();
		Partition partition = new PartitionXByStage(2);
		Master m = new Master(c,match,selection,partition);
		m.play();
		assertTrue(m.getScore().get(c1)== 1);
	}
}
