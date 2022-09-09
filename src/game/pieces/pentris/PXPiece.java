package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PXPiece extends Block {
	
	public PXPiece() {
		super(new Color(240, 16, 0), 14, 3, 0, 
				new int[][] {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}
				);
	}
}
