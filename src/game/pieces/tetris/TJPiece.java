package game.pieces.tetris;

import java.awt.Color;

import game.pieces.Block;

public class TJPiece extends Block{

	public TJPiece() {
		super(new Color(0, 0, 240), 2, 3, 0, 
				new int[][] {{1, 1}, {0, 1}, {0, 1}},
				new int[][] {{1, 1, 1}, {1, 0, 0}},
				new int[][] {{1, 0}, {1, 0}, {1, 1}},
				new int[][] {{0, 0, 1}, {1, 1, 1}}
				);
	}
}
