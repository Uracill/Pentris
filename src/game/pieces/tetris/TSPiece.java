package game.pieces.tetris;

import java.awt.Color;

import game.pieces.Block;

public class TSPiece extends Block{

	public TSPiece() {
		super(new Color(0, 240, 0), 5, 3, 0, 
				new int[][] {{0, 1}, {1, 1}, {1, 0}}, 
				new int[][] {{1, 1, 0}, {0, 1, 1}}
				);
	}
}
