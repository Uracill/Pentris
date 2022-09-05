package observer_pattern;

import java.util.HashSet;
import java.util.Set;

import states.MenuState;

public abstract class ObservableSubwerkzeug {
	
    private Set<SubwerkzeugObserver> alleBeobachter;

    /**
     * Initialisiert ein beobachtbares Subwerkzeug.
     */
    public ObservableSubwerkzeug() {
        alleBeobachter = new HashSet<SubwerkzeugObserver>();
    }

    /**
     * Registriert einen Beobachter an diesem Subwerkzeug. Der Beobachter wird
     * informiert, wenn sich bei diesem Werkzeug etwas ändert.
     * 
     * @require beobachter != null
     */
    public void registriereBeobachter(SubwerkzeugObserver beobachter) {
        assert beobachter != null : "Vorbedingung verletzt: beobachter != null";
        alleBeobachter.add(beobachter);
    }

    /**
     * Entfernt einen Beobachter dieses Subwerkzeugs. Wenn der Beobachter gar
     * nicht registriert war, passiert nichts.
     */
    public void entferneBeobachter(SubwerkzeugObserver beobachter) {
        alleBeobachter.remove(beobachter);
    }
    
    /**
     * Informiert alle an diesem Subwerkzeug registrierten Beobachter über eine
     * Änderung.
     * 
     * Diese Methode muss von der erbenden Klasse immer dann aufgerufen werden,
     * wenn eine Änderung geschehen ist, die für Beobachter interessant ist.
     */
    protected void informiereUeberAenderung(MenuState newState) {
        for (SubwerkzeugObserver beobachter : alleBeobachter) {
            beobachter.reagiereAufAenderung(newState);
        }
    }
}
