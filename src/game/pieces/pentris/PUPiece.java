package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PUPiece extends Block {
	
	public PUPiece() {
		super(new Color(242, 73, 220), 11, 4, 0, 
				new int[][] {{1, 1}, {0, 1}, {1, 1}},
				new int[][] {{1, 1, 1}, {1, 0, 1}},
				new int[][] {{1, 1}, {1, 0}, {1, 1}},
				new int[][] {{1, 0, 1}, {1, 1, 1}}
				);
	}
}
