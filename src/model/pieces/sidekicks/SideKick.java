package model.pieces.sidekicks;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public abstract class SideKick extends Piece {

	public SideKick(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public String toString() {
		return "K";
	}
}
