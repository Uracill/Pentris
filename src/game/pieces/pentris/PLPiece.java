package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PLPiece extends Block {
	
	public PLPiece() {
		super(new Color(189, 111, 2), 5, 4, 0, 
				new int[][] {{0, 1}, {0, 1}, {0, 1}, {1, 1}},
				new int[][] {{1, 1, 1, 1}, {0, 0, 0, 1}},
				new int[][] {{1, 1}, {1, 0}, {1, 0}, {1, 0}},
				new int[][] {{1, 0, 0, 0}, {1, 1, 1, 1}}
				);
	}
}
