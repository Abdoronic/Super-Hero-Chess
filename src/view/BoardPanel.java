package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.game.Game;
import model.pieces.Piece;
import model.pieces.sidekicks.SideKick;
import view.Assets.Assets;
import view.customGUI.BoardCell;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements ActionListener{
	
	private Game game;
	private BoardCell[][] board = new BoardCell[6][7];
	private HashMap<String, Image> images = new HashMap<>();
	
	public void loadImages() {
		String[] name = {"SuperP1", "SuperP2", "ArmoredP1", "ArmoredP2", 
				"RangedP1", "RangedP2", "MedicP1", "MedicP2", "SpeedsterP1", 
				"SpeedsterP2", "TechP1", "TechP2", "SideKickP1", "SideKickP2"};
		try {
			for (int i = 0; i < name.length; i++)
				images.put(name[i]+".gif", ImageIO.read(Assets.class.getResource(name[i]+".gif")));
		} catch (Exception e) {
			System.out.println("Image not Found");
		}
	}
	
	public BoardPanel(Game game) {
		this.game = game;
		loadImages();
		setLayout(new GridLayout(6, 7));
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new BoardCell(game, i, j);
				BoardCell cell = board[i][j];
				cell.addActionListener(this);
				add(cell);
				if(!isEmpty(i, j)) {
					String name = getPieceAt(i, j).getClass().getSimpleName();
					if(!(getPieceAt(i, j) instanceof SideKick))
						if(getPieceAt(i, j).getOwner() == game.getPlayer1())
							name += "P1";
						else
							name += "P2";
					name += ".gif";
					add(new JLabel(new ImageIcon(images.get(name))));
				}
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
}
