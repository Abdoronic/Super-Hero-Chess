package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Tech extends ActivatablePowerHero{
	public Tech() {
		
	}
	public Tech(Player player, Game game, String name) {
		super(player,  game,  name);
	}
	
	public Tech(Player player, Game game, String name, boolean powerUsed) {
		super(player,  game,  name, powerUsed);
	}
}
