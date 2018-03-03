package exceptions;

import model.pieces.Piece;

public abstract class InvalidPowerUseException extends GameActionException {
	
	public InvalidPowerUseException() {
		
	}
	
	public InvalidPowerUseException(Piece trigger) {
		super(trigger);
	}
	
	public InvalidPowerUseException(String s, Piece trigger) {
		super(s, trigger);
	}
}
