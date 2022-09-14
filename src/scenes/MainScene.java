package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;

import observer_pattern.GameModeObserver;
import observer_pattern.ObserverInterface;
import observer_pattern.SubwerkzeugObserver;
import states.MenuState;

public class MainScene extends AbstractScene {
	
	public MainScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "PENTRIS", 40);
		setupComponent(new JButton(), 0, 1, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Pentris);
			informiereUeberAenderung(true);}, "Pentris", 0);
		setupComponent(new JButton(), 2, 1, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Tetris);
			informiereUeberAenderung(true);}, "Tetris", 0);
		setupComponent(new JButton(), 0, 2, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Leaderboard);}, "Leaderboard", 0);
		setupComponent(new JButton(), 2, 2, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Options);}, "Options", 0);
		setupComponent(new JButton(), 1, 3, 1, 1, () -> {System.exit(0);}, "Quit", 0);
		this.setVisible(true);
	}
}
