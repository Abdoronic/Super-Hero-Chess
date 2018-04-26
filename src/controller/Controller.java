package controller;

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
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import view.BoardCell;
import view.BoardPanel;
import view.InfoPanel;
import view.PayloadPanel;
import view.StartButton;
import view.StartMenu;
import view.StartPage;
import view.SuperHeroChess;

public class Controller implements ActionListener {

	private Game game;
	
	private StartPage startPage;
	private StartMenu startMenu;
	private SuperHeroChess superHeroChess;
	private BoardPanel boardPanel;
	private PayloadPanel payloadPanel;
	private InfoPanel infoPanel;

	private static Piece selectedPiece;
	private static Piece targetPiece;
	private static Piece teleportedPiece;
	private static boolean isAbility;
	private static boolean selectedRanged;
	private static boolean selectedSuper;
	private static boolean hackedPiece;
	private static boolean restorePiece;
	private static boolean teleporting;
	
	public Controller() {
		startPage = new StartPage(this);
	}
	
	public void buildGame(String player1, String player2) {
		game = new Game(new Player(player1), new Player(player2));
		superHeroChess = new SuperHeroChess(this);
		payloadPanel = superHeroChess.getPayloadPanel();
		infoPanel = superHeroChess.getInfoPanel();
		boardPanel = superHeroChess.getBoardPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		JButton sourceButton = (JButton) e.getSource();
		
		if(sourceButton instanceof StartButton) {
			startPage.dispose();
			startMenu = new StartMenu(this);
			return;
		}
		
		if(sourceButton.getActionCommand() == "Enter") {
			startMenu.dispose();
			buildGame(startMenu.getPlayer1(), startMenu.getPlayer2());
			return;
		}
		
		if(sourceButton.getActionCommand() == "Quit") {
			startMenu.dispose();
			return;
		}

		// Checking if ability button is pressed
		if (!(sourceButton instanceof BoardCell)) {
			if (selectedPiece == null) {
				superHeroChess.displayMessage("You need to select a Hero to use their ability");
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
				superHeroChess.displayMessage("Can not select an enemy Piece");
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
					boardPanel.doMoveAnimation();
				} else {
					boardPanel.doAttackAnimation();
					boardPanel.doMoveAnimation();
				}
				try {
					selectedPiece.move(selectedPiece.mapToMoveDirection(sourcePoint));
					System.out.println("Moved");
					reset();
				} catch (Exception ex) {
					superHeroChess.displayMessage(ex.getMessage());
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
				boardPanel.playSuperAnimation();
				Direction d = superPiece.mapToAbilityDirection(sourcePoint);
				try {
					superPiece.usePower(d, null, null);
					reset();
				} catch (Exception ex) {
					superHeroChess.displayMessage(ex.getMessage());
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
				boardPanel.playRangedAnimation();
				Direction d = rangedPiece.mapToAbilityDirection(sourcePoint);
				try {
					rangedPiece.usePower(d, null, null);
					reset();
				} catch (Exception ex) {
					superHeroChess.displayMessage(ex.getMessage());
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
				boardPanel.playMedicAnimation();
				Direction d = medicPiece.mapToAbilityDirection(sourcePoint);
				try {
					medicPiece.usePower(d, targetPiece, null);
					reset();
				} catch (Exception ex) {
					superHeroChess.displayMessage(ex.getMessage());
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
					superHeroChess.displayMessage(ex.getMessage());
				}
			} else {
				superHeroChess.displayMessage("Can not hack a Friendly Piece");
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
					superHeroChess.displayMessage(ex.getMessage());
				}
			} else {
				superHeroChess.displayMessage("Can not restore the ability of an Enemy Piece");
				resetAbilities();
			}
		}
		if (teleporting) {
			if (teleportedPiece == null) {
				if (isEmpty(cell)) {
					resetAbilities();
					return;
				}
				teleportedPiece = sourcePiece;
			} else {
				if (isEmpty(cell)) {
					try {
						techPiece.usePower(null, teleportedPiece, sourcePoint);
						reset();
					} catch (Exception ex) {
						superHeroChess.displayMessage(ex.getMessage());
					}
				} else {
					superHeroChess.displayMessage("You must select an empty cell");
					resetAbilities();
				}
			}
		}
		refresh();
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

	public void select(BoardCell c) {
		selectedPiece = c.getPiece();
		boardPanel.lightUpAvailableMoves();
	}

	public void select(Piece p) {
		selectedPiece = p;
		boardPanel.lightUpAvailableMoves();
	}

	public void selectAbility(Piece p) {
		if(!(p instanceof ActivatablePowerHero))
			return;
		if(((ActivatablePowerHero)p).isPowerUsed()) {
			superHeroChess.displayMessage("Hero Already Used Their Ability");
			return;
		}
		isAbility = true;
		boardPanel.lightOffAvailableMoves();
		if (p instanceof Medic) {
			ArrayList<Piece> dead = p.getOwner().getDeadCharacters();
			if (dead.size() == 0) {
				superHeroChess.displayMessage("No Characters To Revive");
				resetAbilities();
				return;
			}
			Object[] graveyard = new Object[dead.size()];
			for (int i = 0; i < dead.size(); i++) {
				graveyard[i] = dead.get(i).getName();
			}
			JPanel revive = new JPanel();
			revive.add(new JLabel("Please select a dead character to revive"));
			int pos = JOptionPane.showOptionDialog(superHeroChess, revive, "Medic", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, graveyard, null);
			if (pos == JOptionPane.CLOSED_OPTION) {
				resetAbilities();
	            return;
	        }
			Piece revived = dead.get(pos);
			targetPiece = revived;
			boardPanel.lightUpAvailableAbilityMoves();
		}
		if (p instanceof Ranged) {
			selectedRanged = true;
			boardPanel.lightUpAvailableAbilityMoves();
		}
		if (p instanceof Tech) {
			Object[] TechAbilities = { "Hack Enemy", "Restore ability", "Teleport" };
			JPanel abilities = new JPanel();
			abilities.add(new JLabel("Please choose a Tech ability"));
			int pos = JOptionPane.showOptionDialog(superHeroChess, abilities, "Tech", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, TechAbilities, null);
			if (pos == 0)
				hackedPiece = true;
			if (pos == 1)
				restorePiece = true;
			if (pos == 2)
				teleporting = true;
			if (pos == JOptionPane.CLOSED_OPTION) {
				resetAbilities();
	            return;
	        }
		}
		if (p instanceof Super) {
			selectedSuper = true;
			boardPanel.lightUpAvailableAbilityMoves();
		}
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
		boardPanel.lightOffAvailableMoves();
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
	
	public void refresh() {
		boardPanel.refresh();
		if(game.getPlayer1().getPayloadPos() >= 6) {
			superHeroChess.displayMessage(game.getPlayer1().getName() + " Won!");
			superHeroChess.setVisible(false);
			superHeroChess.dispose();
			startMenu = new StartMenu(this);
		} else if (game.getPlayer2().getPayloadPos() >= 6) {
			superHeroChess.displayMessage(game.getPlayer2().getName() + " Won!");
			superHeroChess.setVisible(false);
			superHeroChess.dispose();
			startMenu = new StartMenu(this);
		}
	}

	public Game getGame() {
		return game;
	}
	
	public static Piece getSelectedPiece() {
		return selectedPiece;
	}

	public static void main(String[] args) {
		new Controller();
	}

}
