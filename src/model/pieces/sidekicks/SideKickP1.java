package model.pieces.sidekicks;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;

public class SideKickP1 extends SideKick {

	public SideKickP1(Game game, String name) {
		super(game.getPlayer1(), game, name);
	}
	
	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException{
		if(this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		switch(r) {
		case LEFT : moveLeft(); break;
		case RIGHT : moveRight(); break;
		case UP : moveUp(); break;
		case UPLEFT : moveUpLeft(); break;
		case UPRIGHT : moveUpRight(); break;
		default : throw new UnallowedMovementException("This move is unallowed", this, r);
		}
		
	}

}
