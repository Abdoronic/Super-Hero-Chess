package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Tech extends ActivatablePowerHero {

	public Tech(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		switch(r) {		
		case DOWNLEFT : moveDownLeft(); break;
		case DOWNRIGHT : moveDownRight(); break;
		case UPLEFT : moveUpLeft(); break;
		case UPRIGHT : moveUpRight(); break;
		default : throw new UnallowedMovementException("This move is unallowed", this, r);
		}
		
	}

	@Override
	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, PowerAlreadyUsedException, InvalidPowerTargetException {
		if(this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		if(this.isPowerUsed())
			throw new PowerAlreadyUsedException("This power has been already used", this);
		if(newPos != null) {
			if(this.getOwner() != target.getOwner())
				throw new InvalidPowerTargetException("You can't teleport an enemy", this, target);
			if(getGame().getCellAt(newPos.x, newPos.y).getPiece() == null) {
				getGame().getCellAt(newPos.x, newPos.y).setPiece(target);
				int oldI = target.getPosI();
				int oldJ = target.getPosJ();
				target.setPosI(newPos.x);
				target.setPosJ(newPos.y);
				getGame().getCellAt(oldI, oldJ).setPiece(null);
			} else {
				throw new InvalidPowerTargetException("This cell is Occuiped you can't teleport", this, target);
			}
		} else if(target.getOwner() != this.getOwner()){
			if(target instanceof ActivatablePowerHero && ((ActivatablePowerHero)target).isPowerUsed() == false)
				((ActivatablePowerHero)target).setPowerUsed(true);
		} else {
			if(target instanceof ActivatablePowerHero && ((ActivatablePowerHero)target).isPowerUsed() == true)
				((ActivatablePowerHero)target).setPowerUsed(false);
		}
		
	}

	@Override
	public String toString() {
		return "T";
	}

}
