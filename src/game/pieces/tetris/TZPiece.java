package game.pieces.tetris;

import game.pieces.Block;

public class TZPiece extends Block{

	public TZPiece() {
		super(7, 3, 0, 
				new int[][] {{1, 0}, {1, 1}, {0, 1}},
				new int[][] {{0, 1, 1}, {1, 1, 0}}
				);
	}
}
