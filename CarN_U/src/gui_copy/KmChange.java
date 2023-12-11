package gui_copy;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KmChange extends JFrame implements ActionListener{
	
	JTextField newKm = new JTextField();
	JButton button = new JButton("Submit");
	public KmChange(JPanel carInfo) {
		
		
		newKm.setFont(new Font(null, Font.PLAIN, 30));
		newKm.setPreferredSize(new Dimension(100, 30));
		button.setFont(new Font(null, Font.PLAIN, 30));
	
		button.addActionListener(this);
		
		add(newKm);
		add(button);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		setTitle("Set Km");
		pack();
		setLocationRelativeTo(carInfo);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			dispose();
		}
		
	}
	
	public int returnKm(int oldKm) {
		try {
			return Integer.valueOf(newKm.getText());
		} catch (Exception e) {
			return oldKm;
		}
		
	}
	
	
}
