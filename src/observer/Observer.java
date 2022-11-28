package observer;

import competitor.Competitor;

public interface Observer {

	public void update(CompetitionObservable observale);

	public void react_to_match(Competitor c1,Competitor c2);

}
