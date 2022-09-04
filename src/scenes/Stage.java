package scenes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listeners.CustomWindowListener;
import observer_pattern.SubwerkzeugObserver;
import states.MenuState;
import states.MenuStateManager;

public class Stage extends JFrame {
	
	private List<AbstractScene> sceneList;
	private JPanel currentScene;
	
	private MenuStateManager menuStateManager;
	
	private CustomWindowListener windowListener;
	
	private int width;
	private int height;
	
	public Stage() {
		setupStage();
		setupScenes();
		setupObserverPattern();
		setupStart();
	}

	private void setupStage() {
		width = 600;
		height = 400;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
        this.setBounds(0, 0, width, height);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        windowListener = new CustomWindowListener();
        this.addWindowListener(windowListener);
	}
	
	private void setupScenes() {
		sceneList = new ArrayList<AbstractScene>();
		menuStateManager = new MenuStateManager();
		sceneList.add(new MainScene());
	}
	
	private void setupObserverPattern() {
		windowListener.registriereBeobachter(new SubwerkzeugObserver() {
			
			@Override
			public void reagiereAufAenderung() {
				if(menuStateManager.getCurrentState() == MenuState.Pentris
		                || menuStateManager.getCurrentState() == MenuState.Tetris
		                && menuStateManager.getCurrentState() != MenuState.Pause) {
					updateScene(MenuState.Pause);
				}
			}
		});
	}
	
	private void setupStart() {
		updateScene(MenuState.Main);
		this.setContentPane(currentScene);
		this.setVisible(true);
	}
	
	private void updateScene(MenuState newState) {
		menuStateManager.update(newState);
		
		switch(menuStateManager.getCurrentState()) {
			case Null -> {
				System.exit(1); 					//Nicht normal
			}
			case Main -> {
				currentScene = sceneList.get(0);
				break;
			}
			case Pentris -> {
				currentScene = sceneList.get(1);
				break;
			}
			case Tetris -> {
				currentScene = sceneList.get(2);
				break;
			}
			case Options -> {
				currentScene = sceneList.get(3);
				break;
			}
			case Highscore -> {
				currentScene = sceneList.get(4);
				break;
			}
			case Pause -> {
				currentScene = sceneList.get(5);
				break;
			}
			case OC -> {
				currentScene = sceneList.get(6);
				break;
			}
			case PL -> {
				currentScene = sceneList.get(7);
				break;
			}
		}
	}
	
	public MenuStateManager getMenuStateManager() {
		return menuStateManager;
	}

	public List<AbstractScene> getSceneList() {
		return sceneList;
	}
}
