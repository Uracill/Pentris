package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PYPieceR extends Block {
	
	public PYPieceR() {
		super(new Color(112, 34, 102), 16, 3, 0, 
				new int[][] {{0, 1}, {1, 1}, {0, 1}, {0, 1}},
				new int[][] {{1, 1, 1, 1}, {0, 1, 0, 0}},
				new int[][] {{1, 0}, {1, 0}, {1, 1}, {1, 0}},
				new int[][] {{0, 0, 1, 0}, {1, 1, 1, 1}}
				);
	}
}
