package model.pieces.heroes;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Armored extends NonActivatablePowerHero {

	private boolean armorUp;

	public Armored(Player player, Game game, String name) {
		super(player, game, name);
		this.armorUp = true;
	}

	public boolean isArmorUp() {
		return armorUp;
	}

	public void setArmorUp(boolean armorUp) {
		this.armorUp = armorUp;
	}
    
	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException("That is not your turn", this);
		switch(r) {
		case DOWN : moveDown(); break;
		case DOWNLEFT : moveDownLeft(); break;
		case DOWNRIGHT : moveDownRight(); break;
		case LEFT : moveLeft(); break;
		case RIGHT : moveRight(); break;
		case UP : moveUp(); break;
		case UPLEFT : moveUpLeft(); break;
		case UPRIGHT : moveUpRight(); break;
		default : throw new UnallowedMovementException("This move is unallowed", this, r);
		}
		
	}

	
	@Override
	public String toString() {
		return "A";
	}

}
