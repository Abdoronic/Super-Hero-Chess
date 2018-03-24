package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Tech extends ActivatablePowerHero {

	public Tech(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "T";
	}
}
