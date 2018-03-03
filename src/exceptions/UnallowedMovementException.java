package exceptions;

import model.game.Direction;
import model.pieces.Piece;

public class UnallowedMovementException extends InvalidMovementException {

	public UnallowedMovementException() {
		
	}
	
	public UnallowedMovementException(Piece trigger, Direction direction) {
		super(trigger, direction);
	}
	
	public UnallowedMovementException(String s, Piece trigger, Direction direction) {
		super(s, trigger, direction);
	}
	

}
