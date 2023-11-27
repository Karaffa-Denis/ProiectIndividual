package gui_copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ServicePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JLabel label;
	JButton button;
	JProgressBar bar;
	int maxKm;
	int remainingKm;
	public ServicePanel(ImageIcon icon, String name, int maxKm, int remainingKm) {
		//label creation
		label = new JLabel(name);
		label.setPreferredSize(new Dimension(0,30));
		
		//button creation 
		button = new JButton(icon);
		button.addActionListener(this);
		button.setFocusable(false);
		button.setBackground(null);
		
		// progress bar creation
		this.maxKm = maxKm;
		this.remainingKm = remainingKm;
		bar = new JProgressBar(0, maxKm);
		bar.setPreferredSize(new Dimension(0,30));
		bar.setStringPainted(true);
		bar.setFont(new Font(null, Font.BOLD, 15));
		bar.setValue(remainingKm);
		bar.setBackground(Color.green);
		if(remainingKm>= maxKm/2)
			bar.setForeground(new Color(0x2d9428));
		else if(remainingKm<maxKm/2 && remainingKm>= maxKm/4)
			bar.setForeground(Color.yellow);
			else bar.setForeground(Color.red);
		
		bar.setString(remainingKm + "/ " + maxKm);
		

		setBackground(null);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		setPreferredSize(new Dimension(200,150));
		add(label,BorderLayout.NORTH);
		add(button, BorderLayout.CENTER);
		add(bar, BorderLayout.SOUTH);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
				if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
					remainingKm = maxKm;
				}
		}
		
	} 
}
