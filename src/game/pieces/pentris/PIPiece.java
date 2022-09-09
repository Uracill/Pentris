package game.pieces.pentris;

import java.awt.Color;

import game.pieces.Block;

public class PIPiece extends Block {
	
	public PIPiece() {
		super(new Color(78, 74, 242), 3, 4, 0, 
				new int[][] {{1}, {1}, {1}, {1}, {1}},
				new int[][] {{1, 1, 1, 1, 1}});
	}
}
