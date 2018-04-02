package model.pieces.sidekicks;

import model.game.Cell;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public abstract class SideKick extends Piece {

	public SideKick(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	public void attack(Piece target) {
		super.attack(target);
		if(getGame().getCellAt(target.getPosI(), target.getPosJ()) != null)
			return;
		Player attacker = getOwner();
		Cell attackerCell = getGame().getCellAt(this.getPosI(),this.getPosJ());
		if(target instanceof Armored)
			attackerCell.setPiece(new Armored(attacker, getGame(), this.getName()));
		else if(target instanceof Medic)
			attackerCell.setPiece(new Medic(attacker, getGame(), this.getName()));
		else if(target instanceof Ranged)
			attackerCell.setPiece(new Ranged(attacker, getGame(), this.getName()));
		else if(target instanceof Super)
			attackerCell.setPiece(new Super(attacker, getGame(), this.getName()));
		else if(target instanceof Speedster)
			attackerCell.setPiece(new Speedster(attacker, getGame(), this.getName()));
		else if(target instanceof Tech)
			attackerCell.setPiece(new Tech(attacker, getGame(), this.getName()));
	}

	@Override
	public String toString() {
		return "K";
	}
}
