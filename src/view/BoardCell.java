package view;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.game.Game;
import model.pieces.Piece;
import model.pieces.sidekicks.SideKick;
import view.Assets.Assets;

@SuppressWarnings("serial")
public class BoardCell extends JButton {

	private Game game;
	private int i;
	private int j;

	public BoardCell(Game game, int i, int j) {
		setBorderPainted(false);
		setOpaque(false);
		setFocusable(false);
		this.game = game;
		this.i = i;
		this.j = j;
	}

	public Piece getPiece() {
		return game.getCellAt(j, i).getPiece();
	}

	public boolean isEmpty() {
		return getPiece() == null;
	}

	public void paintPiece() {
		if (!isEmpty()) {
			String name = getPiece().getClass().getSimpleName();
			if (!(getPiece() instanceof SideKick))
				if (getPiece().getOwner() == game.getPlayer1())
					name += "P1";
				else
					name += "P2";
			name += ".gif";
			setIcon(new ImageIcon(Assets.class.getResource(name)));
		}
	}

	

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
