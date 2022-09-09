package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PTPiece extends Block {
	
	public PTPiece() {
		super(new Color(0, 240, 224), 10, 3, 0, 
				new int[][] {{1, 0, 0}, {1, 1, 1}, {1, 0, 0}},
				new int[][] {{0, 1, 0}, {0, 1, 0}, {1, 1, 1}},
				new int[][] {{0, 0, 1}, {1, 1, 1}, {0, 0, 1}},
				new int[][] {{1, 1, 1}, {0, 1, 0}, {0, 1, 0}}
				);
	}
}
