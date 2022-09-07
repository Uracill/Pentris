package game;

import java.awt.Color;
import java.util.Random;

import game.pieces.IPiece;
import game.pieces.JPiece;
import game.pieces.LPiece;
import game.pieces.OPiece;
import game.pieces.SPiece;
import game.pieces.TPiece;
import game.pieces.ZPiece;
import scenes.TetrisScene;

public class BlockSpawner {
	
	private int number;
	private Random random;
	
	private TetrisScene scene;

	public BlockSpawner(TetrisScene scene) {
		this.scene = scene;
		number = 7;
		random = new Random();
	}
	
	public void spawnBlock() {
		int blockNumber = random.nextInt(number);
		switch(blockNumber) {
		case 0:
			scene.setBlock(new IPiece()); // I Piece
			break;
		case 1: 
			scene.setBlock(new JPiece()); // J Piece
			break;
		case 2: 
			scene.setBlock(new LPiece()); // L Piece
			break;
		case 3:
			scene.setBlock(new OPiece()); // O Piece
			break;
		case 4: 
			scene.setBlock(new SPiece()); // S Piece
			break;
		case 5:
			scene.setBlock(new TPiece()); // T Piece
			break;
		case 6: 
			scene.setBlock(new ZPiece()); // Z Piece
			break;
		}
	}
}
