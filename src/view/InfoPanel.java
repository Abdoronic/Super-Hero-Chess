package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel{
	
	Controller controller;
	
	public InfoPanel(Controller controller) {
		JButton abilityButton = new JButton("Ability");
		abilityButton.addActionListener(controller);
		add(abilityButton);
	}
}
