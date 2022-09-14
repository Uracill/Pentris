package observer_pattern;

import states.MenuState;

public interface ObservableSubwerkzeugInterface {

	public void registriereBeobachter(ObserverInterface beobachter);
	
	public void entferneBeobachter(ObserverInterface beobachter);

	void informiereUeberAenderung(MenuState newState);
}
