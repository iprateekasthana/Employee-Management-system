package client;

import java.awt.Component;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class Client extends AbstractClient{
	private String location;
	private int status=0;
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public Client(String host, int port) {
		super(host, port);
		try {
			openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		
		String message[] = msg.toString().split(":");
		if(message[0]=="0")
			status = 0;
		else if(message[0]=="1")
		{
			status = 1;
		}
		
		displayMessageFromServer(message[1]);
		try {
			this.closeConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	protected void displayMessageFromServer(String message){
		
		if(location.equals("M")){
			if(!message.isEmpty())
				JOptionPane.showMessageDialog(null, message);
			Gui_client.status=status;
			if(status == 1){
				
			}
		}
		else if(location.equals("A")){
			if(!message.isEmpty())
				JOptionPane.showMessageDialog(null, message);
			else
				JOptionPane.showMessageDialog(null, "New Employee Added");
		}
		else if(location.equals("B")){
			if(!message.isEmpty())
				JOptionPane.showMessageDialog(null, message);
			else
				JOptionPane.showMessageDialog(null, "Employee Deleted");
		}
		else if(location.equals("C")){
			if(!message.isEmpty())
				JOptionPane.showMessageDialog(null, message);
			else
				JOptionPane.showMessageDialog(null, "Employee Updated");
		}
		else if(location.equals("F")){
			search_employee.search_employee_area.setText(message);
		}
		else if(location.equals("G")){
			if(!message.isEmpty())
				JOptionPane.showMessageDialog(null, message);
		}
		else if(location.equals("I")){
			delete_absence_request.search_employee_area.setText(message);
		}
		else if(location.equals("H")){
			if(!message.isEmpty())
				JOptionPane.showMessageDialog(null, message);
		}
		else if(location.equals("J")){
				view_conflicts.area.setText(message);
		}
		else if(location.equals("K")){
			reports.textarea.setText(message);
		}
		else if(location.equals("L")){
				reports.textarea.setText(message);
	}
			
	}
	
		
}
