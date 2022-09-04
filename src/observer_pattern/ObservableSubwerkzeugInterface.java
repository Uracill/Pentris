package observer_pattern;

public interface ObservableSubwerkzeugInterface {

	public void registriereBeobachter(SubwerkzeugObserver beobachter);
	
	public void entferneBeobachter(SubwerkzeugObserver beobachter);
	
	void informiereUeberAenderung();
}
