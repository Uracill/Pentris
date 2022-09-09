package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PFPiece extends Block {
	
	public PFPiece() {
		super(new Color(112, 98, 2), 1, 3, 0, 
				new int[][] {{0, 1, 0}, {1, 1, 1}, {1, 0, 0}},
				new int[][] {{0, 1, 0}, {1, 1, 0}, {0, 1, 1}},
				new int[][] {{0, 0, 1}, {1, 1, 1}, {0, 1, 0}},
				new int[][] {{1, 1, 0}, {0, 1, 1}, {0, 1, 0}}
				);
	}
}
