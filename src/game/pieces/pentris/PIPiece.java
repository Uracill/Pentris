package game.pieces.pentris;

import game.pieces.Block;

public class PIPiece extends Block {
	
	public PIPiece() {
		super(3, 2, 0, 
				new int[][] {{1}, {1}, {1}, {1}, {1}},
				new int[][] {{1, 1, 1, 1, 1}});
	}
}
