package gui_copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ServicePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JLabel label;
	JProgressBar bar;
	int maxKm;
	int remainingKm;
	public ServicePanel(String name, int maxKm, int remainingKm) {
		//label creation
		label = new JLabel(name);
		label.setBackground(SystemColor.scrollbar);
		label.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(0,30));
		

		// progress bar creation
		this.maxKm = maxKm;
		this.remainingKm = remainingKm;
		bar = new JProgressBar(0, maxKm);
		bar.setPreferredSize(new Dimension(0,30));
		bar.setStringPainted(true);
		bar.setFont(new Font(null, Font.BOLD, 15));
		bar.setValue(remainingKm);
		bar.setBackground(SystemColor.controlHighlight);
		if(remainingKm >= maxKm/2)
			bar.setForeground(new Color(0x2d9428));
		else if(remainingKm<maxKm/2 && remainingKm>= maxKm/4)
			bar.setForeground(Color.yellow);
		else bar.setForeground(Color.red);
		
		bar.setString(remainingKm + "/ " + maxKm);
		

		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		
		add(label,BorderLayout.NORTH);
	
		add(bar, BorderLayout.SOUTH);

	}
	
	
	public void setKm(int newKM) {
		remainingKm= newKM;
		bar.setValue(remainingKm);
		if(remainingKm >= maxKm/2)
			bar.setForeground(new Color(0x2d9428));
		else if(remainingKm<maxKm/2 && remainingKm>= maxKm/4)
			bar.setForeground(Color.yellow);
		else bar.setForeground(Color.red);
		bar.setString(remainingKm + "/ " + maxKm);
	}
	public int returnKm() {
		return remainingKm;
	}
}
