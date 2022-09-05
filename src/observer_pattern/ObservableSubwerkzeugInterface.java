package observer_pattern;

import states.MenuState;

public interface ObservableSubwerkzeugInterface {

	public void registriereBeobachter(SubwerkzeugObserver beobachter);
	
	public void entferneBeobachter(SubwerkzeugObserver beobachter);

	void informiereUeberAenderung(MenuState newState);
}
