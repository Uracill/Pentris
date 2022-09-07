package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;

import observer_pattern.SubwerkzeugObserver;
import states.MenuState;

public class MainScene extends AbstractScene {
	
	public MainScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "PENTRIS");
		setupComponent(new JButton(), 0, 1, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Pentris);}, "Pentris");
		setupComponent(new JButton(), 2, 1, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Tetris);}, "Tetris");
		setupComponent(new JButton(), 0, 2, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Highscore);}, "Highscore");
		setupComponent(new JButton(), 2, 2, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Options);}, "Options");
		setupComponent(new JButton(), 1, 3, 1, 1, () -> {System.exit(0);}, "Quit");
		this.setVisible(true);
	}
	
}
