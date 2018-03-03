package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public abstract class ActivatablePowerHero extends Hero {
	private boolean powerUsed;
	public ActivatablePowerHero() {
		
	}
	
	public ActivatablePowerHero(Player player, Game game, String name, boolean powerUsed) {
		super(player,  game,  name);
		this.powerUsed=powerUsed;
	}
	
	public boolean isPowerUsed() {
		return powerUsed;
	}

	public void setPowerUsed(boolean powerUsed) {
		this.powerUsed = powerUsed;
	}

	
}
