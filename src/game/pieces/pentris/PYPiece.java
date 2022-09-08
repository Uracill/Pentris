package game.pieces.pentris;

import game.pieces.Block;

public class PYPiece extends Block {
	
	public PYPiece() {
		super(15, 3, 0, 
				new int[][] {{0, 1}, {0, 1}, {1, 1}, {0, 1}},
				new int[][] {{1, 1, 1, 1}, {0, 0, 1, 0}},
				new int[][] {{1, 0}, {1, 1}, {1, 0}, {1, 0}},
				new int[][] {{0, 1, 0, 0}, {1, 1, 1, 1}}
				);
	}
}
