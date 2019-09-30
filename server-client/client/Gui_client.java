package client;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class Gui_client extends JFrame 
{
public static int check = 0, status = 0;
private JLabel employeeid_label,password_label;
private JButton login_button;
private JTextField employeeid_textfield;
private JPasswordField password_field;
private JLabel error_label;

public Gui_client () 
	{
	
	setLayout(new FlowLayout());
	
	
	
	employeeid_label = new JLabel("Employee ID:");
	add (employeeid_label);	
	employeeid_textfield = new JTextField(10);
	add(employeeid_textfield);
	
	
	password_label = new JLabel("Password:");
	add (password_label);
	password_field = new JPasswordField(10);
	add(password_field);
	
	
	login_button = new JButton("Log in");
	add(login_button);
	
	error_label = new JLabel("");
	add (error_label);
	
	
	login_screen login_event = new login_screen();
	login_button.addActionListener(login_event);
	
	}


public class login_screen implements ActionListener
{
	public void actionPerformed(ActionEvent login_event) 
	{
		if(login_event.getSource() == login_button){
			if(employeeid_textfield.getText().isEmpty() || password_field.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "One of the fields is empty");
			else{
				Client client = new Client("10.100.61.76", 5555);
				try {
					if(client.isConnected())
					{
						client.sendToServer("M:"+employeeid_textfield.getText()+":"+password_field.getText());
						client.setLocation("M");
					}	
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
			status=1;
		if(status==1)
		{
			setVisible(false);
			administrative_options administrative_options = new administrative_options();
			administrative_options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			administrative_options.setSize(700,500);
			administrative_options.setVisible(true);
			administrative_options.setTitle("Administrative Options");
		}
			
		}
	}
}
 
	public static void main(String[] args) 
	{
		
		Gui_client login_screen = new Gui_client();
		login_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_screen.setSize(525,75);
		login_screen.setVisible(true);
		login_screen.setTitle("Login Screen");
	}

}
