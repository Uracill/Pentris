package game.pieces.pentris;

import game.pieces.Block;

public class PLPiece extends Block {
	
	public PLPiece() {
		super(5, 2, 0, 
				new int[][] {{0, 1}, {0, 1}, {0, 1}, {0, 1}, {1, 1}},
				new int[][] {{1, 1, 1, 1}, {0, 0, 0, 1}},
				new int[][] {{1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 1}},
				new int[][] {{1, 0, 0, 0}, {1, 1, 1, 1}}
				);
	}
}
