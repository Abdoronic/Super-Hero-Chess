package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Super extends ActivatablePowerHero{
	public Super() {
		
	}
	public Super(Player player, Game game, String name) {
		super(player,  game,  name);
	}
	
	public Super(Player player, Game game, String name, boolean powerUsed) {
		super(player,  game,  name, powerUsed);
	}
}
