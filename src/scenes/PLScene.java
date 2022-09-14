package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;

import states.MenuState;

public class PLScene extends AbstractScene {

	public PLScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "Pause", 40);
		setupComponent(new JLabel(), 1, 1, 1, 1, null, "Do you want to", 15);
		setupComponent(new JLabel(), 1, 2, 1, 1, null, "leave the current game?", 15);
		setupComponent(new JButton(), 0, 3, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Main);}, "Yes", 0);
		setupComponent(new JButton(), 2, 3, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Pause);}, "No", 0);
	}
	
}
