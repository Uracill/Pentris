package scenes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import states.MenuState;
import states.MenuStateManager;

public class Stage extends JFrame {
	
	private List<AbstractScene> sceneList;
	private JPanel currentScene;
	private MenuStateManager menuStateManager;
	
	
	public Stage() {
		setupStage();
		setupScenes();
		sceneList = new ArrayList<AbstractScene>();
		menuStateManager = new MenuStateManager();
	}

	private void setupStage() {
	
	}
	
	private void setupScenes() {
		sceneList.add(new MainScene());
		this.setContentPane(currentScene);
		currentScene = sceneList.get(0);
	}
	
	private void updateScene(MenuState newState) {
		menuStateManager.update(newState);
		
		switch(menuStateManager.getCurrentState()) {
			case Null -> {
				System.exit(1); 					//Nicht normal
			}
			case Main -> {
				currentScene = sceneList.get(0);
			}
			case Pentris -> {
				currentScene = sceneList.get(1);
			}
			case Tetris -> {
				currentScene = sceneList.get(2);
			}
			case Options -> {
				currentScene = sceneList.get(3);
			}
			case Highscore -> {
				currentScene = sceneList.get(4);
			}
			case Pause -> {
				currentScene = sceneList.get(5);
			}
			case OC -> {
				currentScene = sceneList.get(6);
			}
			case PL -> {
				currentScene = sceneList.get(7);
			}
		}
	}
}
