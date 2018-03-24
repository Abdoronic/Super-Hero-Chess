package model.pieces.heroes;

import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Ranged extends ActivatablePowerHero {

	public Ranged(Player player, Game game, String name) {
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
	
	public String toString() {
		return "R";
	}
	
}
