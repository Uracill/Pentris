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
			case Previous -> {
				MenuState tempState = previousState;
				previousState = currentState;
				currentState = tempState;
				if(tempState == MenuState.Main || tempState == MenuState.Main
						&& tempState == MenuState.Main ||tempState == MenuState.Main) {
					previousState = MenuState.Null;
				}
			}
			case Main, Pentris, Tetris, Leaderboard -> {
				previousState = MenuState.Null;
				currentState = newState;
			}
			case Options, Pause, GameOver -> {
				if(currentState != newState && currentState != MenuState.OC
						&& currentState != MenuState.PL) {
					previousState = currentState;
					currentState = newState;
				}
				else {
					currentState = newState;
				}
			}
			case OC, PL -> {
				currentState = newState;
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
