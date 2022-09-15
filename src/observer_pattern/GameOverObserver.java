package observer_pattern;

public interface GameOverObserver extends ObserverInterface{
	
    /**
     * Reagiert auf eine Änderung in dem beobachteten Subwerkzeug.
     * @param newState 
     */
    void reagiereAufAenderung(int score, String playerName, String gameMode);
}