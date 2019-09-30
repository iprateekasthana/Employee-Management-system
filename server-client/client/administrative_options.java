package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class administrative_options extends JFrame{
	
private	JButton logout_button,addemployee_button,updateemployee_button,deleteemployee_button,searchemployee_button;
private JButton requestabsence_button,deleteabsencerequests_button,reports_button,viewconflicts_button,viewabsencerequests_button;
private JLabel administrativeoptions_label, employeeoptions_label;

//GridLayout administrativeoption_layout = new GridLayout(7,2);


public administrative_options() {

setLayout(new GridLayout(5,2));



//administrativeoptions_label = new JLabel("Administrative Options");
//add (administrativeoptions_label);	


addemployee_button = new JButton("Add Employee");
add(addemployee_button);

updateemployee_button = new JButton("Update Employee");
add(updateemployee_button);

deleteemployee_button = new JButton("Delete Employee");
add(deleteemployee_button);

searchemployee_button = new JButton("Search Employee");
add(searchemployee_button);

requestabsence_button = new JButton("Request Absence");
add(requestabsence_button);

deleteabsencerequests_button = new JButton("Delete Absence Requests");
add(deleteabsencerequests_button);

reports_button = new JButton("Reports");
add(reports_button);

viewabsencerequests_button = new JButton("View Absence Requests");
add(viewabsencerequests_button);

viewconflicts_button = new JButton("View Conflicts");
add(viewconflicts_button);

logout_button = new JButton("Log Out");
add(logout_button);

option_screen option_event = new option_screen();
addemployee_button.addActionListener(option_event);
deleteemployee_button.addActionListener(option_event);
requestabsence_button.addActionListener(option_event);
reports_button.addActionListener(option_event);
viewconflicts_button.addActionListener(option_event);
updateemployee_button.addActionListener(option_event);
searchemployee_button.addActionListener(option_event);
deleteabsencerequests_button.addActionListener(option_event);
viewabsencerequests_button.addActionListener(option_event);
logout_button.addActionListener(option_event);

}
public class option_screen implements ActionListener 
{
public void actionPerformed(ActionEvent options) 
{
	if(options.getSource()==addemployee_button){
		setVisible(false);
		add_employee addemployee_screen = new add_employee();
		addemployee_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addemployee_screen.setSize(160,625);
		addemployee_screen.setVisible(true);
		addemployee_screen.setTitle("Add Employee");
			
	}
	else if(options.getSource()==deleteemployee_button){
		setVisible(false);
		employee_id_required employee_id_required_screen = new employee_id_required();
		employee_id_required_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employee_id_required_screen.setSize(500,80);
		employee_id_required_screen.setVisible(true);
		employee_id_required_screen.setTitle("Delete Employee");
	}
else if(options.getSource()==requestabsence_button){

	setVisible(false);
	request_absence requestabsence_screen = new request_absence();
	requestabsence_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	requestabsence_screen.setSize(650,80);
	requestabsence_screen.setVisible(true);
	requestabsence_screen.setTitle("Request Absence");
	}

else if(options.getSource()==reports_button){

	setVisible(false);
	reports reports_screen = new reports();
	reports_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	reports_screen.setSize(400,400);
	reports_screen.setVisible(true);
	reports_screen.setTitle("Reports");
}

else if(options.getSource()==viewconflicts_button){
		setVisible(false);
		view_conflicts conflicts_screen = new view_conflicts();
		conflicts_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conflicts_screen.setSize(400,400);
		conflicts_screen.setVisible(true);
		conflicts_screen.setTitle("View Conflicts");
}

else if(options.getSource()==updateemployee_button){
	setVisible(false);
	Update_Employee updateemployee_screen = new Update_Employee();
	updateemployee_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	updateemployee_screen.setSize(160,625);
	updateemployee_screen.setVisible(true);
	updateemployee_screen.setTitle("Update Employee");
}

else if(options.getSource()==searchemployee_button){
	setVisible(false);
	search_employee search_employee_screen = new search_employee();
	search_employee_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	search_employee_screen.setSize(500,400);
	search_employee_screen.setVisible(true);
	search_employee_screen.setTitle("Search Employee");
	
}

else if(options.getSource()==deleteabsencerequests_button){
	setVisible(false);
	delete_absence_request delete_absence_request_screen = new delete_absence_request();
	delete_absence_request_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	delete_absence_request_screen.setSize(500,400);
	delete_absence_request_screen.setVisible(true);
	delete_absence_request_screen.setTitle("Delete Absence Requests");
		
}

else if(options.getSource()==viewabsencerequests_button){
	setVisible(false);
	view_absence_requests view_absence_requests_screen = new view_absence_requests();
	view_absence_requests_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	view_absence_requests_screen.setSize(450,400);
	view_absence_requests_screen.setVisible(true);
	view_absence_requests_screen.setTitle("View Absence Requests");
}

else if(options.getSource()==logout_button){
	System.exit(0);
	
}

}

}
	


/*
public static void main(String[] args) 
{

	administrative_options administrativeoption_screen = new administrative_options();
	administrativeoption_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	administrativeoption_screen.setSize(500,350);
	administrativeoption_screen.setVisible(true);
	administrativeoption_screen.setTitle("Administrative Options");
		
}*/

}