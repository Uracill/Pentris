package game.pieces.tetris;

import game.pieces.Block;

public class TLPiece extends Block{

	public TLPiece() {
		super(3, 3, 0, 
				new int[][] {{0, 1}, {0, 1}, {1, 1}},
				new int[][] {{1, 1, 1}, {0, 0, 1}},
				new int[][] {{1, 1}, {1, 0}, {1, 0}},
				new int[][] {{1, 0, 0}, {1, 1, 1}}
				);
	}
}
