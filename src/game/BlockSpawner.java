package game;

import java.util.Random;

import game.pieces.Block;
import game.pieces.pentris.PFPiece;
import game.pieces.pentris.PFPieceR;
import game.pieces.pentris.PIPiece;
import game.pieces.pentris.PJPiece;
import game.pieces.pentris.PLPiece;
import game.pieces.pentris.PNPiece;
import game.pieces.pentris.PNPieceR;
import game.pieces.pentris.PPPiece;
import game.pieces.pentris.PPPieceR;
import game.pieces.pentris.PTPiece;
import game.pieces.pentris.PUPiece;
import game.pieces.pentris.PVPiece;
import game.pieces.pentris.PWPiece;
import game.pieces.pentris.PXPiece;
import game.pieces.pentris.PYPiece;
import game.pieces.pentris.PYPieceR;
import game.pieces.pentris.PZPiece;
import game.pieces.pentris.PZPieceR;
import game.pieces.tetris.TIPiece;
import game.pieces.tetris.TJPiece;
import game.pieces.tetris.TLPiece;
import game.pieces.tetris.TOPiece;
import game.pieces.tetris.TSPiece;
import game.pieces.tetris.TTPiece;
import game.pieces.tetris.TZPiece;
import scenes.TetrisScene;

public class BlockSpawner {
	
	private Game scene;
	
	private int number;
	private Random random;

	public BlockSpawner(Game game) {
		this.scene = game;
		if(game instanceof TetrisScene) {
			number = 7;
		}
		else {
			number = 18;
		}
		random = new Random();
	}
	
	public void spawnBlock() {
		int blockNumber = random.nextInt(number) + 1;
		if(number == 7) {	//bei Tetris gibt es 7 Pieces
			switch(blockNumber) {
			case 1:
				scene.setBlock(new TIPiece()); // I Piece
				break;
			case 2: 
				scene.setBlock(new TJPiece()); // J Piece
				break;
			case 3: 
				scene.setBlock(new TLPiece()); // L Piece
				break;
			case 4:
				scene.setBlock(new TOPiece()); // O Piece
				break;
			case 5: 
				scene.setBlock(new TSPiece()); // S Piece
				break;
			case 6:
				scene.setBlock(new TTPiece()); // T Piece
				break;
			case 7: 
				scene.setBlock(new TZPiece()); // Z Piece
				break;
			}
		}
		else {	//Bei Pentris gibt es 18 Steine
			switch(blockNumber) {
			case 1:
				scene.setBlock(new PFPiece()); //F Piece
				break;
			case 2: 
				scene.setBlock(new PFPieceR()); //F-Reverse Piece
				break;
			case 3: 
				scene.setBlock(new PIPiece()); //I Piece
				break;
			case 4:
				scene.setBlock(new PJPiece()); //J Piece
				break;
			case 5: 
				scene.setBlock(new PLPiece()); //L Piece
				break;
			case 6:
				scene.setBlock(new PNPiece()); //N Piece
				break;
			case 7: 
				scene.setBlock(new PNPieceR()); //N-Reverse Piece
				break;
			case 8: 
				scene.setBlock(new PPPiece()); //P Piece
				break;
			case 9: 
				scene.setBlock(new PPPieceR()); //P-Reverse Piece
				break;
			case 10: 
				scene.setBlock(new PTPiece()); //T Piece
				break;
			case 11: 
				scene.setBlock(new PUPiece()); //U Piece
				break;
			case 12: 
				scene.setBlock(new PVPiece()); //V Piece
				break;
			case 13: 
				scene.setBlock(new PWPiece()); //W Piece
				break;
			case 14: 
				scene.setBlock(new PXPiece()); //X Piece
				break;
			case 15: 
				scene.setBlock(new PYPiece()); //Y Piece
				break;
			case 16: 
				scene.setBlock(new PYPieceR()); //Y-Reverse Piece
				break;
			case 17: 
				scene.setBlock(new PZPiece()); //Z Piece
				break;
			case 18: 
				scene.setBlock(new PZPieceR()); //Z-Reverse Piece
				break;
			}
		}
	}

	public void spawnBlock(int blockNumber) {
		if(number == 7) {	//bei Tetris gibt es 7 Pieces
			switch(blockNumber) {
			case 1:
				scene.setBlock(new TIPiece()); // I Piece
				break;
			case 2: 
				scene.setBlock(new TJPiece()); // J Piece
				break;
			case 3: 
				scene.setBlock(new TLPiece()); // L Piece
				break;
			case 4:
				scene.setBlock(new TOPiece()); // O Piece
				break;
			case 5: 
				scene.setBlock(new TSPiece()); // S Piece
				break;
			case 6:
				scene.setBlock(new TTPiece()); // T Piece
				break;
			case 7: 
				scene.setBlock(new TZPiece()); // Z Piece
				break;
			}
		}
		else {	//Bei Pentris gibt es 18 Steine
			switch(blockNumber) {
			case 1:
				scene.setBlock(new PFPiece()); //F Piece
				break;
			case 2: 
				scene.setBlock(new PFPieceR()); //F-Reverse Piece
				break;
			case 3: 
				scene.setBlock(new PIPiece()); //I Piece
				break;
			case 4:
				scene.setBlock(new PJPiece()); //J Piece
				break;
			case 5: 
				scene.setBlock(new PLPiece()); //L Piece
				break;
			case 6:
				scene.setBlock(new PNPiece()); //N Piece
				break;
			case 7: 
				scene.setBlock(new PNPieceR()); //N-Reverse Piece
				break;
			case 8: 
				scene.setBlock(new PPPiece()); //P Piece
				break;
			case 9: 
				scene.setBlock(new PPPieceR()); //P-Reverse Piece
				break;
			case 10: 
				scene.setBlock(new PTPiece()); //T Piece
				break;
			case 11: 
				scene.setBlock(new PUPiece()); //U Piece
				break;
			case 12: 
				scene.setBlock(new PVPiece()); //V Piece
				break;
			case 13: 
				scene.setBlock(new PWPiece()); //W Piece
				break;
			case 14: 
				scene.setBlock(new PXPiece()); //X Piece
				break;
			case 15: 
				scene.setBlock(new PYPiece()); //Y Piece
				break;
			case 16: 
				scene.setBlock(new PYPieceR()); //Y-Reverse Piece
				break;
			case 17: 
				scene.setBlock(new PZPiece()); //Z Piece
				break;
			case 18: 
				scene.setBlock(new PZPieceR()); //Z-Reverse Piece
				break;
			}
		}
	}
}
