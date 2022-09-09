package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PPPiece extends Block {
	
	public PPPiece() {
		super(new Color(3, 189, 0), 8, 4, 0,
				new int[][] {{1, 1}, {1, 1}, {1, 0}},
				new int[][] {{1, 1, 0}, {1, 1, 1}},
				new int[][] {{0, 1}, {1, 1}, {1, 1}},
				new int[][] {{1, 1, 1}, {0, 1, 1}}
				);
	}
}
