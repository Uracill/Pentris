package game;

import scenes.TetrisScene;
import states.GameState;
import states.GameStateManager;

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
				Thread.sleep(100);
				if(!scene.isLanding()) {
					gameStateManager.update(GameState.Menu);
				}
				while(scene.isLanding()) {
				scene.moveDown();
				Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
