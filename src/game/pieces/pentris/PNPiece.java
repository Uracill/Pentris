package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PNPiece extends Block {
	
	public PNPiece() {
		super(new Color(6, 0, 189), 6, 2, 0, 
				new int[][] {{1, 0}, {1, 1}, {0, 1}, {0, 1}},
				new int[][] {{0, 1, 1, 1}, {1, 1, 0, 0}},
				new int[][] {{1, 0}, {1, 0}, {1, 1}, {0, 1}},
				new int[][] {{0, 0, 1, 1}, {1, 1, 1, 0}}
				);
	}
}
