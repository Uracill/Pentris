package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;

import observer_pattern.ObserverInterface;
import observer_pattern.GameModeObserver;
import observer_pattern.SubwerkzeugObserver;
import states.MenuState;

public class PauseScene extends AbstractScene {
	
	public PauseScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "Pause", 40);	//TODO:Implement
		setupComponent(new JButton(), 0, 1, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Previous);
			informiereUeberAenderung(false);}, "Resume", 0);
		setupComponent(new JButton(), 2, 1, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Previous);
			informiereUeberAenderung(true);}, "Restart", 0);
		setupComponent(new JButton(), 0, 2, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Options);}, "Options", 0);
		setupComponent(new JButton(), 2, 2, 1, 1, () -> {
			informiereUeberAenderung(MenuState.PL);}, "Leave", 0);
	}
}
