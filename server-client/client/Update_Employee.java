package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Update_Employee extends JFrame {

	private JLabel firstname_label,lastname_label,address_label,phonenumber_label,office_label,dateofjoining_label,qualifications_label,employeeid_label,role_label,subordinateof_label,password_label;
	private JTextField firstname_textfield,lastname_textfield,address_textfield,phonenumber_textfield,office_textfield,dateofjoining_textfield,qualifications_textfield,employeeid_textfield,subordinateof_textfield;
	private JTextField password_textfield;
	private JButton submit_button,administrativeoptions_button;
	
	
	public Update_Employee(){
	
		setLayout(new FlowLayout());

		administrativeoptions_button = new JButton("Administrative Options");
		add(administrativeoptions_button);

firstname_label = new JLabel("First Name:");
add(firstname_label);
firstname_textfield = new JTextField(10);
add(firstname_textfield);

lastname_label = new JLabel("Last Name:");
add(lastname_label);
lastname_textfield = new JTextField(10);
add(lastname_textfield);

address_label = new JLabel("Address:");
add(address_label);
address_textfield = new JTextField(10);
add(address_textfield);

phonenumber_label = new JLabel("Phone Number:");
add(phonenumber_label);
phonenumber_textfield = new JTextField(10);
add(phonenumber_textfield);

office_label = new JLabel("Office:");
add(office_label);
office_textfield = new JTextField(10);
add(office_textfield);

dateofjoining_label = new JLabel("Date of joining:");
add(dateofjoining_label);
dateofjoining_textfield = new JTextField(10);
add(dateofjoining_textfield);

qualifications_label = new JLabel("Qualifications:");
add(qualifications_label);
qualifications_textfield = new JTextField(10);
add(qualifications_textfield);

subordinateof_label = new JLabel("Subordinate of:");
add(subordinateof_label);
subordinateof_textfield = new JTextField(10);
add(subordinateof_textfield);

employeeid_label = new JLabel("Employee ID:");
add(employeeid_label);
employeeid_textfield = new JTextField(10);
add(employeeid_textfield);


password_label = new JLabel("Password:");
add(password_label);
password_textfield = new JTextField(10);
add(password_textfield);

submit_button = new JButton("Sumbit");
add(submit_button);


update_employee_screen updateemployee_event = new update_employee_screen();
submit_button.addActionListener(updateemployee_event);
administrativeoptions_button.addActionListener(updateemployee_event);

	}
	


public class update_employee_screen implements ActionListener 
{
public void actionPerformed(ActionEvent update_employee_events) 
{
	


	if (update_employee_events.getSource().equals(administrativeoptions_button))
	{
		setVisible(false);
		administrative_options administrativeoption_screen = new administrative_options();
		administrativeoption_screen.setSize(700,500);
		administrativeoption_screen.setVisible(true);
		administrativeoption_screen.setTitle("Administrative Options");	
	}
	

	else if (update_employee_events.getSource().equals(submit_button))
	{
		String firstname_holder = firstname_textfield.getText();
		String lastname_holder = lastname_textfield.getText();
		String address_holder = address_textfield.getText();
		String phonenumber_holder = phonenumber_textfield.getText();
		String office_holder = office_textfield.getText();
		String dateofjoining_holder = dateofjoining_textfield.getText();
		String qualifications_holder = qualifications_textfield.getText();
		String subordinateof_holder = subordinateof_textfield.getText();
		String employeeid_holder = employeeid_textfield.getText();
		String password_holder = password_textfield.getText();
		

		if(firstname_holder.isEmpty() || lastname_holder.isEmpty() || subordinateof_holder.isEmpty() || employeeid_holder.isEmpty())
			JOptionPane.showMessageDialog(null, "Either First Name, Last Name, Role, Employee ID or Subordinate Of field is empty!");
		else
		{
			Client client = new Client("10.100.61.76", 5555);
			try {
				if(client.isConnected())
				{
					client.sendToServer("C:"+employeeid_textfield.getText()+":"
				+firstname_holder+":"+lastname_holder+":"+address_holder+":"+phonenumber_holder
				+":"+office_holder+":"+dateofjoining_holder+":"+qualifications_holder+":"+
				subordinateof_holder+":"+password_holder);
					client.setLocation("C");
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setVisible(false);
		administrative_options administrative_options = new administrative_options();
		administrative_options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		administrative_options.setSize(700,500);
		administrative_options.setVisible(true);
		administrative_options.setTitle("Administrative Options");
	}

	
	
	/*public static void main(String[] args) 
	{

		Update_Employee updateemployee_screen = new Update_Employee();
		updateemployee_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateemployee_screen.setSize(160,625);
		updateemployee_screen.setVisible(true);
		updateemployee_screen.setTitle("Update Employee");
			
	}*/
	
}}}
