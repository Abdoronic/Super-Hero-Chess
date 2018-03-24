package model.pieces.heroes;

import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Super extends ActivatablePowerHero {

	public Super(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public void move(Direction r) {
		switch(r) {
		case DOWN : moveDown(); break;
		case LEFT : moveLeft(); break;
		case RIGHT : moveRight(); break;
		case UP : moveUp(); break;
		default : break;//throw Exception 
		}
		
	}
}
