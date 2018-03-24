package model.game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game(new Player("Ronic"), new Player("Abdo"));
		game.assemblePieces();
		System.out.println(game);
	}
}
