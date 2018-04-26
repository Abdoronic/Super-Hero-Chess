package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import view.Assets.Assets;

@SuppressWarnings("serial")
public class StartPage extends JFrame{
	
	final static int WIDTH = 1280;
	final static int HEIGHT = 720;
	final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public StartPage(Controller controller) {
		setUndecorated(true);
		setBounds(SCREEN_WIDTH/2 - WIDTH/2, SCREEN_HEIGHT/2 - HEIGHT/2, WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		StartButton start = new StartButton();
		start.setIcon(new ImageIcon(Assets.class.getResource("startPage.jpg")));
		start.addActionListener(controller);
		add(start, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}
