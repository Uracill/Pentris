package scenes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import observer_pattern.GameOverObserver;
import observer_pattern.ObserverInterface;
import states.MenuState;

public class GameOverScene extends AbstractScene {

	private String playerName;
	private int score;
	private String gameMode;
	
	public GameOverScene() {
		super();
		setupComponents();
	}

	private void setupComponents() {
		setupComponent(new JLabel(), 1, 0, 1, 1, null, "Game Over", 40);
		setupComponent(new JLabel(), 0, 1, 1, 1, null, String.valueOf(score), 20);
		setupComponent(new JLabel(), 2, 1, 1, 1, null, gameMode, 20);
		setupComponent(new JLabel(), 1, 2, 1, 1, null, "Please enter your Name", 20);
		setupComponent(new JTextField(), 1, 3, 1, 1, null, "Your Name", 20);
		setupComponent(new JButton(), 0, 4, 1, 1, () -> {
			informiereUeberAenderung(MenuState.Leaderboard);
			informiereUeberAenderung(
					((JTextField)getComponentList().get(4)).getText(), score, gameMode);},
				"OK", 0);
		setupComponent(new JButton(), 2, 4, 1, 1, () -> 
		{informiereUeberAenderung(MenuState.Main);}, "Cancel", 0);
	}
	
	private void informiereUeberAenderung(String playerName, int score, String gameMode) {
		for(ObserverInterface beobachter: getBeobachter()) {
			if(beobachter instanceof GameOverObserver) {
				((GameOverObserver) beobachter).reagiereAufAenderung(
						score, playerName, gameMode);
			}
		}
	}
	
public void setupObserverPattern(PentrisScene pentris, TetrisScene tetris) {
		pentris.registriereBeobachter(new GameOverObserver() {
			
			@Override
			public void reagiereAufAenderung(int score, String playerName,
					String gameMode) {
				if(gameMode.equals("Pentris")) {
					saveSettings(score, gameMode);
				}
			}
		});
		
		tetris.registriereBeobachter(new GameOverObserver() {
					
			@Override
			public void reagiereAufAenderung(int score, String playerName,
					String gameMode) {
				if(gameMode.equals("Tetris")) {
					saveSettings(score, gameMode);
				}
			}
		});
	}
	
	private void saveSettings(int score, String gameMode) {
		this.score = score;
		this.gameMode = gameMode;
		((JLabel)getComponentList().get(1)).setText(String.valueOf(this.score));
		((JLabel)getComponentList().get(2)).setText(this.gameMode);
		((JTextField)getComponentList().get(4)).setText("");
	}
}
