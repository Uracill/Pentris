package game.pieces.tetris;

import game.pieces.Block;

public class TIPiece extends Block{

	public TIPiece() {
		super(1, 3, 0, 
				new int[][] {{1}, {1}, {1}, {1}},
				new int[][] {{1, 1, 1, 1}}
				);
	}
}
