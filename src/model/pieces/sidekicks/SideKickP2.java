package model.pieces.sidekicks;

import model.game.Game;
import model.game.Player;

public class SideKickP2 extends SideKick {

	public SideKickP2() {

	}

	public SideKickP2(Game game, String name) {
		super(game.getPlayer2(), game, name);
	}

}
