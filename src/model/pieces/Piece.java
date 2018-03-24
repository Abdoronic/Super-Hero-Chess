package model.pieces;

import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.heroes.Armored;
import model.pieces.sidekicks.SideKick;

public abstract class Piece implements Movable {

	private String name;
	private Player owner;
	private Game game;
	private int posI;
	private int posJ;

	public Piece(Player p, Game g, String name) {
		this.owner = p;
		this.game = g;
		this.name = name;
	}

	public void attack(Piece target) {
		Player attacked = target.getOwner();
		Player attacker = game.getCurrentPlayer();
		if (target instanceof SideKick) {
			attacker.setSideKilled(attacker.getSideKilled() + 1);
			if (attacker.getSideKilled() % 2 == 0)
				attacker.setPayloadPos(attacker.getPayloadPos() + 1);
			game.getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
		} else if (target instanceof Armored && ((Armored) target).isArmorUp()) {
			((Armored) target).setArmorUp(false);
		} else {
			attacked.getDeadCharacters().add(target);
			attacker.setPayloadPos(attacker.getPayloadPos() + 1);
			game.getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
		}
		game.checkWinner();
	}

	private void helperMove(int oldI, int oldJ, int i, int j) {
		if (game.getCellAt(i, j).getPiece() == null) {
			game.getCellAt(i, j).setPiece(this);
			game.getCellAt(oldI, oldJ).setPiece(null);
			this.setPosI(i);
			this.setPosJ(j);
		} else if (game.getCellAt(i, j).getPiece().getOwner() == this.getOwner()) {
			// exception friendly so u understand
		} else {
			attack(game.getCellAt(i, j).getPiece());
			if (game.getCellAt(i, j).getPiece() == null) {
				game.getCellAt(i, j).setPiece(this);
				game.getCellAt(oldI, oldJ).setPiece(null);
				this.setPosI(i);
				this.setPosJ(j);
			}
		}
		game.switchTurns();
	}

	public void moveDown() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i++;
		if (i == 7)
			i = 0;
		helperMove(oldI, oldJ, i, j);
	}

	public void moveDownLeft() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i++;
		j--;
		if (i == 7)
			i = 0;
		if (j == -1)
			j = 5;
		helperMove(oldI, oldJ, i, j);
	}

	public void moveDownRight() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i++;
		j++;
		if (i == 7)
			i = 0;
		if (j == 6)
			j = 0;
		helperMove(oldI, oldJ, i, j);
	}

	public void moveLeft() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		j--;
		if (j == -1)
			j = 5;
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveRight() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		j++;
		if (j == 6)
			j = 0;
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveUp() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i--;
		if (i == -1)
			i = 6;
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveUpLeft() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i--;
		j--;
		if (i == -1)
			i = 6;
		if (j == -1)
			j = 5;
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveUpRight() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i--;
		j++;
		if (i == -1)
			i = 6;
		if (j == 6)
			j = 0;
		helperMove(oldI, oldJ, i, j);
	}
	
	public String getName() {
		return name;
	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int i) {
		posI = i;
	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosJ(int j) {
		posJ = j;
	}

	public Game getGame() {
		return game;
	}

	public Player getOwner() {
		return owner;
	}

}
