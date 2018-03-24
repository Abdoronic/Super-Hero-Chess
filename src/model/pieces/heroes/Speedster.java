package model.pieces.heroes;

import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Speedster extends NonActivatablePowerHero {

	public Speedster(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	@Override
	public void move(Direction r) {
		switch(r) {
		case DOWN : moveDown(); break;
		case DOWNLEFT : moveDownLeft(); break;
		case DOWNRIGHT : moveDownRight(); break;
		case LEFT : moveLeft(); break;
		case RIGHT : moveRight(); break;
		case UP : moveUp(); break;
		case UPLEFT : moveUpLeft(); break;
		case UPRIGHT : moveUpRight(); break;
		default : break;//throw Exception 
		}
		
	}
    
	private void helperMove(int oldI, int oldJ, int i, int j) {
		if (getGame().getCellAt(i, j).getPiece() == null) {
			getGame().getCellAt(i, j).setPiece(this);
			getGame().getCellAt(oldI, oldJ).setPiece(null);
			this.setPosI(i);
			this.setPosJ(j);
		} else if (getGame().getCellAt(i, j).getPiece().getOwner() == this.getOwner()) {
			// exception friendly so u understand
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

	public void moveDown() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i+=2;
		if (i == 7)
			i = 0;
	    if(i==8)
			i=1;
		helperMove(oldI, oldJ, i, j);
	}

	public void moveDownLeft() {
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
		
		helperMove(oldI, oldJ, i, j);
	}

	public void moveDownRight() {
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
		helperMove(oldI, oldJ, i, j);
	}

	public void moveLeft() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		j-=2;
		if (j == -1)
			j = 5;
		if (j == -2)
			j = 4;
		
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveRight() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		j+=2;
		if (j == 6)
			j = 0;
		if (j == 7)
			j = 1;
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveUp() {
		int oldI = getPosI();
		int oldJ = getPosJ();
		int i = getPosI();
		int j = getPosJ();
		i-=2;
		if (i == -1)
			i = 6;
		if (i == -2)
			i = 5;
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveUpLeft() {
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
		helperMove(oldI, oldJ, i, j);
	}
	
	public void moveUpRight() {
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
		helperMove(oldI, oldJ, i, j);
	}

	@Override
	public String toString() {
		return "S";
	}
}
