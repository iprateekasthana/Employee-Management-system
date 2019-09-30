import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

//Download Java Mail API: https://javaee.github.io/javamail/
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;

public class create extends JFrame implements ActionListener {

	public create() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setTitle("Create and Send Email");
		getContentPane().setLayout(new FlowLayout());

//		 goto https://myaccount.google.com/security
//		 turn on "less secure app access
//		 enter your gmail account and password.
		String username = "xxxx@gmail.com";
		String password = "xxxxxx";

		final Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Label Title Send Mail
		JLabel lblSendMail = new JLabel("Send Mail");
		lblSendMail.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblSendMail);

		// Label To
		JLabel lblTo = new JLabel("To :");
		getContentPane().add(lblTo);

		// Text Field To
		final JTextField txtTo = new JTextField();
		getContentPane().add(txtTo);
		txtTo.setColumns(10);

		// Label Subject
		JLabel lblSubject = new JLabel("Subject :");
		getContentPane().add(lblSubject);

		// Text Field Subject
		final JTextField txtSubject = new JTextField();
		txtSubject.setColumns(10);
		getContentPane().add(txtSubject);

		// Text Area Description
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

		final JTextArea txtDesc = new JTextArea(20, 40);
		scrollPane.setViewportView(txtDesc);
		getContentPane().add(txtDesc);

		// Button Send
		JButton btnSend = new JButton("Send");
		getContentPane().add(btnSend, BorderLayout.SOUTH);
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				

				Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(username, password);
					}
				});

				Message message = new MimeMessage(mailSession);
				try {
					message.setFrom(new InternetAddress(username)); // From
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtTo.getText())); // To
					message.setSubject(txtSubject.getText());
					message.setText(txtDesc.getText());

					Transport.send(message);

				} catch (Exception ex) {
					System.out.println("something went wrong!!!");
				}

				JOptionPane.showMessageDialog(null, "Mail Send Successfully.");

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}