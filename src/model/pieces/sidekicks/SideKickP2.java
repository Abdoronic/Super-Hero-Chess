package model.pieces.sidekicks;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;

public class SideKickP2 extends SideKick {

	public SideKickP2(Game game, String name) {
		super(game.getPlayer2(), game, name);
	}

	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		Direction[] allowedMoves = { Direction.DOWN, Direction.DOWNLEFT, Direction.DOWNRIGHT, Direction.LEFT,
				Direction.RIGHT };
		move(1, r, allowedMoves);
	}
}
