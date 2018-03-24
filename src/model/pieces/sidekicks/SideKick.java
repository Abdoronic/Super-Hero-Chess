package model.pieces.sidekicks;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;

public abstract class SideKick extends Piece {

	public SideKick(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	public void attack(Piece target) {
		Player attacked = target.getOwner();
		Player attacker = getGame().getCurrentPlayer();
		if(target instanceof SideKick) {
	       	attacker.setSideKilled(attacker.getSideKilled() + 1);
	       	if(attacker.getSideKilled() % 2 == 0)
	       		attacker.setPayloadPos(attacker.getPayloadPos() + 1);
	       	getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
		} else if(target instanceof Armored && ((Armored) target).isArmorUp()) {
			((Armored) target).setArmorUp(false);
		} else {
			attacked.getDeadCharacters().add(target);
	       	attacker.setPayloadPos(attacker.getPayloadPos() + 1);
	       	getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
	       	getGame().getCellAt(this.getPosI(),this.getPosJ()).setPiece(null);
		}
		getGame().checkWinner();
	}

	@Override
	public String toString() {
		return "K";
	}
}
