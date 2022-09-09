package scenes;

import java.awt.Graphics;

import game.Game;
import game.GameThread;

public class PentrisScene extends Game {
	
	public PentrisScene() {
		
	}
	
	@Override
	protected void startGameLoop() {
		new GameThread(this, gameStateManager, spawner);
	}
}
