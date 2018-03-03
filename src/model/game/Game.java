package model.game;

public class Game {
	
	private final int payloadPosTarget = 6;
	private final int boardWidth = 6;
	private final int boardHeight = 7;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Cell[][] board;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
		this.board = new Cell[boardHeight][boardWidth];
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getPayloadPosTarget() {
		return payloadPosTarget;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	
}
