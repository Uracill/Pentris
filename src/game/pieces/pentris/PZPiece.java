package game.pieces.pentris;

import game.pieces.Block;

public class PZPiece extends Block {
	
	public PZPiece() {
		super(17, 3, 0, 
				new int[][] {{0, 0, 1}, {1, 1, 1}, {1, 0, 0}},
				new int[][] {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}}
				);
	}
}
