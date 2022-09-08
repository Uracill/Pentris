package game.pieces.pentris;

import game.pieces.Block;

public class PNPieceR extends Block {
	
	public PNPieceR() {
		super(7, 2, 0, 
				new int[][] {{0, 1}, {0, 1}, {1, 1}, {0, 1}},
				new int[][] {{1, 1, 1, 0}, {0, 0, 1, 1}},
				new int[][] {{0, 1}, {1, 1}, {1, 0}, {1, 0}},
				new int[][] {{1, 1, 0, 0}, {0, 1, 1, 1}}
				);
	}
}
