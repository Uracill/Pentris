package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PZPiece extends Block {
	
	public PZPiece() {
		super(new Color(189, 164, 4), 17, 4, 0, 
				new int[][] {{0, 0, 1}, {1, 1, 1}, {1, 0, 0}},
				new int[][] {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}}
				);
	}
}
