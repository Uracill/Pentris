package game.pieces.pentris;

import game.pieces.Block;

public class PNPiece extends Block {
	
	public PNPiece() {
		super(6, 2, 0, 
				new int[][] {{1, 0}, {1, 1}, {0, 1}},
				new int[][] {{0, 1, 1, 1}, {1, 1, 0, 0}},
				new int[][] {{1, 0}, {1, 0}, {1, 1}, {0, 1}},
				new int[][] {{0, 0, 1, 1}, {1, 1, 1, 0}}
				);
	}
}
