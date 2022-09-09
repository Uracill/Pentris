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
import scenes.PentrisScene;
import states.GameStateManager;
import states.MenuState;
import states.MoveState;

public abstract class Game extends AbstractScene {

	protected BlockSpawner spawner;
	protected GameStateManager gameStateManager;
	
	private Block block;
	private Block nextBlock;
	private Block savedBlock;

	private int swap;
	
	private int level;
	private int clearedRows;
	private int points;
	
	private int gridCellSize;
	private int gridRows;
	private int gridColumns;
	private int[][] field;
	
	public Game() {
		
	}
	
	public void startGame() {
		spawner = new BlockSpawner(this);
		gameStateManager = new GameStateManager();
		
		block = null;
		nextBlock = null;
		savedBlock = null;
		
		swap = 2;
		
		level = 1;
		clearedRows = 0;
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
		addKeyBinding("Z", () -> rotateRight());
		addKeyBinding("C", () -> saveBlock());
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
		
		if(this instanceof PentrisScene) {
			drawGridPentris(g);
		}
		else {
			drawGridTetris(g);
		}
		drawOtherPieces(g);
		g.drawString("Points: " + Integer.toString(points), 450, 100);
		g.drawString("Level: " + Integer.toString(level), 450, 120);
		g.drawString("Cleared Rows: " + Integer.toString((level - 1) * 10 + clearedRows), 450, 140);
	}
	
	private void drawGridPentris(Graphics g) {
		for(int i = 0; i < gridColumns; i++) {
			for(int j = 0; j < gridRows; j++) {
				if(field[i][j] > 0) {
					switch(field[i][j]) {
					case 1: 
						g.setColor(new Color(112, 98, 2));
						break;
					case 2: 
						g.setColor(new Color(242, 220, 78));
						break;
					case 3: 
						g.setColor(new Color(78, 74, 242));
						break;
					case 4: 
						g.setColor(new Color(240, 141, 2));
						break;
					case 5: 
						g.setColor(new Color(189, 111, 2));
						break;
					case 6: 
						g.setColor(new Color(6, 0, 189));
						break;
					case 7: 
						g.setColor(new Color(4, 0, 117));
						break;
					case 8: 
						g.setColor(new Color(3, 189, 0));
						break;
					case 9: 
						g.setColor(new Color(4, 240, 0));
						break;
					case 10: 
						g.setColor(new Color(0, 240, 224));
						break;
					case 11: 
						g.setColor(new Color(242, 73, 220));
						break;
					case 12: 
						g.setColor(new Color(34, 102, 107));
						break;
					case 13: 
						g.setColor(new Color(2, 117, 0));
						break;
					case 14: 
						g.setColor(new Color(240, 16, 0));
						break;
					case 15: 
						g.setColor(new Color(189, 0, 164));
						break;
					case 16: 
						g.setColor(new Color(112, 34, 102));
						break;
					case 17: 
						g.setColor(new Color(189, 164, 4));
						break;
					case 18: 
						g.setColor(new Color(112, 102, 36));
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

	private void drawGridTetris(Graphics g) {
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
	
	private void drawOtherPieces(Graphics g) {
		//SavedBlock
		g.drawString("Saved:", 50, 50);
		g.drawRect(90, 25, 60, 40);
		if(savedBlock != null) {
			for(int i = 0; i < savedBlock.getAllBlocks().get(0).length; i++) {
				for(int j = 0; j < savedBlock.getAllBlocks().get(0)[0].length; j++) {
					if(savedBlock.getAllBlocks().get(0)[i][j] > 0) {
						g.setColor(savedBlock.getColor());
						g.fillRect(i * 10 + 95, j * 10 + 30, 10, 10);
						g.setColor(new Color(0, 0, 0));
						g.drawRect(i * 10 + 95,
								j * 10 + 30, 10, 10);
					}
				}
			}
		}
		
		//NextBlock
		g.drawString("Next:", 450, 50);
		g.drawRect(490, 25, 60, 40);
		if(nextBlock != null) {	//TODO: Delete if
			for(int i = 0; i < nextBlock.getAllBlocks().get(0).length; i++) {
				for(int j = 0; j < nextBlock.getAllBlocks().get(0)[0].length; j++) {
					if(nextBlock.getAllBlocks().get(0)[i][j] > 0) {
						g.setColor(nextBlock.getColor());
						g.fillRect(i * 10 + 95, j * 10 + 30, 10, 10);
						g.setColor(new Color(0, 0, 0));
						g.drawRect(i * 10 + 95,
								j * 10 + 30, 10, 10);
					}
				}
			}
		}
	}
	
	private void instantDrop() {
		while(isFree(MoveState.Down)) {
			deleteBlock();
			block.moveDown();
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
	
	private void saveBlock() {
		if(swap == 2) {
			swap = 0;
			deleteBlock();
			if(savedBlock == null) {
				savedBlock = block;
				spawner.spawnBlock();
			}
			else {
				Block temp = block;
				spawner.spawnBlock(savedBlock.getColorNumber());
				savedBlock = temp;
			}
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
		if(swap == 0 || swap == 1) {
			swap++;
		}
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
		boolean pentris = false;
		int pentrisGap = -1;
		if(this instanceof PentrisScene) {
			pentris = true;
		}
		List<Integer> fullRows = new ArrayList<>();
		for(int j = 0; j < gridRows; j++) {
			boolean isFull = true;
			if(pentris) {
				pentrisGap = 0;
			}
			for(int i = 0; i < gridColumns; i++) {
				if(field[i][j] == 0) {	//if one column of the row is empty, then the line could not get cleared
					isFull = false;
					pentrisGap++;
				}
			}
			if(isFull || pentrisGap == 0 || pentrisGap == 1) {	//Zusatzregel, dass max. 1 Spalte freibleiben darf
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
		
		if(clearedRows >= 10) {
			level++;
			clearedRows = clearedRows - 10;
		}
	}

	public int getLevel() {
		return level;
	}

	public int getVelocity() {
		return (int)(250/(0.2*level));
	}
}
