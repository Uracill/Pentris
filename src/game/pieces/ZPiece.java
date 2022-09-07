package game.pieces;

public class ZPiece extends TetrisBlock{

	public ZPiece() {
		super(7, 3, 0, 
				new int[][] {{1, 0}, {1, 1}, {0, 1}},
				new int[][] {{0, 1, 1}, {1, 1, 0}});
	}
	
	

}
