package model.pieces;

import model.game.Game;
import model.game.Player;

public abstract class Piece implements Movable {
	private String name;
	private Player owner;
	private Game game;
	private int posI;
	private int posJ;

	public Piece() {

	}

	public Piece(Player player, Game game, String name) {
		this.owner = player;
		this.game = game;
		this.name = name;
	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int posI) {
		this.posI = posI;
	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosJ(int posJ) {
		this.posJ = posJ;
	}

	public String getName() {
		return name;
	}

	public Player getOwner() {
		return owner;
	}

	public Game getGame() {
		return game;
	}
}
