package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;

import audio.AudioOptions;
import observer_pattern.SubwerkzeugObserver;
import states.MenuState;

public class OptionsScene extends AbstractScene{
	
	private AudioOptions audioOptions;
	
	public OptionsScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		audioOptions = new AudioOptions();
		
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "Options", 40);
		setupComponent(new JLabel(), 0, 1, 1, 1, null, "Music", 20);
		setupComponent(new JSlider(), 1, 1, 2, 1, 
				() -> {audioOptions.setMusicValue(
					((JSlider) getComponentList().get(2)).getValue());}, 0);
		setupComponent(new JLabel(), 0, 2, 1, 1, null, "Sound", 20);
		setupComponent(new JSlider(), 1, 2, 2, 1, 
				() -> {audioOptions.setSoundValue(
						((JSlider) getComponentList().get(4)).getValue());}, 0);
		setupComponent(new JButton(), 0, 3, 1, 1, () -> {
			updateAudioOptions(true);
			informiereUeberAenderung(MenuState.Previous);
		}, "Apply", 0);
		setupComponent(new JButton(), 2, 3, 1, 1, () -> {
			if(audioOptions.hasChanged()) {
				informiereUeberAenderung(MenuState.OC);
			}
			else {
				informiereUeberAenderung(MenuState.Previous);
			}
		}, "Cancel", 0);
	}

	public void setupObserverPattern(OCScene oc) {
		oc.registriereBeobachter(new SubwerkzeugObserver() {
			
			@Override
			public void reagiereAufAenderung(MenuState newState) {
				if(newState == MenuState.Previous) {
					updateAudioOptions(false);
				}
			}
		});	
	}
	
	private void updateAudioOptions(boolean apply) {
		if(apply) {
			audioOptions.apply();
		}
		else {
			audioOptions.cancel();
		}
		((JSlider)getComponentList().get(2)).setValue((int) audioOptions.getMusicValue());
		((JSlider)getComponentList().get(4)).setValue((int) audioOptions.getSoundValue());
	}
}
