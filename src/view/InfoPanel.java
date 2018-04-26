package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

	Controller controller;
	JLabel pieceInfo;
	JLabel currPlyrDeadChars;

	public InfoPanel(Controller controller) {

		setLayout(new BorderLayout());
		JButton abilityButton = new JButton("Ability");
		abilityButton.addActionListener(controller);
		pieceInfo = new JLabel();
		currPlyrDeadChars = new JLabel();
		pieceInfo.setText("");
		currPlyrDeadChars.setText("");
		this.add(abilityButton, BorderLayout.EAST);
		this.add(pieceInfo, BorderLayout.WEST);
		this.add(currPlyrDeadChars, BorderLayout.CENTER);
		currPlyrDeadChars.setHorizontalAlignment(JLabel.CENTER);
	}

	public void updateInfoPanel(Controller controller) {
		
		String Info = controller.getSelectedPiece().getName() ;
		if (controller.getSelectedPiece() instanceof ActivatablePowerHero) {
			if (((ActivatablePowerHero) controller.getSelectedPiece()).isPowerUsed())
				Info += " power used";
			else
				Info += " power not used";
		} else if (controller.getSelectedPiece() instanceof Armored) {
			if (((Armored) controller.getSelectedPiece()).isArmorUp())
				Info += "Armor is up";
			else
				Info += "Armor is down";
		}
		String DeadChars = "";
		ArrayList<Piece> curDead = controller.getGame().getCurrentPlayer().getDeadCharacters() ;
		for (int i = 0; i < curDead.size(); i++) {

			DeadChars += " " + controller.getGame().getCurrentPlayer().getDeadCharacters().get(i).getName();

		}
		pieceInfo.setText(Info);
		currPlyrDeadChars.setText(DeadChars);

	}

}
