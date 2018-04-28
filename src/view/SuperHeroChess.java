package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;

@SuppressWarnings("serial")
public class SuperHeroChess extends JFrame{
	
	private PayloadPanel payloadPanel;
	private InfoPanel infoPanel;
	private BoardPanel boardPanel;
	
	final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
		
	public SuperHeroChess(Controller controller) {
		setTitle("Super Hero Chess");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setBounds(SCREEN_WIDTH/2 - WIDTH/2, SCREEN_HEIGHT/2 - HEIGHT/2, WIDTH, HEIGHT);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		setUndecorated(true);
		setLayout(new BorderLayout());
		
		payloadPanel = new PayloadPanel(controller);
		infoPanel = new InfoPanel(controller);
		boardPanel = new BoardPanel(controller);
		
		add(payloadPanel, BorderLayout.NORTH);
		add(boardPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	public void displayMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Message",
				JOptionPane.PLAIN_MESSAGE);
	}

	public PayloadPanel getPayloadPanel() {
		return payloadPanel;
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}
	
}
