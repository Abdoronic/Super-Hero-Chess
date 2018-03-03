package exceptions;

import model.game.Direction;
import model.pieces.Piece;

public abstract class InvalidMovementException extends GameActionException {
	private Direction direction;
	
	public InvalidMovementException() {
		
	}
	public InvalidMovementException(Piece trigger, Direction direction) {
		super(trigger);
		this.direction=direction;
	}
	
	public InvalidMovementException(String s, Piece trigger, Direction direction) {
		super( s, trigger );
		this.direction=direction;
	}
}
