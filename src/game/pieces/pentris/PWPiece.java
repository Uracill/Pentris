package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PWPiece extends Block {
	
	public PWPiece() {
		super(new Color(2, 117, 0), 13, 3, 0, 
				new int[][] {{1, 1, 0}, {0, 1, 1}, {0, 0, 1}},
				new int[][] {{0, 1, 1}, {1, 1, 0}, {1, 0, 0}},
				new int[][] {{1, 0, 0}, {1, 1, 0}, {0, 1, 1}},
				new int[][] {{0, 0, 1}, {0, 1, 1}, {1, 1, 0}}
				);
	}
}
