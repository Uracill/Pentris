package game.pieces.pentris;

import game.pieces.Block;

public class PZPieceR extends Block {
	
	public PZPieceR() {
		super(18, 3, 0, 
				new int[][] {{1, 0, 0}, {1, 1, 1}, {0, 0, 1}},
				new int[][] {{0, 1, 1}, {0, 1, 0}, {1, 1, 0}}
				);
	}
}
