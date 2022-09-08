package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;

import states.MenuState;

public class OCScene extends AbstractScene {
	
	public OCScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "Options", 40);
		setupComponent(new JLabel(), 1, 1, 1, 1, null, "Do you want to", 15);
		setupComponent(new JLabel(), 1, 2, 1, 1, null, "discard your changes?", 15);
		setupComponent(new JButton(), 0, 3, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Previous);}, "Yes", 0);
		setupComponent(new JButton(), 2, 3, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Options);}, "No", 0);
	}

}
