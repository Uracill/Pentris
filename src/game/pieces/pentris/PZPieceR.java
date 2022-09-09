package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PZPieceR extends Block {
	
	public PZPieceR() {
		super(new Color(112, 102, 36), 18, 4, 0, 
				new int[][] {{1, 0, 0}, {1, 1, 1}, {0, 0, 1}},
				new int[][] {{0, 1, 1}, {0, 1, 0}, {1, 1, 0}}
				);
	}
}
