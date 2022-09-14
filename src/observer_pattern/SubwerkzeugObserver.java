package observer_pattern;

import states.MenuState;

public interface SubwerkzeugObserver extends ObserverInterface {
	
    /**
     * Reagiert auf eine Änderung in dem beobachteten Subwerkzeug.
     * @param newState 
     */
    void reagiereAufAenderung(MenuState newState);
}