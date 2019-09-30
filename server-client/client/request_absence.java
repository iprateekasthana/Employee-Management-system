package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class request_absence extends JFrame{

private JLabel employeeid_label,start_date_label, end_date_label, typeOfTimeOffLabel;
private JTextField employeeid_textfield,start_date_textfield, end_date_textfield, typeOfTimeOffTextField;
private JButton submit_button,administrativeoptions_button;
private JLabel error_label;


public request_absence () 
	{
	
	setLayout(new FlowLayout());


	administrativeoptions_button = new JButton("Administrative Options");
	add(administrativeoptions_button);	
	
	employeeid_label = new JLabel("Employee ID:");
	add (employeeid_label);	
	employeeid_textfield = new JTextField(10);
	add(employeeid_textfield);
	
	start_date_label = new JLabel("Start Date:");
	add (start_date_label);	
	start_date_textfield = new JTextField(10);
	add(start_date_textfield);
	
	end_date_label = new JLabel("End Date:");
	add (end_date_label);	
	end_date_textfield = new JTextField(10);
	add(end_date_textfield);

	
	typeOfTimeOffLabel = new JLabel("Type of Time Off: ");
	add(typeOfTimeOffLabel);
	typeOfTimeOffTextField =  new JTextField(10);
	add(typeOfTimeOffTextField);
	
	submit_button = new JButton("Submit");
	add(submit_button);
	
	
	error_label = new JLabel("");
	add (error_label);
	

request_absence_screen request_event = new request_absence_screen();
submit_button.addActionListener(request_event);
administrativeoptions_button.addActionListener(request_event);
}


public class request_absence_screen implements ActionListener 
{
public void actionPerformed(ActionEvent request_events) 
{
	
	if (request_events.getSource().equals(administrativeoptions_button) )
	{
		setVisible(false);
		administrative_options administrativeoption_screen = new administrative_options();
		administrativeoption_screen.setSize(500,350);
		administrativeoption_screen.setVisible(true);
		administrativeoption_screen.setTitle("Administrative Options");	
	}
	
	else if (request_events.getSource().equals(submit_button))
	{

		String employeeid_holder = employeeid_textfield.getText();
		String start_date = start_date_textfield.getText();
		String end_date = end_date_textfield.getText();
		String typeOf = typeOfTimeOffTextField.getText();
		
		Client client = new Client("10.100.61.76", 5555);
		try {
			if(client.isConnected())
			{
				client.sendToServer("G:"+employeeid_textfield.getText()+":"+typeOf+":"+start_date+":"+end_date);				
				client.setLocation("G");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(false);
		administrative_options administrative_options = new administrative_options();
		administrative_options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		administrative_options.setSize(700,500);
		administrative_options.setVisible(true);
		administrative_options.setTitle("Administrative Options");
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






