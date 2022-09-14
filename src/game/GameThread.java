package game;

import java.util.List;

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
				if(scene.getSpawn()) {
					scene.spawnBlock();
				}
				if(!scene.isLanding()) {
					gameOver();
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
				if(!scene.getSpawn()) {
					scene.setSpawn(true);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void gameOver() {
		pauseThread();
		//JOptionPane.showInputDialog("Game Over! \n Please enter your name.");
		scene.informiereUeberAenderung(MenuState.GameOver);
		try {
			this.join(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void pauseThread() {
		gameStateManager.update(GameState.Paused);
	}
	
}
