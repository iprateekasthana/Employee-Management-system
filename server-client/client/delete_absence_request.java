package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class delete_absence_request extends JFrame {



private JLabel employeeid_label;
private JTextField employeeid_textfield;
private JButton submit_button,administrativeoptions_button,getAllRequests;
private JLabel error_label;
public static JTextArea search_employee_area = new JTextArea(20, 40);


public delete_absence_request () 
	{
	
	setLayout(new FlowLayout());

	administrativeoptions_button = new JButton("Administrative Options");
	add(administrativeoptions_button);	
	
	employeeid_label = new JLabel("Absence ID:");
	add (employeeid_label);	
	employeeid_textfield = new JTextField(10);
	add(employeeid_textfield);
	
	submit_button = new JButton("Submit");
	add(submit_button);
		
	JScrollPane scrollPane = new JScrollPane(search_employee_area); 
    add(search_employee_area);
	search_employee_area.setEditable(false);
	search_employee_area.setLineWrap(true);

	
	error_label = new JLabel("");
	add (error_label);
	

delete_absence_request_screen der_event = new delete_absence_request_screen();
submit_button.addActionListener(der_event);
administrativeoptions_button.addActionListener(der_event);
getAllRequests = new JButton("");
getAllRequests.addActionListener(der_event);
getAllRequests.doClick();

}


public class delete_absence_request_screen implements ActionListener 
{
public void actionPerformed(ActionEvent der_events) 
{
	


	if (der_events.getSource().equals(administrativeoptions_button))
	{
		setVisible(false);
		administrative_options administrativeoption_screen = new administrative_options();
		administrativeoption_screen.setSize(500,350);
		administrativeoption_screen.setVisible(true);
		administrativeoption_screen.setTitle("Administrative Options");	
	}
	else if (der_events.getSource().equals(getAllRequests)){
		Client client = new Client("10.100.61.76", 5555);
		try {
			if(client.isConnected())
			{
				client.sendToServer("I");
				client.setLocation("I");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	else if (der_events.getSource().equals(submit_button))
	{
		
		Client client = new Client("10.100.61.76", 5555);
		try {
			if(client.isConnected())
			{
				client.sendToServer("H:"+employeeid_textfield.getText());
				client.setLocation("H");
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






/*
public class delete_absence_request extends JFrame{

	private JLabel employeeid_label,requestedtimeoff_label,employeename_label,delete_label;
	private JCheckBox cb,cb_1,cb_2,cb_3,cb_4,cb_5;
	private JTextField employeeid_textfield,employeename_textfield,requestedtimeoff_textfield;
	private JTextField employeeid_textfield1,employeename_textfield1,requestedtimeoff_textfield1;
	private JTextField employeeid_textfield2,employeename_textfield2,requestedtimeoff_textfield2;
	private JTextField employeeid_textfield3,employeename_textfield3,requestedtimeoff_textfield3;

public delete_absence_request() 
	{
	
	setLayout(new GridLayout(5,3));
	
	
	employeeid_label = new JLabel("Employee ID");
	add(employeeid_label);
	employeename_label = new JLabel("Employee Name");
	add(employeename_label);
	requestedtimeoff_label = new JLabel("Requested Time off");
	add(requestedtimeoff_label);
	delete_label = new JLabel("Delete");
	add(delete_label);
	
	employeeid_textfield = new JTextField(10);
	add(employeeid_textfield);
	employeeid_textfield.setEditable(false);
	employeename_textfield = new JTextField(10);
	add(employeename_textfield);
	employeename_textfield.setEditable(false);
	requestedtimeoff_textfield = new JTextField(10);
	add(requestedtimeoff_textfield);
	requestedtimeoff_textfield.setEditable(false);
	cb = new JCheckBox();
	add(cb);
	
	employeeid_textfield1 = new JTextField(10);
	add(employeeid_textfield1);
	employeeid_textfield1.setEditable(false);
	employeename_textfield1 = new JTextField(10);
	add(employeename_textfield1);
	employeename_textfield1.setEditable(false);
	requestedtimeoff_textfield1 = new JTextField(10);
	add(requestedtimeoff_textfield1);
	requestedtimeoff_textfield1.setEditable(false);
	cb_1 = new JCheckBox();
	add(cb_1);
	
	employeeid_textfield2 = new JTextField(10);
	add(employeeid_textfield2);
	employeeid_textfield2.setEditable(false);
	employeename_textfield2 = new JTextField(10);
	add(employeename_textfield2);
	employeename_textfield2.setEditable(false);
	requestedtimeoff_textfield2 = new JTextField(10);
	add(requestedtimeoff_textfield2);
	requestedtimeoff_textfield2.setEditable(false);
	cb_2 = new JCheckBox();
	add(cb_2);
	
	employeeid_textfield3 = new JTextField(10);
	add(employeeid_textfield3);
	employeeid_textfield3.setEditable(false);
	employeename_textfield3 = new JTextField(10);
	add(employeename_textfield3);
	employeename_textfield3.setEditable(false);
	requestedtimeoff_textfield3 = new JTextField(10);
	add(requestedtimeoff_textfield3);
	requestedtimeoff_textfield3.setEditable(false);
	cb_3 = new JCheckBox();
	add(cb_3);
	
	delete_absence_request cb_event = new delete_absence_request();
	cb_1.addActionListener(cb_event);
	cb_2.addActionListener(cb_event);
	cb_3.addActionListener(cb_event);
	cb_1.addActionListener(cb_event);


	}

public class cb_event implements ActionListener 
{
	public void actionPerformed(ActionEvent cb_event) 
	{
	
		
	}
	
	}
 
	public static void main(String[] args) 
	{

		delete_absence_request delete_absence_request_screen = new delete_absence_request();
		delete_absence_request_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		delete_absence_request_screen.setSize(525,75);
		delete_absence_request_screen.setVisible(true);
		delete_absence_request_screen.setTitle("Delete Absence Requests");
			
	}
	
	*/


