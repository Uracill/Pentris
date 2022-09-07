package states;

import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;

public class GameStateManagerTest {
	
	private GameStateManager gameStateManager;
	private GameState nullState;
	private GameState runningState;
	private GameState pausedState;
	private GameState menuState;
	
	public GameStateManagerTest() {
		gameStateManager = new GameStateManager();
		nullState = GameState.Null;
		runningState = GameState.Running;
		pausedState = GameState.Paused;
		menuState = GameState.Menu;
	}
	
	@Test
	public void test_Constructor() {
		assertSame(runningState, gameStateManager.getState());
	}
	
	@Test
	public void test_update() {
		gameStateManager.update(GameState.Null);
		assertSame(nullState, gameStateManager.getState());
		gameStateManager.update(GameState.Running);
		assertSame(runningState, gameStateManager.getState());
		gameStateManager.update(GameState.Paused);
		assertSame(pausedState, gameStateManager.getState());
		gameStateManager.update(GameState.Menu);
		assertSame(menuState, gameStateManager.getState());
	}
}
