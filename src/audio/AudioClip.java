package audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioClip {
	
	private final Clip clip;
	
	public AudioClip(Clip clip) {
		this.clip = clip;
	}
	
	public void start() {
		clip.start();
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void setVolume(int volume) {
		final FloatControl control = (FloatControl) 
				clip.getControl(FloatControl.Type.MASTER_GAIN);
		float range = control.getMaximum() - control.getMinimum();
		float finalVolume = (float) (range * 0.1 + control.getMinimum());
		control.setValue(finalVolume);
	}
	
	public boolean hasFinished() {
		return !clip.isRunning();
	}
}
