package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import observer_pattern.ObservableSubwerkzeug;
import states.MenuState;

public class CustomWindowListener extends ObservableSubwerkzeug implements WindowListener {

	public CustomWindowListener() {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		informiereUeberAenderung(MenuState.Pause);
	}
}
