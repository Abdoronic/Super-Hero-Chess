package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Ranged extends ActivatablePowerHero {

	public Ranged(Player player, Game game, String name) {
		super(player, game, name);
	}

	public String toString() {
		return "R";
	}
}
