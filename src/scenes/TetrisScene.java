package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import game.GameThread;
import game.pieces.TetrisBlock;
import listeners.UserInput;
import states.GameState;
import states.GameStateManager;
import states.MenuState;
import states.MoveState;

public class TetrisScene extends AbstractScene {

	private GameStateManager gameStateManager;
	
	private int level;
	
	private int gridCellSize;
	private int gridRows;
	private int gridColumns;
	private int[][] field;
	private TetrisBlock block;
	
	public TetrisScene() {
	gameStateManager = new GameStateManager();
		
	gridCellSize = 20;
	gridRows = 20;
	gridColumns = 10;
	field = new int[gridColumns][gridRows];
	
	level = 1;	//TODO: nach startGame
	}

	public void startGame() {
		gameStateManager = new GameStateManager();
		setupKeyStrokes();
		startGameLoop();
	}
	
	private void setupKeyStrokes() {
		addKeyBinding("Escape", () -> informiereUeberAenderung(MenuState.Pause));
		addKeyBinding("W", () -> moveUp());
		addKeyBinding("A", () -> moveLeft());
		addKeyBinding("S", () -> moveDown());
		addKeyBinding("D", () -> moveRight());
		addKeyBinding("Q", () -> rotateLeft());
		addKeyBinding("E", () -> rotateRight());
	}

	private void addKeyBinding(String key, UserInput input) {
		InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke("pressed " + key), key + "P");
		inputMap.put(KeyStroke.getKeyStroke("released " + key), key + "R");
		
		ActionMap actionMap = this.getActionMap();
		actionMap.put(key + "P", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input.execute();
			}
		});
		actionMap.put(key + "R", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	private void startGameLoop() {
		new GameThread(this, gameStateManager);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawGrid(g);
	}

	private void drawGrid(Graphics g) {
		for(int i = 0; i < gridColumns; i++) {
			for(int j = 0; j < gridRows; j++) {
				if(field[i][j] > 0) {
					switch(field[i][j]) {
					case 1: 
						g.setColor(new Color(0, 240, 240));
						break;
					case 2: 
						g.setColor(new Color(0, 0, 240));
						break;
					case 3: 
						g.setColor(new Color(240, 160, 0));
						break;
					case 4: 
						g.setColor(new Color(240, 240, 0));
						break;
					case 5: 
						g.setColor(new Color(0, 240, 0));
						break;
					case 6: 
						g.setColor(new Color(160, 0, 240));
						break;
					case 7: 
						g.setColor(new Color(240, 0, 0));
						break;
					}
					g.fillRect(i * gridCellSize + 200,
							j * gridCellSize + 10, gridCellSize, gridCellSize);
					g.setColor(new Color(0, 0, 0));
				}
				g.drawRect(i * gridCellSize + 200,
						j * gridCellSize + 10, gridCellSize, gridCellSize);
			}
		}
	}
	
	private void moveUp() {
		if(isFree(MoveState.Up)) {
			deleteBlock();
			block.instantDrop();
			paintBlock();
			repaint();	
		}
	}

	private void moveLeft() {
		if(isFree(MoveState.Left)) {
			deleteBlock();
			block.moveLeft();
			paintBlock();
			repaint();
		}
	}
	
	public void moveDown() {
		if(isFree(MoveState.Down)) {
			deleteBlock();
			block.moveDown();
			paintBlock();
			repaint();
		}
	}

	private void moveRight() {
		if(isFree(MoveState.Right)) {
			deleteBlock();
			block.moveRight();
			paintBlock();
			repaint();
		}
	}

	private void rotateLeft() {
		if(isFree(MoveState.RotateLeft)) {
			deleteBlock();
			block.rotateLeft();
			paintBlock();
			repaint();	
		}
	}

	private void rotateRight() {
		if(isFree(MoveState.RotateRight)) {
			deleteBlock();
			block.rotateRight();
			paintBlock();
			repaint();
		}
	}

	public boolean isLanding() {
		if(block.getY() + block.getHeight() == gridRows || !isFree(MoveState.Down)) {
			return false;
		}
		return true;
	}
	
	private boolean isFree(MoveState state) {
		int offsetx = 0;	//Rotation left and right
		int offsety = 0;
		
		if(state == MoveState.Left) {
			offsetx = -1;
			offsety = 0;
		}
		else if(state == MoveState.Right) {
			offsetx = 1;
			offsety = 0;
		}
		else if(state == MoveState.Down) {
			offsetx = 0;
			offsety = 1;
		}
		int[][] testField = copy(field);
		deleteBlock(testField);
		for(int x = 0; x < block.getWidth(); x++) {
			for(int y = 0; y < block.getHeight(); y++) {
				if(inField(block.getX() + offsetx, block.getY() + offsety)) {
					if(testField[x + block.getX() + offsetx]
							[y + block.getY() + offsety] > 0 
							&& block.getBlock()[x][y] == 1) {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean inField(int i, int j) {
		//System.out.println(i);
		return 0 <= i && i + block.getWidth() - 1 <= gridColumns - 1 && 0 <= j
				&& j + block.getHeight() - 1 <= gridRows - 1;
	}

	public void setBlock(TetrisBlock newBlock) {
		block = newBlock;
		paintBlock(field);
		repaint();
	}
	
	public void paintBlock() {
		paintBlock(field);
	}
	
	public void paintBlock(int[][] field) {
		for(int x = 0; x < block.getWidth(); x++) {
			for(int y = 0; y < block.getHeight(); y++) {
				if(block.getBlock()[x][y] > 0
						&& inField(block.getX(), block.getY())) {
					field[x + block.getX()][y + block.getY()] = block.getColorNumber();
				}
			}
		}
	}
	
	private void deleteBlock() {
		deleteBlock(field);
	}
	
	private void deleteBlock(int[][] field) {
		for(int x = 0; x < block.getWidth(); x++) {
			for(int y = 0; y < block.getHeight(); y++) {
				if(block.getBlock()[x][y] > 0 
						&& inField(block.getX(), block.getY())) {
					field[x + block.getX()][y + block.getY()] = 0;
				}
			}
		}
	}
	
	public static int[][] copy(int[][] src) {
	    int[][] dst = new int[src.length][];
	    for (int i = 0; i < src.length; i++) {
	        dst[i] = Arrays.copyOf(src[i], src[i].length);
	    }
	    return dst;
	}
}
