package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

@SuppressWarnings("serial")
public class StartMenu extends JFrame{
	
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private JTextField textBox1;
	private JTextField textBox2;
	
	public String getPlayer1() {
		return textBox1.getText();
	}
	
	public String getPlayer2() {
		return textBox2.getText();
	}
	
	public StartMenu(Controller controller) {
		setUndecorated(true);
		setBounds(SCREEN_WIDTH/2 - WIDTH/2, SCREEN_HEIGHT/2 - HEIGHT/2, WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5, 1));
		textBox1 = new JTextField("");
		textBox2 = new JTextField("");
		
		JLabel label1 = new JLabel("Enter The First Player's Name:\n");
		label1.setFont(controller.getAssets().getGameFont(24f));
		inputPanel.add(label1);
		inputPanel.add(textBox1);
		
		JLabel label2 = new JLabel("Enter The Second Player's Name:\n");
		label2.setFont(controller.getAssets().getGameFont(24f));
		inputPanel.add(label2);
		inputPanel.add(textBox2);
		inputPanel.add(new JLabel("\n\n"));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 1));
		JButton enter = new JButton("Enter");
		enter.addActionListener(controller);
		JButton quit = new JButton("Quit");
		quit.addActionListener(controller);
		
		buttonsPanel.add(enter);
		buttonsPanel.add(quit);
//		enter.setIcon(new ImageIcon(Assets.class.getResource("b.png")));
		
		add(inputPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
//		pack();
		setVisible(true);
	}
}
