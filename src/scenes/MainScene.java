package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;

import observer_pattern.SubwerkzeugObserver;

public class MainScene extends AbstractScene {
	
	public MainScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "PENTRIS");
		setupComponent(new JButton(), 0, 1, 1, 1, () -> {informiereUeberAenderung();}, "Pentris");
		setupComponent(new JButton(), 2, 1, 1, 1, "Tetris");
		setupComponent(new JButton(), 0, 2, 1, 1, "Options");
		setupComponent(new JButton(), 2, 2, 1, 1, "Highscore");
		setupComponent(new JButton(), 1, 3, 1, 1, "Quit");
		this.setVisible(true);
	}
	
}
