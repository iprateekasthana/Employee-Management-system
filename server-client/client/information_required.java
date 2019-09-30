package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class information_required extends JFrame{


private JLabel employeeid_label,firstname_label,phonenumber_label;
private JTextField employeeid_textfield,firstname_textfield,phonenumber_textfield;
private JButton submit_button,administrativeoptions_button;
private JLabel error_label;

public information_required () 
	{
	
	setLayout(new FlowLayout());
	
	administrativeoptions_button = new JButton("Administrative Options");
	add(administrativeoptions_button);	
	
		
	firstname_label = new JLabel("First Name:");
	add (firstname_label);	
	firstname_textfield = new JTextField(10);
	add(firstname_textfield);
	
	employeeid_label = new JLabel("Employee ID:");
	add (employeeid_label);	
	employeeid_textfield = new JTextField(10);
	add(employeeid_textfield);
	
	phonenumber_label = new JLabel("Phone Number:");
	add (phonenumber_label);	
	phonenumber_textfield = new JTextField(10);
	add(phonenumber_textfield);
	
	submit_button = new JButton("Submit");
	add(submit_button);
	
	error_label = new JLabel("");
	add (error_label);
	}
	
	/*	login_screen login_event = new login_screen();
	login_button.addActionListener(login_event);
	}

public class login_screen implements ActionListener 
{
	public void actionPerformed(ActionEvent login_event) 
	{
	try{
	
	label.setText("login button created an event");
	}
	catch(exception error){
	error_label.setText("Invalid Log in Information");
	//return to login screen? how
	
}
*/
 
	public static void main(String[] args) 
	{

		information_required information_required_screen = new information_required();
		information_required_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		information_required_screen.setSize(200,250);
		information_required_screen.setVisible(true);
		information_required_screen.setTitle("Employee ID required!");
			
	}

}


