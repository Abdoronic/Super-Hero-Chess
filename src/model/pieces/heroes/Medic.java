package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Medic extends ActivatablePowerHero{
	public Medic() {
		
	}
	
	public Medic(Player player, Game game, String name, boolean powerUsed) {
		super(player,  game,  name, powerUsed);
	}
}
