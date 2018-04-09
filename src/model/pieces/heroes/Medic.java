package model.pieces.heroes;

import java.awt.Point;
import java.util.ArrayList;

import exceptions.InvalidPowerDirectionException;
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
		Direction[] allowedMoves = { Direction.DOWN, Direction.LEFT, Direction.RIGHT, Direction.UP };
		move(1, r, allowedMoves);
	}

	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, PowerAlreadyUsedException, InvalidPowerTargetException, InvalidPowerDirectionException {
		super.usePower(d, target, newPos);
		int i = this.getPosI();
		int j = this.getPosJ();
		if (!isFriendly(target))
			throw new InvalidPowerTargetException("You can not revive an enemy", this, target);
		ArrayList<Piece> deadHeroes = this.getOwner().getDeadCharacters();
		boolean dead = false;
		int deadCharacterIdx = -1;
		for (int k = 0; k < deadHeroes.size(); k++)
			if (target == deadHeroes.get(k)) {
				deadCharacterIdx = k;
				dead = true;
				break;
			}
		if (!dead)
			throw new InvalidPowerTargetException("You can not revive an alive friend", this, target);
		Point p = getMoveLocation(i, j, 1, d, true);
		i = p.x;
		j = p.y;
		if (isEmptyCell(i, j)) {
			getGame().getCellAt(i, j).setPiece(target);
			deadHeroes.remove(deadCharacterIdx);
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
