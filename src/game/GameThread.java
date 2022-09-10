package game;

import java.util.List;

import javax.swing.JOptionPane;

import scenes.TetrisScene;
import states.GameState;
import states.GameStateManager;
import states.MenuState;

public class GameThread extends Thread{

	private Game scene;
	private GameStateManager gameStateManager;

	public GameThread(Game game) {
		this.scene = game;
		this.gameStateManager = new GameStateManager();
		this.start();
	}
	
	@Override
	public void run() {
		
		while(gameStateManager.getState() == GameState.Running) {
			
			try {
				scene.spawnBlock();
				if(!scene.isLanding()) {
					stopGameThread();
				}
				Thread.sleep(scene.getVelocity());
				while(scene.isLanding()) {
				scene.moveDown();
				Thread.sleep(scene.getVelocity());
				}
				List<Integer> rows = scene.fullRows();
				if(rows.size() > 0) {
					scene.clearRows(rows);
					scene.update(rows.size());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopGameThread() {
		gameStateManager.update(GameState.Paused);
		JOptionPane.showInputDialog("Game Over! \n Please enter your name.");
		scene.informiereUeberAenderung(MenuState.GameOver);
		try {
			this.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
