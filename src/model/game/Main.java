package model.game;

public class Main {
	
	public static void main(String[] args) {
		Game game = new Game(new Player("P1"), new Player("P2"));
		System.out.println(game);
	}
}
