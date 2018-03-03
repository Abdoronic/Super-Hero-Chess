package exceptions;

import model.pieces.Piece;

public class WrongTurnException extends GameActionException {
	
	public WrongTurnException() {
		
	}
	
	public WrongTurnException(Piece trigger) {
		super(trigger);
	}
	
	public WrongTurnException(String s, Piece trigger) {
		super(s, trigger);
	}
}
