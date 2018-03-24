package model.pieces.heroes;

import java.awt.Point;
import java.util.ArrayList;

import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Medic extends ActivatablePowerHero {

	public Medic(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if (this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		switch (r) {
		case DOWN:
			moveDown();
			break;
		case LEFT:
			moveLeft();
			break;
		case RIGHT:
			moveRight();
			break;
		case UP:
			moveUp();
			break;
		default:
			throw new UnallowedMovementException("This move is unallowed", this, r);
		}
	}

	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, PowerAlreadyUsedException, InvalidPowerTargetException {
		if (this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		if(this.isPowerUsed())
			throw new PowerAlreadyUsedException("This power has been already used", this);
		int i = this.getPosI();
		int j = this.getPosJ();
		if (target.getOwner() != this.getOwner()) {
			throw new InvalidPowerTargetException("You can not revive an enemy", this, target);
		}
		ArrayList<Piece> tmp = this.getOwner().getDeadCharacters();
		boolean f = false;
		for (int k = 0; k < tmp.size(); k++) {
			if (target == tmp.get(k)) {
				tmp.remove(k);
				f = true;
				break;
			}
		}
		if (!f) {
			throw new InvalidPowerTargetException("You can not revive an alive friend", this, target);
		}
		if (d == Direction.DOWN) {
			i++;
			if (i == 7)
				i = 0;
		} else if (d == Direction.LEFT) {
			j--;
			if (j == -1)
				j = 5;
		} else if (d == Direction.RIGHT) {
			j++;
			if (j == 6)
				j = 0;
		} else if (d == Direction.UP) {
			i--;
			if (i == -1)
				i = 6;
		} else if (d == Direction.UPRIGHT) {
			i--;
			j++;
			if (i == -1)
				i = 6;
			if (j == 6)
				j = 0;
		} else if (d == Direction.UPLEFT) {
			i--;
			j--;
			if (i == -1)
				i = 6;
			if (j == -1)
				j = 5;
		} else if (d == Direction.DOWNLEFT) {
			i++;
			j--;
			if (i == 7)
				i = 0;
			if (j == -1)
				j = 5;
		} else if (d == Direction.DOWNRIGHT) {
			i++;
			j++;
			if (i == 7)
				i = 0;
			if (j == 6)
				j = 0;
		}
		if (getGame().getCellAt(i, j).getPiece() == null) {
			getGame().getCellAt(i, j).setPiece(target);
			if(target instanceof ActivatablePowerHero)
				((ActivatablePowerHero) target).setPowerUsed(false);
			if(target instanceof Armored)
				((Armored) target).setArmorUp(true);
			getGame().getCellAt(i, j).getPiece().setPosI(i);
			getGame().getCellAt(i, j).getPiece().setPosJ(j);
		} else
			throw new InvalidPowerTargetException("You can not revive here, it is an occupied cell", this, target);
		setPowerUsed(true);
		getGame().switchTurns();
	}

	@Override
	public String toString() {
		return "M";
	}
}
