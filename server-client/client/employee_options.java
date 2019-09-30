package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class employee_options extends JFrame{
	
private	JButton logout_button,addemployee_button,updateemployee_button,deleteemployee_button,searchemployee_button;
private JButton requestabsence_button,deleteabsencerequests_button,reports_button,viewconflicts_button,viewabsencerequests_button;
private JLabel administrativeoptions_label, employeeoptions_label;

//GridLayout administrativeoption_layout = new GridLayout(7,2);


public employee_options() {

setLayout(new GridLayout(5,2));



//administrativeoptions_label = new JLabel("Administrative Options");
//add (administrativeoptions_label);	


addemployee_button = new JButton("Add Employee");
add(addemployee_button);
addemployee_button.setEnabled(false);

updateemployee_button = new JButton("Update Employee");
add(updateemployee_button);
updateemployee_button.setEnabled(false);

deleteemployee_button = new JButton("Delete Employee");
add(deleteemployee_button);
deleteemployee_button.setEnabled(false);

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


}
	

/*

public static void main(String[] args) 
{

	employee_options employeeoptions_screen = new employee_options();
	employeeoptions_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	employeeoptions_screen.setSize(500,350);
	employeeoptions_screen.setVisible(true);
	employeeoptions_screen.setTitle("Employee Options");
		
}
*/
}