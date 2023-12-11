package gui_copy;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import main.TextPrompt;

public class ServiceSetup extends JFrame implements ActionListener{
	
	JTextField oil = new JTextField();
	JTextField fBrakes = new JTextField();
	JTextField rBrakes = new JTextField();
	JTextField bFluid = new JTextField();
	JTextField sPlugs = new JTextField();
	JTextField aFilter = new JTextField();
	JTextField ITP = new JTextField();
	JTextField rov = new JTextField();
	JButton submit = new JButton("Submit");
	
	public ServiceSetup(){
		
		
		oil.setPreferredSize(new Dimension(290,70));
		oil.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt oilPrompt = new TextPrompt("Oil Change", oil);
		oilPrompt.changeAlpha(0.5f);
		
		
		fBrakes.setPreferredSize(new Dimension(290,70));
		fBrakes.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt fBrakesPrompt = new TextPrompt("Front brakes", fBrakes);
		fBrakesPrompt.changeAlpha(0.5f);
		
		
		rBrakes.setPreferredSize(new Dimension(290,70));
		rBrakes.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt rBrakesPrompt = new TextPrompt("Rear brakes", rBrakes);
		rBrakesPrompt.changeAlpha(0.5f);
		
		
		bFluid.setPreferredSize(new Dimension(290,70));
		bFluid.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt bFluidPrompt = new TextPrompt("Brake fluid", bFluid);
		bFluidPrompt.changeAlpha(0.5f);
		
		
		sPlugs.setPreferredSize(new Dimension(290,70));
		sPlugs.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt sPlugsPrompt = new TextPrompt("Spark plugs", sPlugs);
		sPlugsPrompt.changeAlpha(0.5f);
		
		
		aFilter.setPreferredSize(new Dimension(290,70));
		aFilter.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt aFilterPrompt = new TextPrompt("Air filter", aFilter);
		aFilterPrompt.changeAlpha(0.5f);
		
		
		rov.setPreferredSize(new Dimension(290,70));
		rov.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt rovPrompt = new TextPrompt("Rovinieta (zile ramase)", rov);
		rovPrompt.changeAlpha(0.5f);
		
		
		ITP.setPreferredSize(new Dimension(290,70));
		ITP.setFont(new Font(null, Font.PLAIN, 30));
		TextPrompt ITPPrompt = new TextPrompt("ITP (zile ramase)", ITP);
		ITPPrompt.changeAlpha(0.5f);
		
		
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
	
	public ArrayList<Integer> returnStats(ArrayList<Integer> oldArr) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			arr.add( Integer.valueOf(oil.getText()) );
		}
		catch (Exception e) {
			arr.add(oldArr.get(0));
		}
		
		
		
		try {
			arr.add( Integer.valueOf(fBrakes.getText()) );
		} catch (Exception e) {
			arr.add(oldArr.get(1));
		}
		
		
		
		try {
			arr.add( Integer.valueOf(rBrakes.getText()) );
		} catch (Exception e) {
			arr.add(oldArr.get(2));
		}
			
		
		try {
			arr.add( Integer.valueOf(bFluid.getText()) );
		} catch (Exception e) {
			arr.add(oldArr.get(3));
		}
			
		
		try {
			arr.add( Integer.valueOf(sPlugs.getText()) );
		} catch (Exception e) {
			arr.add(oldArr.get(4));
		}
			
		
		try {
			arr.add( Integer.valueOf(aFilter.getText()) );
		} catch (Exception e) {
			arr.add(oldArr.get(5));
		}
			
		
		try {
			arr.add( Integer.valueOf(ITP.getText()) );
		} catch (Exception e) {
			arr.add(oldArr.get(6));
		}
		
		try {
			arr.add( Integer.valueOf(rov.getText()) );
		} catch (Exception e) {
			arr.add(oldArr.get(7));
		}
			
		return arr;
	}
	  
}
	
