package game.pieces.pentris;

import game.pieces.Block;

public class PPPiece extends Block {
	
	public PPPiece() {
		super(8, 2, 0, 
				new int[][] {{0, 1}, {1, 1}, {1, 1}},
				new int[][] {{1, 1, 1}, {0, 1, 1}},
				new int[][] {{1, 1}, {1, 1}, {1, 0}},
				new int[][] {{1, 1, 0}, {1, 1, 1}}
				);
	}
}
