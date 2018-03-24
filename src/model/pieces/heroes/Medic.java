package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Medic extends ActivatablePowerHero {

	public Medic(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "M";
	}
}
