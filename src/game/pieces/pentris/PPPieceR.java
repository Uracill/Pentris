package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PPPieceR extends Block {
	
	public PPPieceR() {
		super(new Color(4, 240, 0), 9, 4, 0, 
				new int[][] {{1, 1}, {1, 1}, {0, 1}},
				new int[][] {{1, 1, 1}, {1, 1, 0}},
				new int[][] {{1, 0}, {1, 1}, {1, 1}},
				new int[][] {{0, 1, 1}, {1, 1, 1}}
				);
	}
}
