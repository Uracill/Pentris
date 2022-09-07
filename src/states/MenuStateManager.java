package states;

public class MenuStateManager {

	private MenuState currentState;
	private MenuState previousState;
	
	public MenuStateManager() {
		currentState = MenuState.Main;
		previousState = MenuState.Null;
	}
	
	public void update(MenuState newState) {
		switch(newState) {
			case Null -> {
				previousState = MenuState.Null;
				currentState = MenuState.Null;
			}
			case Main, Pentris, Tetris, Highscore -> {
				previousState = MenuState.Null;
				currentState = newState;
			}
			case Options, Pause, GameOver -> {
				if(currentState != newState) {
					previousState = currentState;
					currentState = newState;
				}
			}
		}
	}
	
	public MenuState getCurrentState() {
		return currentState;
	}
	
	public MenuState getPreviousState() {
		return previousState;
	}

}
