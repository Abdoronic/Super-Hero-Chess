package model.pieces.sidekicks;

import model.game.Game;
import model.game.Player;

public class SideKickP1 extends SideKick {

	public SideKickP1() {

	}

	public SideKickP1(Game game, String name) {
		super(game.getPlayer1(), game, name);
	}

}
