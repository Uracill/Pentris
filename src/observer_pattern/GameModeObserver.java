package observer_pattern;

public interface GameModeObserver extends ObserverInterface{
	
    /**
     * Reagiert auf eine Änderung in dem beobachteten Subwerkzeug.
     * @param newState 
     */
    void reagiereAufAenderung(boolean newState);
}