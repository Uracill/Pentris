package game.pieces.tetris;

import java.awt.Color;

import game.pieces.Block;

public class TLPiece extends Block{

	public TLPiece() {
		super(new Color(240, 160, 0), 3, 3, 0, 
				new int[][] {{0, 1}, {0, 1}, {1, 1}},
				new int[][] {{1, 1, 1}, {0, 0, 1}},
				new int[][] {{1, 1}, {1, 0}, {1, 0}},
				new int[][] {{1, 0, 0}, {1, 1, 1}}
				);
	}
}
