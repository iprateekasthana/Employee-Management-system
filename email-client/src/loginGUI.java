import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class loginGUI extends JFrame implements ActionListener {

	JTextField usernameField = new JTextField(10);
	JPasswordField passwordField = new JPasswordField(10);
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel = new JLabel("Password:");
	JButton SUBMIT = new JButton("SUBMIT");
	String gmail;
	String passfield;
	
	public String gmail() {
		return gmail = usernameField.getText();
	}

	public String password() {
		return passfield = String.valueOf(passwordField);
	}
	

	public static void main(String[] args) {

		loginGUI loginPage = new loginGUI();
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPage.setSize(500, 75);
		loginPage.setVisible(true);
		loginPage.setTitle("Email Login");
	}

	loginGUI() { // LoginGUI constructor

		setLayout(new FlowLayout());
		add(usernameLabel);
		add(usernameField);
		add(passwordLabel);
		add(passwordField);
		add(SUBMIT);
		SUBMIT.addActionListener(this);

	}

	// left to implement javax authentication
	public void actionPerformed(ActionEvent e) {
		if (usernameField.getText().equals("username") || (passwordField.getPassword().equals("password"))) {
			setVisible(false);
			emailGUI emailGUI = new emailGUI();
			emailGUI.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, "Invalid username/password");
		}
	}

}
