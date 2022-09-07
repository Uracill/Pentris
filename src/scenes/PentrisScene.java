package scenes;

import java.awt.Graphics;

public class PentrisScene extends AbstractScene {

	private int gridCellSize;
	private int gridRows;
	private int gridColumns;
	
	public PentrisScene() {
	gridCellSize = 20;
	gridRows = 20;
	gridColumns = 10;
	}

	public void startGame() {
		System.out.println("Pentris startet");
	}
//	
//	private void paintGrid(int gridCellSize, int gridRows, int gridColumns) {
//		for(int i = 0; i < gridRows; i++) {
//			
//		}
//	}
	
	private void drawBlock(Graphics g) {
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < gridColumns; i++) {
			for(int j = 0; j < gridRows; j++) {
				g.drawRect(i * gridCellSize + 200,
						j * gridCellSize + 10, gridCellSize, gridCellSize);
			}
		}
	}
	
}
