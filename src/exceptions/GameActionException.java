package exceptions;

import model.pieces.Piece;

public abstract class GameActionException extends Exception {
	private Piece trigger;
	
	public GameActionException() {
		
	}
	
	public GameActionException(Piece trigger) {
		this.trigger = trigger;
	}
	
	public GameActionException(String s, Piece trigger) {
		super(s);
		this.trigger = trigger;
	}
	
	public Piece getTrigger() {
		return trigger;
	}
}
