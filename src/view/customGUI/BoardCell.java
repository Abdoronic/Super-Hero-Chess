package view.customGUI;

import java.awt.Insets;

import javax.swing.JButton;

import model.game.Game;
import model.pieces.Piece;

@SuppressWarnings("serial")
public class BoardCell extends JButton{
	
	private Game game;
	private int i;
	private int j;
	
	public BoardCell(Game game, int i, int j) {
		setBorderPainted(false);
		this.game = game;
		this.i = i;
		this.j = j;
	}
	
	public Piece getPiece() {
		return game.getCellAt(j,i).getPiece();
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
