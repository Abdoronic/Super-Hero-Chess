package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import view.customGUI.BoardCell;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements ActionListener {

	private Game game;

	private Piece SelectedPiece;
	private Boolean SelectedRanged;
	private Boolean SelectedSuper;
	private Boolean HackedPiece;
	private Boolean Teleporting;
	private Boolean RestorePiece;
  
	private BoardCell[][] board = new BoardCell[6][7];

	public BoardPanel(Game game) {
		this.game = game;
		this.selectedPiece = null;
		setLayout(new GridLayout(6, 7));
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new BoardCell(game, i, j);
				BoardCell cell = board[i][j];
				cell.addActionListener(this);
				add(cell);
				cell.paintPiece();
			}
		}
		setVisible(true);
	}

	public Piece getPieceAt(int i, int j) {
		return game.getCellAt(j, i).getPiece();
	}

	public boolean isEmpty(int i, int j) {
		return getPieceAt(i, j) == null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("here");

	}
	
	public void SelectPiece(BoardCell c) { 
		SelectedPiece.setPosI(c.getI());
		SelectedPiece.setPosJ(c.getJ());
		
	}

	public static void SelectAbility(Piece p) {
		if (p instanceof Medic) {
			ArrayList<Piece> dead = p.getOwner().getDeadCharacters();
			Object[] graveyard = new Object[dead.size()];
			for (int i = 0; i < dead.size(); i++) {
				graveyard[i] = dead.get(i).getName();
			}
			JPanel revive = new JPanel();
			revive.add(new JLabel("Please select a dead character to revive"));
			int pos = JOptionPane.showOptionDialog(null, revive, "Medic", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, graveyard, null);

			Piece revived = dead.get(pos);
			SelectedPiece = revived;

		}
		if (p instanceof Ranged) {
			SelectedRanged = true;
		}
		if (p instanceof Tech) {
			Object[] TechAbilities = { "Hack Enemy", "Restore ability", "Teleport" };
			JPanel abilities = new JPanel();
			abilities.add(new JLabel("Please a Tech ability"));
			int pos = JOptionPane.showOptionDialog(null, abilities, "Tech", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, TechAbilities, null);
			if (pos == 0) {
				HackedPiece = true;
			}
			if (pos == 1) {
				RestorePiece = true;
			}
			if (pos == 2) {
				Teleporting =true;
			}
		}
		if (p instanceof Super) {
			SelectedSuper = true;
		}
	}
}
