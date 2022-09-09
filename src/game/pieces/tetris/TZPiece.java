package game.pieces.tetris;

import java.awt.Color;

import game.pieces.Block;

public class TZPiece extends Block{

	public TZPiece() {
		super(new Color(240, 0, 0), 7, 3, 0, 
				new int[][] {{1, 0}, {1, 1}, {0, 1}},
				new int[][] {{0, 1, 1}, {1, 1, 0}}
				);
	}
}
