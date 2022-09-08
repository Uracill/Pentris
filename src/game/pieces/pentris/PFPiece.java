package game.pieces.pentris;

import game.pieces.Block;

public class PFPiece extends Block {
	
	public PFPiece() {
		super(1, 3, 0, 
				new int[][] {{0, 1, 0}, {1, 1, 1}, {1, 0, 0}},
				new int[][] {{0, 1, 0}, {1, 1, 1}, {1, 0, 0}},
				new int[][] {{0, 1, 0}, {1, 1, 1}, {1, 0, 0}},
				new int[][] {{0, 1, 0}, {1, 1, 1}, {1, 0, 0}}
				);
	}
}
