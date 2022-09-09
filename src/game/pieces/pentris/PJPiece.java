package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PJPiece extends Block {
	
	public PJPiece() {
		super(new Color(240, 141, 2), 4, 4, 0, 
				new int[][] {{1, 1}, {0, 1}, {0, 1}, {0, 1}},
				new int[][] {{1, 1, 1, 1}, {1, 0, 0, 0}},
				new int[][] {{1, 0}, {1, 0}, {1, 0}, {1, 1}},
				new int[][] {{0, 0, 0, 1}, {1, 1, 1, 1}}
				);
	}
}
