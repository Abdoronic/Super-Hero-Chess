package view;

import java.awt.GridLayout;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	
	private Controller controller;

	private BoardCell[][] board = new BoardCell[6][7];

	public BoardPanel(Controller controller) {
		this.controller = controller;
		setLayout(new GridLayout(6, 7));
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = board[i].length - 1; j >= 0; j--) {
				board[i][j] = new BoardCell(controller, i, j);
				BoardCell cell = board[i][j];
				cell.addActionListener(controller);
				add(cell);
				cell.paintPiece();
			}
		}
		setVisible(true);
	}
	
	public void refresh() {
		removeAll();
		setLayout(new GridLayout(6, 7));
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = board[i].length - 1; j >= 0; j--) {
				board[i][j] = new BoardCell(controller, i, j);
				BoardCell cell = board[i][j];
				cell.addActionListener(controller);
				add(cell);
				cell.paintPiece();
			}
		}
		controller.getSuperHeroChess().getPayloadPanel().updatePayload(controller);
//		this.revalidate();
//		this.repaint();
//		setVisible(true);
	}


	public void lightUpAvailableMoves() {
		// makes green cells
	}

	public void lightUpAvailableAbilityMoves() {
		// makes orange cells
	}

	public void lightOffAvailableMoves() {
		// makes green cells
	}

	public void lightOffAvailableAbilityMoves() {
		// makes orange cells
	}

	public void doAttackAnimation() {
		
	}

	public void doMoveAnimation() {
		
	}

	public void playSuperAnimation() {
		
	}

	public void playRangedAnimation() {
		
	}

	public void playMedicAnimation() {
		
	}
}
