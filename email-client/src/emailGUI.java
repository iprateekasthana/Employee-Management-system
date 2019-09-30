import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class emailGUI extends JFrame implements ActionListener {

	// inbox tab //searchbar
	// sent tab
	// archive
	private JPanel inbox;
	private JPanel sent;
	private JPanel archive;

	emailGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("Welcome to Email");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		getContentPane().add(mainPanel);

		inbox();
		sent();
		archive();

		JTabbedPane tabPane = new JTabbedPane();
		tabPane.addTab("Inbox", inbox);
		tabPane.addTab("Sent", sent);
		tabPane.addTab("Archive", archive);

		mainPanel.add(tabPane);
	}

	public void inbox() {
		inbox = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JButton createButton = new JButton("create");
		JButton deleteButton = new JButton("delete");
		JButton archiveButton = new JButton("archive");
		JTextField searchField = new JTextField(15);

		inbox.add(createButton);
		inbox.add(deleteButton);
		inbox.add(archiveButton);
		inbox.add(searchField);

		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				create create = new create();
				create.setVisible(true);

			}
		});
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		archiveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void sent() {
		sent = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton sentDeleteButton = new JButton("delete");
		JButton sentArchiveButton = new JButton("archive");

		sent.add(sentDeleteButton);
		sent.add(sentArchiveButton);
	}

	public void archive() {
		archive = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JButton archiveDeleteButton = new JButton("delete");
		archive.add(archiveDeleteButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
