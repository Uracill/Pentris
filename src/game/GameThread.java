package game;

import java.util.List;

import scenes.TetrisScene;
import states.GameState;
import states.GameStateManager;
import states.MenuState;

public class GameThread extends Thread{

	private Game scene;
	private GameStateManager gameStateManager;
	private BlockSpawner spawner;

	public GameThread(Game game, GameStateManager gameStateManager,
			BlockSpawner spawner) {
		this.scene = game;
		this.gameStateManager = gameStateManager;
		this.spawner = spawner;
		this.start();
	}
	
	@Override
	public void run() {
		
		while(gameStateManager.getState() == GameState.Running) {
			
			try {
				scene.spawnBlock();
				if(!scene.isLanding()) {
					gameStateManager.update(GameState.Paused);
					scene.informiereUeberAenderung(MenuState.GameOver);
					this.join(10000);
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
	
}
