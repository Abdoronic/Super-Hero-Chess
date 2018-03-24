package model.pieces.heroes;

import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Tech extends ActivatablePowerHero {

	public Tech(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	@Override
	public void move(Direction r) {
		switch(r) {		
		case DOWNLEFT : moveDownLeft(); break;
		case DOWNRIGHT : moveDownRight(); break;
		case UPLEFT : moveUpLeft(); break;
		case UPRIGHT : moveUpRight(); break;
		default : break;//throw Exception 
		}
		
	}


	@Override
	public String toString() {
		return "T";
	}
}
