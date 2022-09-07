package states;

public class GameStateManager {

	private GameState state;
	
	public GameStateManager() {
		state = GameState.Running;
	}
	
	public void update(GameState newState) {
		state = newState;
	}
	
	public GameState getState() {
		return state;
	}
}
