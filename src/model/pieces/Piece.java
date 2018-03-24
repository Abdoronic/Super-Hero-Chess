package model.pieces;

import model.game.Game;
import model.game.Player;
import model.pieces.heroes.Armored;
import model.pieces.sidekicks.SideKick;

public abstract class Piece implements Movable {

	private String name;
	private Player owner;
	private Game game;
	private int posI;
	private int posJ;
    
	
	public Piece(Player p, Game g, String name) {
		this.owner = p;
		this.game = g;
		this.name = name;
	}
	
	public void attack(Piece target) {
		Player attacked = target.getOwner();
		Player attacker = game.getCurrentPlayer();
		if(target instanceof SideKick) {
	       	attacker.setSideKilled(attacker.getSideKilled() + 1);
	       	if(attacker.getSideKilled() % 2 == 0)
	       		attacker.setPayloadPos(attacker.getPayloadPos() + 1);
	       	game.getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
		} else if(target instanceof Armored && ((Armored) target).isArmorUp()) {
			((Armored) target).setArmorUp(false);
		} else {
			attacked.getDeadCharacters().add(target);
	       	attacker.setPayloadPos(attacker.getPayloadPos() + 1);
	       	game.getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
		}
		game.checkWinner();
	}

	public String getName() {
		return name;
	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int i) {
		posI = i;
	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosJ(int j) {
		posJ = j;
	}

	public Game getGame() {
		return game;
	}

	public Player getOwner() {
		return owner;
	}

}
