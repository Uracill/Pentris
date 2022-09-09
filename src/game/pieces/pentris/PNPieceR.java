package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PNPieceR extends Block {
	
	public PNPieceR() {
		super(new Color(4, 0, 117), 7, 2, 0, 
				new int[][] {{0, 1}, {0, 1}, {1, 1}, {1, 0}},
				new int[][] {{1, 1, 1, 0}, {0, 0, 1, 1}},
				new int[][] {{0, 1}, {1, 1}, {1, 0}, {1, 0}},
				new int[][] {{1, 1, 0, 0}, {0, 1, 1, 1}}
				);
	}
}
