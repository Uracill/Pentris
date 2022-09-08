package game.pieces.pentris;

import game.pieces.Block;

public class PPPieceR extends Block {
	
	public PPPieceR() {
		super(9, 2, 0, 
				new int[][] {{1, 0}, {1, 1}, {1, 1}},
				new int[][] {{0, 1, 1}, {1, 1, 1}},
				new int[][] {{1, 1}, {1, 1}, {0, 1}},
				new int[][] {{1, 1, 1}, {1, 1, 0}}
				);
	}
}
