package exceptions;

import model.pieces.Piece;

public class PowerAlreadyUsedException extends InvalidPowerUseException{
	
	public PowerAlreadyUsedException() {
		
	}
	
	public PowerAlreadyUsedException(Piece trigger) {
		super(trigger);
	}
	
	public PowerAlreadyUsedException(String s, Piece trigger) {
		super(s, trigger);
	}
}
