package game.pieces;

public class JPiece extends Block{

	public JPiece() {
		super(2, 3, 0, 
				new int[][] {{1, 1}, {0, 1}, {0, 1}},
				new int[][] {{1, 1, 1}, {1, 0, 0}},
				new int[][] {{1, 0}, {1, 0}, {1, 1}},
				new int[][] {{0, 0, 1}, {1, 1, 1}});
	}
	
	

}
