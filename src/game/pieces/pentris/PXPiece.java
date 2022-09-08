package game.pieces.pentris;

import game.pieces.Block;

public class PXPiece extends Block {
	
	public PXPiece() {
		super(14, 3, 0, 
				new int[][] {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}
				);
	}
}
