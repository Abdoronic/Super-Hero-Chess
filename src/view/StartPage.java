package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;

@SuppressWarnings("serial")
public class StartPage extends JFrame{
	
	final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	private JButton startButton;
	
	public StartPage(Controller controller) {
		setUndecorated(true);
		setLayout(new BorderLayout());
		
		startButton = new JButton();
		startButton.setIcon(controller.getAssets().getStartPageIcon());
		startButton.addActionListener(controller);
		
		int width = startButton.getIcon().getIconWidth();
		int height = startButton.getIcon().getIconHeight();
		
		setBounds(SCREEN_WIDTH/2 - width/2, SCREEN_HEIGHT/2 - height/2, width, height);
		add(startButton, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	public JButton getStartButton() {
		return startButton;
	}
}
