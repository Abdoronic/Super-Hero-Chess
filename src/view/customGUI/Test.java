package view.customGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test {
	public static void main(String[] args) {
        Object[] options1 = { "Try This Number", "Choose A Random Number",
                "Quit", "Medic" , "Hero","Q", "F" , "R" };

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter number between 0 and 1000"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        System.out.println(result);
        if (result == 1){
            JOptionPane.showMessageDialog(null, textField.getText());
        }
    }

}
