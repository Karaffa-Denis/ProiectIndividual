package gui_copy;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ServiceSetup extends JFrame implements ActionListener{
	CarInfo carInfo;
	JTextField oil = new JTextField("Oil Change");
	JTextField fBrakes = new JTextField("Front brakes");
	JTextField rBrakes = new JTextField("Rear brakes");
	JTextField bFluid = new JTextField("Brake fluid");
	JTextField sPlugs = new JTextField("Spark plugs");
	JTextField aFilter = new JTextField("Air filter");
	JTextField ITP = new JTextField("ITP");
	JTextField rov = new JTextField("rov");
	JButton submit = new JButton("Submit");
	
	public ServiceSetup(){
		
		this.carInfo = carInfo;
		oil.setPreferredSize(new Dimension(290,70));
		oil.setFont(new Font(null, Font.PLAIN, 30));
		
		
		fBrakes.setPreferredSize(new Dimension(290,70));
		fBrakes.setFont(new Font(null, Font.PLAIN, 30));
		
		
		rBrakes.setPreferredSize(new Dimension(290,70));
		rBrakes.setFont(new Font(null, Font.PLAIN, 30));
		
		
		bFluid.setPreferredSize(new Dimension(290,70));
		bFluid.setFont(new Font(null, Font.PLAIN, 30));
		
		
		sPlugs.setPreferredSize(new Dimension(290,70));
		sPlugs.setFont(new Font(null, Font.PLAIN, 30));
		
		
		aFilter.setPreferredSize(new Dimension(290,70));
		aFilter.setFont(new Font(null, Font.PLAIN, 30));
		
		
		rov.setPreferredSize(new Dimension(290,70));
		rov.setFont(new Font(null, Font.PLAIN, 30));
		
		
		ITP.setPreferredSize(new Dimension(290,70));
		ITP.setFont(new Font(null, Font.PLAIN, 30));
		
		
		submit.setPreferredSize(new Dimension(290, 70));
		submit.setFont(new Font(null, Font.PLAIN, 30));
		submit.addActionListener(this);
		
		add(oil);
		add(fBrakes);
		add(rBrakes);
		add(bFluid);
		add(sPlugs);
		add(aFilter);
		add(ITP);
		add(rov);
		add(submit);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300,710);
		setResizable(false);
		setTitle("Service setup");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			this.dispose();
			
		}
		
	}
	
	public ArrayList<Integer> returnStats() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			arr.add( Integer.valueOf(oil.getText()) );
			arr.add( Integer.valueOf(fBrakes.getText()) );
			arr.add( Integer.valueOf(rBrakes.getText()) );
			arr.add( Integer.valueOf(bFluid.getText()) );
			arr.add( Integer.valueOf(sPlugs.getText()) );
			arr.add( Integer.valueOf(aFilter.getText()) );
			arr.add( Integer.valueOf(ITP.getText()) );
			arr.add( Integer.valueOf(rov.getText()) );
		}
		catch (Exception e) {
			arr = new ArrayList<>(Arrays.asList(10000, 35000, 55000, 40000, 90000, 15000, 365, 365));
		}
		
		return arr;
	}
}
