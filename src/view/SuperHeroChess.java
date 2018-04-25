package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
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
		PayloadPanel payloadPanel = new PayloadPanel();
		InfoPanel infoPanel = new InfoPanel();
		BoardPanel boardPanel = new BoardPanel(game, infoPanel, payloadPanel);
		
		JButton abilityButton = new JButton("Ability");
		abilityButton.addActionListener(boardPanel);
		infoPanel.add(abilityButton);
		
		add(payloadPanel, BorderLayout.NORTH);
		add(boardPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SuperHeroChess(new Game(new Player("P1"), new Player("P2")));
	}
}
