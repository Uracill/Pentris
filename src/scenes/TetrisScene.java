package scenes;

import game.Game;
import game.GameThread;

public class TetrisScene extends Game {
	
	public TetrisScene() {
		
	}
	
	@Override
	protected void startGameLoop() {
		new GameThread(this, gameStateManager);
	}
}
