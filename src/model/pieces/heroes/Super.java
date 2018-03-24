package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Super extends ActivatablePowerHero {

	public Super(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		switch(r) {
		case DOWN : moveDown(); break;
		case LEFT : moveLeft(); break;
		case RIGHT : moveRight(); break;
		case UP : moveUp(); break;
		default : throw new UnallowedMovementException("This move is unallowed", this, r); 
		}
		
	}
    
	public boolean isValidPower(int i, int j) {
		 if(i < 0 || i > 6 || j < 0 || j > 5)
			 return false;
		 Piece p = getGame().getCellAt(i, j).getPiece();
		 if(p == null || p.getOwner() == this.getOwner())
			 return false;
		 return true;
	}
	
	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, PowerAlreadyUsedException, InvalidPowerDirectionException {
		if(this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		if(this.isPowerUsed())
			throw new PowerAlreadyUsedException("This power has been already used", this);
		int i = this.getPosI();  int j = this.getPosJ();
	   if(d == Direction.DOWN) {
		   if(isValidPower(i+1, j))
			   attack(getGame().getCellAt(i+1, j).getPiece());
		   if(isValidPower(i+2, j))
			   attack(getGame().getCellAt(i+2, j).getPiece());
	   } else if(d == Direction.LEFT) {
		   if(isValidPower(i, j-1))
			   attack(getGame().getCellAt(i, j-1).getPiece());
		   if(isValidPower(i, j-2))
			   attack(getGame().getCellAt(i, j-2).getPiece());
		   
	   } else if(d == Direction.RIGHT) {
		   if(isValidPower(i, j+1))
 			   attack(getGame().getCellAt(i, j+1).getPiece());
		   if(isValidPower(i, j+2))
			   attack(getGame().getCellAt(i, j+2).getPiece());		   
	   } else if(d == Direction.UP) {
		   if(isValidPower(i-1, j))
			   attack(getGame().getCellAt(i-1, j).getPiece());
		   if(isValidPower(i-2, j))
			   attack(getGame().getCellAt(i-2, j).getPiece());
	   } else {
		   throw new InvalidPowerDirectionException("You can't apply the ability diagonaly", this, d);
	   }
	   setPowerUsed(true);
	   getGame().switchTurns();
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
