package client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class view_conflicts extends JFrame {

	private JButton administrativeoptions_button, submit;
	private JTextField managerID;
	private JLabel employeeid_label;
	public static JTextArea area = new JTextArea(20, 40);
	
	public view_conflicts (){
		setLayout(new FlowLayout());
		administrativeoptions_button = new JButton("Administrative Options");
		add(administrativeoptions_button);	
		
		JScrollPane scrollPane = new JScrollPane(area); 
	    add(area);
	    area.setEditable(false);
	    area.setLineWrap(true);
	    
	    employeeid_label = new JLabel("Manager ID:");
		add (employeeid_label);	
		managerID = new JTextField(10);
		add(managerID);
	    
		submit = new JButton("Submit");
		add(submit);
	    view_conflicts_screen event = new view_conflicts_screen();
	    submit.addActionListener(event);
	    administrativeoptions_button.addActionListener(event);
	   
	}
	
	public class view_conflicts_screen implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource().equals(administrativeoptions_button))
			{
				setVisible(false);
				administrative_options administrativeoption_screen = new administrative_options();
				administrativeoption_screen.setSize(500,350);
				administrativeoption_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				administrativeoption_screen.setVisible(true);
				administrativeoption_screen.setTitle("Administrative Options");	
			}
			else if(e.getSource().equals(submit)){
				Client client = new Client("10.100.61.76", 5555);
				try {
					if(client.isConnected())
					{
						client.sendToServer("J:"+managerID.getText().toString());
						client.setLocation("J");
					}	
				} catch (Exception t) {
					t.printStackTrace();
				}
				
						
			}
		}
	}
}
