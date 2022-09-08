package game.pieces;

public class TPiece extends Block{

	public TPiece() {
		super(6, 3, 0,
				new int[][] {{1, 0}, {1, 1}, {1, 0}},
				new int[][] {{1, 1, 1}, {0, 1, 0}},
				new int[][] {{0, 1}, {1, 1}, {0, 1}},
				new int[][] {{0, 1, 0}, {1, 1, 1}});
	}
	
	

}
