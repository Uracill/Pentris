package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import game.Game;
import game.GameThread;
import game.pieces.Block;
import listeners.UserInput;
import states.GameState;
import states.GameStateManager;
import states.MenuState;
import states.MoveState;

public class TetrisScene extends Game {
	
	public TetrisScene() {
		
	}
	
	@Override
	protected void startGameLoop() {
		new GameThread(this, gameStateManager);
	}
}
