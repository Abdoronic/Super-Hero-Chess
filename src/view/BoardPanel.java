package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.game.Game;
import view.customGUI.BoardCell;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements ActionListener{
	
	private Game game;
	private BoardCell[][] board = new BoardCell[6][7];
	
	
	public BoardPanel(Game game) {
		this.game = game;
		setLayout(new GridLayout(6, 7));
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new BoardCell(game, i, j);
				BoardCell cell = board[i][j];
				cell.addActionListener(this);
				add(cell);
				cell.setText("hi");
			}
		}
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("here");
		
	}
}
