package view;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import controller.Controller;
import model.pieces.Piece;
import model.pieces.sidekicks.SideKick;
import view.Assets.Assets;

@SuppressWarnings("serial")
public class BoardCell extends JPanel {

	private Controller controller;
	private BoardButton button;
	private JLabel background;
	
	private int cellWidth;
	private int cellHeight;
	private int i;
	private int j;

	public BoardCell(Controller controller, int i, int j) {
		this.controller = controller;
		this.i = i;
		this.j = j;
		
		LayoutManager overlay = new OverlayLayout(this);
		setLayout(overlay);
		
		cellWidth = controller.getAssets().getCellWidth();
		cellHeight = controller.getAssets().getCellHeight();
		
		button = new BoardButton(controller, i, j);
		button.setMaximumSize(new Dimension(cellWidth, cellHeight));
		button.addActionListener(controller);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setFocusable(false);
		add(button);
		
		ImageIcon backGround = new ImageIcon(Assets.class.getResource("background.jpg"));
		Image scaledBackGround = backGround.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT);
		
		background = new JLabel();
		background.setMaximumSize(new Dimension(cellWidth, cellHeight));
		background.setIcon(new ImageIcon(scaledBackGround));
		add(background);
		
		setVisible(true);
	}

	public Piece getPiece() {
		return controller.getGame().getCellAt(j, i).getPiece();
	}

	public boolean isEmpty() {
		return getPiece() == null;
	}

	public void paintPiece() {
		if (!isEmpty()) {
			String name = getPiece().getClass().getSimpleName();
			if (!(getPiece() instanceof SideKick))
				if (getPiece().getOwner() == controller.getGame().getPlayer1())
					name += "P1";
				else
					name += "P2";
			
			Image scaledCharacter = controller.getAssets().getCharacter(name);
			button.setIcon(new ImageIcon(scaledCharacter));
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
	
	@Override
	public boolean isOptimizedDrawingEnabled() {
		return false;
	}

}
