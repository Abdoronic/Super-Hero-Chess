package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Armored extends NonActivatablePowerHero {
	private boolean armorUp = true;

	public Armored() {

	}

	public Armored(Player player, Game game, String name) {
		super(player, game, name);
	}

	public boolean isArmorUp() {
		return armorUp;
	}

	public void setArmorUp(boolean armorUp) {
		this.armorUp = armorUp;
	}
}
