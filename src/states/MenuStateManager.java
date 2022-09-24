package states;

public class MenuStateManager {

	private MenuState currentState;
	private MenuState previousState;
	private MenuState tempState;
	
	public MenuStateManager() {
		currentState = MenuState.Main;
		previousState = MenuState.Null;
		tempState = MenuState.Null;
	}
	
	public void update(MenuState newState) {
		switch(newState) {
			case Null -> {
				previousState = MenuState.Null;
				currentState = MenuState.Null;
				tempState = MenuState.Null;
			}
			case Previous -> {
				MenuState tempState = previousState;
				previousState = currentState;
				currentState = tempState;
				if(tempState == MenuState.Main || tempState == MenuState.Pentris
						|| tempState == MenuState.Tetris ||tempState == MenuState.Leaderboard) {
					previousState = MenuState.Null;
				}
				if(this.tempState != MenuState.Null) {	//kann nur im passieren, wenn man während ein Spiel läuft die Einstellungen verlässt
					previousState = this.tempState;
					this.tempState = MenuState.Null;
				}
			}
			case Main, Pentris, Tetris, Leaderboard -> {
				previousState = MenuState.Null;
				currentState = newState;
			}
			case Options, Pause, GameOver -> {
				if(currentState != newState && currentState != MenuState.OC
						&& currentState != MenuState.PL) {
					if(previousState == MenuState.Pentris || previousState == MenuState.Tetris) {	//passiert, wenn man bei dem
						tempState = previousState;													//PauseMenu in die Einstellungen geht,
					}																				//damit man noch weiß, ob Pentris oder Tetris gespielt wird
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
	
	public MenuState getTempState() {
		return tempState;
	}

}
