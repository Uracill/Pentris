package scenes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import listeners.CustomWindowListener;
import observer_pattern.GameModeObserver;
import observer_pattern.SubwerkzeugObserver;
import states.MenuState;
import states.MenuStateManager;

public class Stage extends JFrame {
	
	private List<AbstractScene> sceneList;
	private AbstractScene currentScene;
	
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
		height = 450;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
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
		sceneList.add(new PentrisScene());
		sceneList.add(new TetrisScene());
		sceneList.add(new LeaderboardScene());
		sceneList.add(new OptionsScene());
		sceneList.add(new PauseScene());
		sceneList.add(new OCScene());
		sceneList.add(new PLScene());
		sceneList.add(new GameOverScene());
	}
	
	private void setupObserverPattern() {
		windowListener.registriereBeobachter(new SubwerkzeugObserver() {

			@Override
			public void reagiereAufAenderung(MenuState newState) {
				if(menuStateManager.getCurrentState() == MenuState.Pentris
		                || menuStateManager.getCurrentState() == MenuState.Tetris
		                && menuStateManager.getCurrentState() != MenuState.Pause) {
					updateScene(MenuState.Pause);
				}
			}
		});
		
		for (AbstractScene abstractScene : sceneList) {
			abstractScene.registriereBeobachter(new SubwerkzeugObserver() {
				
				@Override
				public void reagiereAufAenderung(MenuState newState) {
					updateScene(newState);
				}
			});
		}
		((MainScene)sceneList.get(0)).registriereBeobachter(new GameModeObserver() {
			
			@Override
			public void reagiereAufAenderung(boolean newState) {	//newState macht nichts
				switch(menuStateManager.getCurrentState()) {
					case Pentris -> {
						((PentrisScene)currentScene).startGame();
						break;
					}
					case Tetris -> {
						((TetrisScene)currentScene).startGame();
						break;
					}
				}
			}
		});
		((LeaderboardScene) sceneList.get(3)).setupObserverPattern(
				((GameOverScene) sceneList.get(8)));
		((OptionsScene) sceneList.get(4)).setupObserverPattern(
				((OCScene) sceneList.get(6)));
		((PauseScene)sceneList.get(5)).registriereBeobachter(new GameModeObserver() {
					
				@Override
				public void reagiereAufAenderung(boolean newState) {	
					switch(menuStateManager.getCurrentState()) {
						case Pentris -> {
							if(newState) {
								((PentrisScene)currentScene).startGame();
							}
							else {
								((PentrisScene)currentScene).startGameLoop();
							}
							break;
						}
						case Tetris -> {
							if(newState) {
								((TetrisScene)currentScene).startGame();
							}
							else {
								((TetrisScene)currentScene).startGameLoop();
							}
							break;
						}
					}
				}
		});
		((GameOverScene)sceneList.get(8)).setupObserverPattern(
				((PentrisScene)sceneList.get(1)), ((TetrisScene)sceneList.get(2)));
	}
	
	private void setupStart() {
		updateScene(MenuState.Main);
		this.setVisible(true);
	}
	
	private void updateScene(MenuState newState) {
		menuStateManager.update(newState);
		if(currentScene != null) {
			this.remove(currentScene);
		}
		
		switch(menuStateManager.getCurrentState()) {
			case Null, Previous -> {
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
			case Leaderboard -> {
				currentScene = sceneList.get(3);
				break;
			}
			case Options -> {
				currentScene = sceneList.get(4);
				break;
			}
			case Pause -> {
				if(currentScene instanceof PentrisScene) {
					((PentrisScene)currentScene).pauseGame();
				}
				else if(currentScene instanceof TetrisScene){
					((TetrisScene)currentScene).pauseGame();
				}
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
			case GameOver -> {
				currentScene = sceneList.get(8);
				break;
			}
		}
		this.add(currentScene);
		currentScene.repaint();
		this.setVisible(true);
	}
	
	public MenuStateManager getMenuStateManager() {
		return menuStateManager;
	}

	public List<AbstractScene> getSceneList() {
		return sceneList;
	}
}
