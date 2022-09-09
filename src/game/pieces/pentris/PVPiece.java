package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PVPiece extends Block {
	
	public PVPiece() {
		super(new Color(34, 102, 107), 12, 3, 0, 
				new int[][] {{1, 1, 1}, {0, 0, 1}, {0, 0, 1}},
				new int[][] {{1, 1, 1}, {1, 0, 0}, {1, 0, 0}},
				new int[][] {{1, 0, 0}, {1, 0, 0}, {1, 1, 1}},
				new int[][] {{0, 0, 1}, {0, 0, 1}, {1, 1, 1}}
				);
	}
}
