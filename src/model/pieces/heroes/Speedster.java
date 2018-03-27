package model.pieces.heroes;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Speedster extends NonActivatablePowerHero {

	public Speedster(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		Direction[] allowedMoves = { Direction.DOWN, Direction.DOWNLEFT, Direction.DOWNRIGHT, Direction.LEFT,
				Direction.RIGHT, Direction.UP, Direction.UPLEFT, Direction.UPRIGHT };
		move(2, r, allowedMoves);
	}

	@Override
	public String toString() {
		return "S";
	}
}
