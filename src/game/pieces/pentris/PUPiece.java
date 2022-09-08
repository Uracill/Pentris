package game.pieces.pentris;

import game.pieces.Block;

public class PUPiece extends Block {
	
	public PUPiece() {
		super(11, 3, 0, 
				new int[][] {{1, 1}, {0, 1}, {1, 1}},
				new int[][] {{1, 1, 1}, {1, 0, 1}},
				new int[][] {{1, 1}, {1, 0}, {1, 1}},
				new int[][] {{1, 0, 1}, {1, 1, 1}}
				);
	}
}
