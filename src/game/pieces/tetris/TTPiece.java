package game.pieces.tetris;

import java.awt.Color;

import game.pieces.Block;

public class TTPiece extends Block{

	public TTPiece() {
		super(new Color(160, 0, 240), 6, 3, 0,
				new int[][] {{1, 0}, {1, 1}, {1, 0}},
				new int[][] {{1, 1, 1}, {0, 1, 0}},
				new int[][] {{0, 1}, {1, 1}, {0, 1}},
				new int[][] {{0, 1, 0}, {1, 1, 1}}
				);
	}
}
