package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;
import view.Assets.Assets;

@SuppressWarnings("serial")
public class PayloadPanel extends JPanel{
	JLabel p1 ;
	JLabel p2 ;
	JLabel curName ;
	public PayloadPanel(Controller controller) {
		setLayout(new BorderLayout());
		p1 = new JLabel();
		p2 = new JLabel();
		curName = new JLabel();
		p1.setIcon(new ImageIcon(Assets.class.getResource("0.PNG")));
		p2.setIcon(new ImageIcon(Assets.class.getResource("0.PNG")));
		controller.getGame();
		curName.setText(controller.getGame().getPlayer1().getName());
		curName.setHorizontalAlignment(JLabel.CENTER);
		this.add(p1,BorderLayout.WEST);
		this.add(p2,BorderLayout.EAST);
		this.add(curName, BorderLayout.CENTER);	
		
	}
	public void updatePayload(Controller controller) {
		String payloadP1 = "" + controller.getGame().getPlayer1().getPayloadPos() + ".PNG";
		String payloadP2 = "" + controller.getGame().getPlayer2().getPayloadPos() + ".PNG";
		p1.setIcon(new ImageIcon(Assets.class.getResource(payloadP1)));
		p2.setIcon(new ImageIcon(Assets.class.getResource(payloadP2)));
		curName.setText(controller.getGame().getCurrentPlayer().getName());
		
	}
}
