package game.pieces;

import java.awt.Color;

public class TetrisBlock {
	
	private int[][] block;
	private int colorNumber;
	private int x;
	private int y;
	
	public TetrisBlock(int[][] block, Color color, int colorNumber,
			int x, int y) {
		this.block = block;
		this.colorNumber = colorNumber;
		this.x = x;
		this.y = y;
	}
	
	public int[][] getBlock() {
		return block;
	}
	
	public int getColorNumber() {
		return colorNumber;
	}
	
	public int getWidth() {
		return block.length;
	}
	
	public int getHeight() {
		return block[0].length;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void moveDown() {
		y++;
	}
	
	public void moveLeft() {
		x--;
	}
	
	public void moveRight() {
		x++;
	}

	public void rotateLeft() {
		// TODO Auto-generated method stub
		
	}

	public void rotateRight() {
		// TODO Auto-generated method stub
		
	}

	public void instantDrop() {
		// TODO Auto-generated method stub
		
	}
}
