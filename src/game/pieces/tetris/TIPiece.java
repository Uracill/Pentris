package game.pieces.tetris;

import java.awt.Color;

import game.pieces.Block;

public class TIPiece extends Block{

	public TIPiece() {
		super(new Color(0, 240, 240), 1, 3, 0, 
				new int[][] {{1}, {1}, {1}, {1}},
				new int[][] {{1, 1, 1, 1}}
				);
	}
}
