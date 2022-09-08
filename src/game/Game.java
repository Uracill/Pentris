package game;

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

import game.pieces.Block;
import listeners.UserInput;
import scenes.AbstractScene;
import states.GameStateManager;
import states.MenuState;
import states.MoveState;

public abstract class Game extends AbstractScene {

	protected GameStateManager gameStateManager;
	
	private int level;
	private int clearedRows;
	private int rowsLevel;
	private int points;
	
	private int gridCellSize;
	private int gridRows;
	private int gridColumns;
	private int[][] field;
	private Block block;
	
	public Game() {
		
	}
	
	public void startGame() {
		gameStateManager = new GameStateManager();
		
		level = 1;
		clearedRows = 0;
		rowsLevel = 0;
		points = 0;
		
		gridCellSize = 20;
		gridRows = 20;
		gridColumns = 10;
		field = new int[gridColumns][gridRows];
		
		setupKeyStrokes();
		startGameLoop();
	}
	
	private void setupKeyStrokes() {
		addKeyBinding("Escape", () -> informiereUeberAenderung(MenuState.Pause));
		addKeyBinding("UP", () -> instantDrop());
		addKeyBinding("LEFT", () -> moveLeft());
		addKeyBinding("DOWN", () -> moveDown());
		addKeyBinding("RIGHT", () -> moveRight());
		addKeyBinding("T", () -> rotateLeft());
		addKeyBinding("Z", () -> rotateRight());	//TODO: Add save
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

	protected abstract void startGameLoop();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawGrid(g);
		g.drawString("Points: " + Integer.toString(points), 450, 50);
		g.drawString("Level: " + Integer.toString(level), 450, 70);
		g.drawString("Cleared Rows: " + Integer.toString(clearedRows), 450, 90);
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
	
	private void instantDrop() {
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
		Block testBlock = new Block(block);
		
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
		else if(state == MoveState.RotateLeft) {
			testBlock.rotateLeft();
		}
		else if(state == MoveState.RotateRight) {
			testBlock.rotateRight();
		}
		int[][] testField = copy(field);
		deleteBlock(testField);
		for(int x = 0; x < testBlock.getWidth(); x++) {
			for(int y = 0; y < testBlock.getHeight(); y++) {
				if(inField(testBlock.getX() + offsetx, testBlock.getY() + offsety, testBlock)) {	//TODO: Rotate
					if(testField[x + testBlock.getX() + offsetx]
							[y + testBlock.getY() + offsety] > 0 
							&& testBlock.getBlock()[x][y] == 1) {
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
		return inField(i, j, block);
	}
	
	private boolean inField(int i, int j, Block block) {
		//System.out.println(i);
		return 0 <= i && i + block.getWidth() - 1 <= gridColumns - 1 && 0 <= j
				&& j + block.getHeight() - 1 <= gridRows - 1;
	}

	public void setBlock(Block newBlock) {
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

	public List<Integer> fullRows() {
		List<Integer> fullRows = new ArrayList<>();
		for(int j = 0; j < gridRows; j++) {
			boolean isFull = true;
			for(int i = 0; i < gridColumns; i++) {
				if(field[i][j] == 0) {	//if one column of the row is empty, then the line could not get cleared
					isFull = false;
				}
			}
			if(isFull) {
				fullRows.add(j);
			}
		}
		return fullRows;
		
	
	}

	public void clearRows(List<Integer> rows) {
		for(int r: rows) {
			for(int j = r; j > 0; j--) {
				for(int i = field.length - 1; i >= 0; i--) {
					field[i][j] = field[i][j-1];
				}
			}
		}
	}
	
	public void update(int fullRows) {
		points = (int) (points + Math.round(Math.pow(10, fullRows) * (level * 0.6)));
		clearedRows += fullRows;
		rowsLevel += fullRows;
		
		if(rowsLevel >= 10) {
			level++;
			rowsLevel = rowsLevel - 10;
		}
		System.out.println(points);
	}

	public int getLevel() {
		return level;
	}

	public int getVelocity() {
		return (int)(250/(0.2*level));
	}
}
