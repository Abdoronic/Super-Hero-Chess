package model.pieces.heroes;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Speedster extends NonActivatablePowerHero {

	public Speedster(Player player, Game game, String name) {
		super(player, game, name);
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
		default :throw new UnallowedMovementException("This move is unallowed", this, r);
		}
	}
    
	private void helperMove(int oldI, int oldJ, int i, int j, Direction r) throws OccupiedCellException {
		if (getGame().getCellAt(i, j).getPiece() == null) {
			getGame().getCellAt(i, j).setPiece(this);
			getGame().getCellAt(oldI, oldJ).setPiece(null);
			this.setPosI(i);
			this.setPosJ(j);
		} else if (getGame().getCellAt(i, j).getPiece().getOwner() == this.getOwner()) {
			throw new OccupiedCellException("This an Occupied Cell by a friendly", this, r);
		} else {
			attack(getGame().getCellAt(i, j).getPiece());
			if (getGame().getCellAt(i, j).getPiece() == null) {
				getGame().getCellAt(i, j).setPiece(this);
				getGame().getCellAt(oldI, oldJ).setPiece(null);
				this.setPosI(i);
				this.setPosJ(j);
			}
		}
		getGame().switchTurns();
	}

	public void moveDown() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i+=2;
		if (i == 7)
			i = 0;
	    if(i==8)
			i=1;
		helperMove(oldI, oldJ, i, j, Direction.DOWN);
	}

	public void moveDownLeft() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i+=2;
		j-=2;
		if (i == 7)
			i = 0;
		if (i == 8)
			i = 1;
		
		if (j == -1)
			j = 5;
		if (j == -2)
			j = 4;
		
		helperMove(oldI, oldJ, i, j, Direction.DOWNLEFT);
	}

	public void moveDownRight() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i+=2;
		j+=2;
		if (i == 7)
			i = 0;
		if (i == 8)
			i = 1;
		
		if (j == 6)
			j = 0;
		if (j == 7)
			j = 1;
		helperMove(oldI, oldJ, i, j, Direction.DOWNRIGHT);
	}

	public void moveLeft() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		j-=2;
		if (j == -1)
			j = 5;
		if (j == -2)
			j = 4;
		
		helperMove(oldI, oldJ, i, j, Direction.LEFT);
	}
	
	public void moveRight() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		j+=2;
		if (j == 6)
			j = 0;
		if (j == 7)
			j = 1;
		helperMove(oldI, oldJ, i, j, Direction.RIGHT);
	}
	
	public void moveUp() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i-=2;
		if (i == -1)
			i = 6;
		if (i == -2)
			i = 5;
		helperMove(oldI, oldJ, i, j, Direction.UP);
	}
	
	public void moveUpLeft() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i-=2;
		j-=2;
		if (i == -1)
			i = 6;
		if (i == -2)
			i = 5;
		if (j == -1)
			j = 5;
		if (j == -2)
			j = 4;
		helperMove(oldI, oldJ, i, j, Direction.UPLEFT);
	}
	
	public void moveUpRight() throws OccupiedCellException {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i-=2;
		j+=2;
		if (i == -1)
			i = 6;
		if (i == -2)
			i = 5;
		if (j == 6)
			j = 0;
		if (j == 7)
			j = 1;
		helperMove(oldI, oldJ, i, j, Direction.UPRIGHT);
	}

	@Override
	public String toString() {
		return "S";
	}
}
