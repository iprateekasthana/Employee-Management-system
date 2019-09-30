package client;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class employee_id_required extends JFrame{


private JLabel employeeid_label;
private JTextField employeeid_textfield;
private JButton submit_button,administrativeoptions_button;
private JLabel error_label;

public employee_id_required () 
	{
	
	setLayout(new FlowLayout());
	
	administrativeoptions_button = new JButton("Administrative Options");
	add(administrativeoptions_button);	
	
	employeeid_label = new JLabel("Employee ID:");
	add (employeeid_label);	
	employeeid_textfield = new JTextField(10);
	add(employeeid_textfield);
	
	submit_button = new JButton("Submit");
	add(submit_button);
	
	error_label = new JLabel("");
	add (error_label);
	

delete_employee_screen deleteemployee_event = new delete_employee_screen();
submit_button.addActionListener(deleteemployee_event);
administrativeoptions_button.addActionListener(deleteemployee_event);
}


public class delete_employee_screen implements ActionListener 
{
public void actionPerformed(ActionEvent deleteemployee_events) 
{
	


	if (deleteemployee_events.getSource().equals(administrativeoptions_button))
	{
		setVisible(false);
		administrative_options administrativeoption_screen = new administrative_options();
		administrativeoption_screen.setSize(500,350);
		administrativeoption_screen.setVisible(true);
		administrativeoption_screen.setTitle("Administrative Options");	
	}
		else if (deleteemployee_events.getSource().equals(submit_button))
	{

		String employeeid_holder = employeeid_textfield.getText();
			Client client = new Client("10.100.61.76", 5555);
			try {
				if(client.isConnected())
				{
					client.sendToServer("B:"+employeeid_holder);
					client.setLocation("B");
				}	
			} catch (Exception t) {
				t.printStackTrace();
			}

		
		/*
		setVisible(false);
		add_employee addemployee_screen = new add_employee();
		addemployee_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addemployee_screen.setSize(160,625);
		addemployee_screen.setVisible(true);
		addemployee_screen.setTitle("Add Employee"); */
	}

	
		
	}
}
/*	public static void main(String[] args) 
	{

		employee_id_required employee_id_required_screen = new employee_id_required();
		employee_id_required_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employee_id_required_screen.setSize(200,150);
		employee_id_required_screen.setVisible(true);
		employee_id_required_screen.setTitle("Employee ID required!");
			
	} */

}

