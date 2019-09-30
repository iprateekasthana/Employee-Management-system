package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class employee_information extends JFrame {
	

		private JLabel firstname_label,lastname_label,address_label,phonenumber_label,office_label,dateofjoining_label,qualifications_label,employeeid_label,role_label,subordinateof_label,password_label;
		private JTextField firstname_textfield,lastname_textfield,address_textfield,phonenumber_textfield,office_textfield,dateofjoining_textfield,qualifications_textfield,employeeid_textfield,role_textfield,subordinateof_textfield;
		private JPasswordField password_passwordfield;
		private JButton submit_button,administrativeoptions_button;
		
		
		public employee_information(){
		
			setLayout(new FlowLayout());

			administrativeoptions_button = new JButton("Administrative Options");
			add(administrativeoptions_button);

	firstname_label = new JLabel("First Name:");
	add(firstname_label);
	firstname_textfield = new JTextField(10);
	add(firstname_textfield);
	firstname_textfield.setEditable(false);


	lastname_label = new JLabel("Last Name:");
	add(lastname_label);
	lastname_textfield = new JTextField(10);
	add(lastname_textfield);
	lastname_textfield.setEditable(false);

	address_label = new JLabel("Address:");
	add(address_label);
	address_textfield = new JTextField(10);
	add(address_textfield);
	address_textfield.setEditable(false);
	
	phonenumber_label = new JLabel("Phone Number:");
	add(phonenumber_label);
	phonenumber_textfield = new JTextField(10);
	add(phonenumber_textfield);
	phonenumber_textfield.setEditable(false);
	
	office_label = new JLabel("Office:");
	add(office_label);
	office_textfield = new JTextField(10);
	add(office_textfield);
	office_textfield.setEditable(false);
	
	dateofjoining_label = new JLabel("Date of joining:");
	add(dateofjoining_label);
	dateofjoining_textfield = new JTextField(10);
	add(dateofjoining_textfield);
	dateofjoining_textfield.setEditable(false);
	
	qualifications_label = new JLabel("Qualifications:");
	add(qualifications_label);
	qualifications_textfield = new JTextField(10);
	add(qualifications_textfield);
	qualifications_textfield.setEditable(false);
	
	role_label = new JLabel("Role:");
	add(role_label);
	role_textfield = new JTextField(10);
	add(role_textfield);
	role_textfield.setEditable(false);
	
	subordinateof_label = new JLabel("Subordinate of:");
	add(subordinateof_label);
	subordinateof_textfield = new JTextField(10);
	add(subordinateof_textfield);
	subordinateof_textfield.setEditable(false);
	
	employeeid_label = new JLabel("Employee ID:");
	add(employeeid_label);
	employeeid_textfield = new JTextField(10);
	add(employeeid_textfield);
	employeeid_textfield.setEditable(false);

	password_label = new JLabel("Password:");
	add(password_label);
	password_passwordfield = new JPasswordField(10);
	add(password_passwordfield);
	password_passwordfield.setEditable(false);
	
	submit_button = new JButton("Sumbit");
	add(submit_button);
	
	
		}
		
	/*	public static void main(String[] args) 
		{

			employee_information employee_information_screen = new employee_information();
			employee_information_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			employee_information_screen.setSize(160,625);
			employee_information_screen.setVisible(true);
			employee_information_screen.setTitle("Update Employee");
				
		}*/
		
	}


