package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Ranged extends ActivatablePowerHero {

	public Ranged(Player player, Game game, String name) {
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
		case DOWNLEFT:
			moveDownLeft();
			break;
		case DOWNRIGHT:
			moveDownRight();
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
		case UPLEFT:
			moveUpLeft();
			break;
		case UPRIGHT:
			moveUpRight();
			break;
		default:
			throw new UnallowedMovementException("This move is unallowed", this, r);
		}

	}

	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, PowerAlreadyUsedException, InvalidPowerDirectionException {
		if (this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		if(this.isPowerUsed())
			throw new PowerAlreadyUsedException("This power has been already used", this);
		int i = this.getPosI();
		int j = this.getPosJ();
		Piece p = null;
		if (d == Direction.DOWN) {
			for (int k = i+1; k < 7; k++) {
				p = getGame().getCellAt(k, j).getPiece();
				if (p != null)
					break;
			}
		} else if (d == Direction.UP) {
			for (int k = i-1; k > -1; k--) {
				p = getGame().getCellAt(k, j).getPiece();
				if (p != null)
					break;
			}
		} else if (d == Direction.LEFT) {
			for (int k = j-1; k > -1; k--) {
				p = getGame().getCellAt(i, k).getPiece();
				if (p != null)
					break;
			}
		} else if (d == Direction.RIGHT) {
			for (int k = j+1; k < 6; k++) {
				p = getGame().getCellAt(i, k).getPiece();
				if (p != null)
					break;
			}
		} else {
			throw new InvalidPowerDirectionException("You can't attack diagnoally", this, d);
		}
		if (p == null) {
			throw new InvalidPowerDirectionException("You can't attack Empty cells", this, d);
		} else {
			if (p.getOwner() == this.getOwner()) {
				throw new InvalidPowerDirectionException("You can't attack a friend", this, d);
			} else {
				attack(p);
				setPowerUsed(true);
				getGame().switchTurns();
			}
		}

	}

	public String toString() {
		return "R";
	}

}
