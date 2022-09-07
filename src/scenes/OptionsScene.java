package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;

import states.MenuState;

public class OptionsScene extends AbstractScene {
	
	public OptionsScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "Options");
		setupComponent(new JLabel(), 0, 1, 1, 1, null, "Music");
		setupComponent(new JSlider(), 1, 1, 2, 1, null);
		setupComponent(new JLabel(), 0, 2, 1, 1, null, "Sound");
		setupComponent(new JSlider(), 1, 2, 2, 1, null);
		setupComponent(new JButton(), 0, 3, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Main);}, "Apply");
		setupComponent(new JButton(), 2, 3, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.OC);}, "Cancel");
	}

}
