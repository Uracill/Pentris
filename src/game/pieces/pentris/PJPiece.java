package game.pieces.pentris;

import game.pieces.Block;

public class PJPiece extends Block {
	
	public PJPiece() {
		super(4, 2, 0, 
				new int[][] {{1, 0}, {0, 1}, {0, 1}, {0, 1}, {0, 1}},
				new int[][] {{1, 1, 1, 1}, {1, 0, 0, 0}},
				new int[][] {{1, 1}, {1, 0}, {1, 0}, {1, 0}, {1, 0}},
				new int[][] {{0, 0, 0, 1}, {1, 1, 1, 1}}
				);
	}
}
