package gui_copy;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.Font;

public class Notifications {

	private JFrame frmNotifications;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @param l1 
	 */
	public Notifications(DefaultListModel<String> l1) {
		
		frmNotifications = new JFrame();
		frmNotifications.setTitle("Notifications");
		frmNotifications.setBounds(100, 100, 450, 300);
		frmNotifications.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JList<String> list = new JList<String>(l1);
		list.setToolTipText("");
		list.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmNotifications.getContentPane().add(list, BorderLayout.CENTER);
		frmNotifications.setVisible(true);
	}

}


