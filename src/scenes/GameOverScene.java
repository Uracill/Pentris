package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;

import states.MenuState;

public class GameOverScene extends AbstractScene {

	public GameOverScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "Game Over", 40);
		setupComponent(new JLabel(), 1, 1, 1, 1, null, "Wanna play again?", 20);
		setupComponent(new JButton(), 0, 2, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Previous);}, "Apply", 0);
		setupComponent(new JButton(), 2, 2, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Main);}, "Cancel", 0);
	}
}
