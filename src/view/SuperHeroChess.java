package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.game.Game;
import model.game.Player;

@SuppressWarnings("serial")
public class SuperHeroChess extends JFrame{
	
//	private Game game;
	final static int WIDTH = 1280;
	final static int HEIGHT = 720;
	final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public SuperHeroChess(Game game) {
//		this.game = game;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Super Hero Chess");
		setBounds(SCREEN_WIDTH/2 - WIDTH/2, SCREEN_HEIGHT/2 - HEIGHT/2, WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		add(new PayloadPanel(), BorderLayout.NORTH);
		add(new BoardPanel(game), BorderLayout.CENTER);
		add(new InfoPanel(), BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SuperHeroChess(new Game(new Player("P1"), new Player("P2")));
	}
}
