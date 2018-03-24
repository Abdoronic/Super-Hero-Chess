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
		Player attacked = target.getOwner();
		Player attacker = getGame().getCurrentPlayer();
		boolean wasArmored = false;
		if(target instanceof SideKick) {
	       	attacker.setSideKilled(attacker.getSideKilled() + 1);
	       	if(attacker.getSideKilled() % 2 == 0)
	       		attacker.setPayloadPos(attacker.getPayloadPos() + 1);
	       	getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
		} else if(target instanceof Armored && ((Armored) target).isArmorUp()) {
			((Armored) target).setArmorUp(false);
			wasArmored = true;
		} else {
			attacked.getDeadCharacters().add(target);
	       	attacker.setPayloadPos(attacker.getPayloadPos() + 1);
	       	Cell attackerCell = getGame().getCellAt(this.getPosI(),this.getPosJ());
	       	if(target instanceof Armored)
	       		attackerCell.setPiece(new Armored(attacker, getGame(), (attacker == getGame().getPlayer1())? "A1" : "A2"));
	       	else if(target instanceof Medic)
	       		attackerCell.setPiece(new Medic(attacker, getGame(), (attacker == getGame().getPlayer1())? "M1" : "M2"));
	       	else if(target instanceof Ranged)
	       		attackerCell.setPiece(new Ranged(attacker, getGame(), (attacker == getGame().getPlayer1())? "R1" : "R2"));
	       	else if(target instanceof Super)
	       		attackerCell.setPiece(new Super(attacker, getGame(), (attacker == getGame().getPlayer1())? "P1" : "P2"));
	       	else if(target instanceof Speedster)
	       		attackerCell.setPiece(new Speedster(attacker, getGame(), (attacker == getGame().getPlayer1())? "S1" : "S2"));
	       	else if(target instanceof Tech)
	       		attackerCell.setPiece(new Tech(attacker, getGame(), (attacker == getGame().getPlayer1())? "T1" : "T2"));
	       	getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
		}
		if(!wasArmored)
			getGame().checkWinner();
	}

	@Override
	public String toString() {
		return "K";
	}
}
