package game;

import java.util.List;

import scenes.TetrisScene;
import states.GameState;
import states.GameStateManager;
import states.MenuState;

public class GameThread extends Thread{

	private TetrisScene scene;
	private GameStateManager gameStateManager;
	private BlockSpawner spawner;

	public GameThread(TetrisScene scene, GameStateManager gameStateManager) {
		this.scene = scene;
		this.gameStateManager = gameStateManager;
		this.spawner = new BlockSpawner(scene);
		this.start();
	}
	
	@Override
	public void run() {
		
		while(gameStateManager.getState() == GameState.Running) {
			
			try {
				spawner.spawnBlock();
				Thread.sleep(scene.getVelocity());
				if(!scene.isLanding()) {
					gameStateManager.update(GameState.Paused);
					scene.informiereUeberAenderung(MenuState.GameOver);
				}
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
	
}
