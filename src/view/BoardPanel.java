package view;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements ActionListener {

	private Game game;
	private InfoPanel infoPanel;
	private PayloadPanel payloadPanel;

	private static Piece selectedPiece;
	private static Piece targetPiece;
	private static Piece teleportedPiece;
	private static boolean isAbility;
	private static boolean selectedRanged;
	private static boolean selectedSuper;
	private static boolean hackedPiece;
	private static boolean restorePiece;
	private static boolean teleporting;

	private BoardCell[][] board = new BoardCell[6][7];

	public BoardPanel(Game game, InfoPanel infoPanel, PayloadPanel payloadPanel) {
		this.game = game;
		this.infoPanel = infoPanel;
		this.payloadPanel = payloadPanel;
		setLayout(new GridLayout(6, 7));
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = board[i].length - 1; j >= 0; j--) {
				board[i][j] = new BoardCell(game, i, j);
				BoardCell cell = board[i][j];
				cell.addActionListener(this);
				add(cell);
				cell.paintPiece();
			}
		}
		setVisible(true);
	}
	
	public void refresh() {
		this.removeAll();
		setLayout(new GridLayout(6, 7));
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = board[i].length - 1; j >= 0; j--) {
				board[i][j] = new BoardCell(game, i, j);
				BoardCell cell = board[i][j];
				cell.addActionListener(this);
				add(cell);
				cell.paintPiece();
			}
		}
		this.revalidate();
		this.repaint();
		setVisible(true);
	}

	public Piece getPieceAt(int i, int j) {
		return game.getCellAt(j, i).getPiece();
	}

	public boolean isEmpty(int i, int j) {
		return getPieceAt(i, j) == null;
	}

	public boolean isEmpty(BoardCell cell) {
		return cell.getPiece() == null;
	}

	public boolean isFriendly(Piece p) {
		return p.getOwner() == game.getCurrentPlayer();
	}

	public void selectAbility(Piece p) {
		isAbility = true;
		lightOffAvailableMoves();
		if (p instanceof Medic) {
			ArrayList<Piece> dead = p.getOwner().getDeadCharacters();
			if (dead.size() == 0) {
				resetAbilities();
				return;
			}
			Object[] graveyard = new Object[dead.size()];
			for (int i = 0; i < dead.size(); i++) {
				graveyard[i] = dead.get(i).getName();
			}
			JPanel revive = new JPanel();
			revive.add(new JLabel("Please select a dead character to revive"));
			int pos = JOptionPane.showOptionDialog(null, revive, "Medic", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, graveyard, null);

			Piece revived = dead.get(pos);
			targetPiece = revived;
			lightUpAvailableAbilityMoves();
		}
		if (p instanceof Ranged) {
			selectedRanged = true;
			lightUpAvailableAbilityMoves();
		}
		if (p instanceof Tech) {
			Object[] TechAbilities = { "Hack Enemy", "Restore ability", "Teleport" };
			JPanel abilities = new JPanel();
			abilities.add(new JLabel("Please choose a Tech ability"));
			int pos = JOptionPane.showOptionDialog(null, abilities, "Tech", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, TechAbilities, null);
			if (pos == 0)
				hackedPiece = true;
			if (pos == 1)
				restorePiece = true;
			if (pos == 2)
				teleporting = true;
		}
		if (p instanceof Super) {
			selectedSuper = true;
			lightUpAvailableAbilityMoves();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(game.toString());
		JButton sourceButton = (JButton) e.getSource();

		// Checking if ability button is pressed
		if (!(sourceButton instanceof BoardCell)) {
			if (selectedPiece == null) {
				displayMessage("You need to select a Hero to use their ability");
			} else {
				System.out.println("will select Ability");
				selectAbility(selectedPiece);
			}
			return; // stop action
		}

		BoardCell cell = (BoardCell) sourceButton;
		Piece sourcePiece = cell.getPiece();
		Point sourcePoint = new Point(cell.getJ(), cell.getI());

		// Selecting a Piece
		if (selectedPiece == null) {
			if (isEmpty(cell))
				return;
			if (isFriendly(sourcePiece)) {
				select(sourcePiece);
				System.out.println("selected: " + sourcePiece);
			} else {
				displayMessage("Can not select an enemy Piece");
				System.out.println("An enemyyyyy");
			}
			refresh();
			return; // stop action
		}

		// Doing a move or selecting another piece
		if (!isAbility) {
			System.out.println("enterd moving block");
			if (!isEmpty(cell) && isFriendly(sourcePiece)) {
				select(sourcePiece);
				System.out.println("selected again: " + sourcePiece);
			} else if (selectedPiece.isAllowdMove(sourcePoint)) {
				System.out.println("Ahe ha tmove 5alas");
				if (isEmpty(cell)) {
					doMoveAnimation();
				} else {
					doAttackAnimation();
					doMoveAnimation();
				}
				try {
					selectedPiece.move(selectedPiece.mapToMoveDirection(sourcePoint));
					System.out.println("Moved");
					reset();
				} catch (Exception ex) {
					displayMessage(ex.getMessage());
				}
			}
			refresh();
			return; // end action
		}
		System.out.println("Enterd Ability block");
		// Abilities
		if (selectedSuper) {
			Super superPiece = (Super) selectedPiece;
			if (superPiece.isAllowdAbility(sourcePoint)) {
				playSuperAnimation();
				Direction d = superPiece.mapToAbilityDirection(sourcePoint);
				try {
					superPiece.usePower(d, null, null);
					reset();
				} catch (Exception ex) {
					displayMessage(ex.getMessage());
				}
			} else {
				resetAbilities();
			}
			refresh();
			return;
		}

		if (selectedRanged) {
			Ranged rangedPiece = (Ranged) selectedPiece;
			if (rangedPiece.isAllowdAbility(sourcePoint)) {
				playRangedAnimation();
				Direction d = rangedPiece.mapToAbilityDirection(sourcePoint);
				try {
					rangedPiece.usePower(d, null, null);
					reset();
				} catch (Exception ex) {
					displayMessage(ex.getMessage());
				}
			} else {
				resetAbilities();
			}
			refresh();
			return;
		}

		if (targetPiece != null) {
			Medic medicPiece = (Medic) selectedPiece;
			if (medicPiece.isAllowdAbility(sourcePoint)) {
				playMedicAnimation();
				Direction d = medicPiece.mapToAbilityDirection(sourcePoint);
				try {
					medicPiece.usePower(d, targetPiece, null);
					reset();
				} catch (Exception ex) {
					displayMessage(ex.getMessage());
				}
			} else {
				resetAbilities();
			}
			refresh();
			return;
		}

		Tech techPiece = (Tech) selectedPiece;
		if (hackedPiece) {
			if (isEmpty(cell)) {
				resetAbilities();
				return;
			}
			if (!isFriendly(sourcePiece)) {
				try {
					techPiece.usePower(null, sourcePiece, null);
					reset();
				} catch (Exception ex) {
					displayMessage(ex.getMessage());
				}
			} else {
				displayMessage("Can not hack a Friendly Piece");
				resetAbilities();
			}
		}
		if (restorePiece) {
			if (isEmpty(cell)) {
				resetAbilities();
				return;
			}
			if (isFriendly(sourcePiece)) {
				try {
					techPiece.usePower(null, sourcePiece, null);
					reset();
				} catch (Exception ex) {
					displayMessage(ex.getMessage());
				}
			} else {
				displayMessage("Can not restore the ability of an Enemy Piece");
				resetAbilities();
			}
		}
		if(teleporting) {
			if(teleportedPiece == null) {
				if(isEmpty(cell)) {
					resetAbilities();
					return;
				}
				teleportedPiece = sourcePiece;
			} else {
				if(isEmpty(cell)) {
					try {
						techPiece.usePower(null, teleportedPiece, sourcePoint);
						reset();
					} catch(Exception ex) {
						displayMessage(ex.getMessage());
					}
				} else {
					displayMessage("You must select an empty cell");
					resetAbilities();
				}
			}
		}
		refresh();
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

	public void displayMessage(String msg) {
		// makes pop up messages
	}

	public void select(BoardCell c) {
		selectedPiece = c.getPiece();
		lightUpAvailableMoves();
	}

	public void select(Piece p) {
		selectedPiece = p;
		lightUpAvailableMoves();
	}

	public void reset() {
		selectedPiece = null;
		targetPiece = null;
		isAbility = false;
		selectedRanged = false;
		selectedSuper = false;
		hackedPiece = false;
		restorePiece = false;
		teleporting = false;
		teleportedPiece = null;
		lightOffAvailableMoves();
	}

	public void resetAbilities() {
		targetPiece = null;
		isAbility = false;
		selectedRanged = false;
		selectedSuper = false;
		hackedPiece = false;
		restorePiece = false;
		teleporting = false;
		teleportedPiece = null;
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
