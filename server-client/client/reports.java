package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import client.view_conflicts.view_conflicts_screen;

public class reports extends JFrame {


private JLabel employeeid_label;
public static JTextArea textarea = new JTextArea(20, 40);
private JButton absenceRequests, absenceRequestsWithinAUnit ,administrativeoptions_button;
private JTextField employeeID;
private JLabel error_label;


public reports () 
	{
			
		setLayout(new FlowLayout());

		administrativeoptions_button = new JButton("Administrative Options");
		add(administrativeoptions_button);	
		absenceRequests = new JButton("All Absence Requests");
		add(absenceRequests);
		absenceRequestsWithinAUnit = new JButton("Requests Within A Unit");
		add(absenceRequestsWithinAUnit);
		employeeID = new JTextField(20);
		add(employeeID);
		
		reports_screen reports_event = new reports_screen();
		administrativeoptions_button.addActionListener(reports_event);
		
		textarea.setLineWrap(true);
	    add(new JScrollPane(textarea));
		textarea.setEditable(false);	
		
		reports_screen event = new reports_screen();
		absenceRequests.addActionListener(event);
		absenceRequestsWithinAUnit.addActionListener(event);
	}


	public class reports_screen implements ActionListener 
	{
	public void actionPerformed(ActionEvent reports_events) 
	{
		
		if (reports_events.getSource().equals(administrativeoptions_button))
		{
			setVisible(false);
			administrative_options administrativeoption_screen = new administrative_options();
			administrativeoption_screen.setSize(500,350);
			administrativeoption_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			administrativeoption_screen.setVisible(true);
			administrativeoption_screen.setTitle("Administrative Options");	
		}
		else if(reports_events.getSource().equals(absenceRequests)){
			Client client = new Client("10.100.61.76", 5555);
			try {
				if(client.isConnected())
				{
					client.sendToServer("K");
					client.setLocation("K");
				}	
			} catch (Exception t) {
				t.printStackTrace();
			}
		}
		else if(reports_events.getSource().equals(absenceRequestsWithinAUnit)){
			Client client = new Client("10.100.61.76", 5555);
			try {
				if(client.isConnected())
				{
					client.sendToServer("L:"+employeeID.getText());
					client.setLocation("L");
				}	
			} catch (Exception t) {
				t.printStackTrace();
			}
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




