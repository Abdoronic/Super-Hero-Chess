package model.pieces.heroes;

import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Medic extends ActivatablePowerHero {

	public Medic(Player player, Game game, String name) {
		super(player, game, name);
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
	
	@Override
	public String toString() {
		return "M";
	}
}
