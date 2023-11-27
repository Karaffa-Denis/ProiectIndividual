package gui_copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Car;
import main.Combustibil;

public class CarInfo extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JPanel leftPanel = new JPanel();
	JLabel marca = new JLabel();
	JLabel model = new JLabel();
	JLabel an = new JLabel();
	JLabel combustibil = new JLabel();
	
	
JPanel rightPanel = new JPanel();
	ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10000, 35000, 55000, 40000, 90000, 15000, 365, 365));
	JLabel km = new JLabel();
	JButton changeKM = new JButton("Update Kilometers");
	JButton serSetup = new JButton("Setup service info");
	
	Car currentCar;
	
	public CarInfo(Car currentCar) {
		if(currentCar != null) {
			this.currentCar = currentCar;
			marca.setText(currentCar.getmarca());
			model.setText(currentCar.getModel());
			an.setText(Integer.toString(currentCar.getAn()));
			combustibil.setText(currentCar.getComb().toString());
			km.setText(Integer.toString(currentCar.getKm()));
			this.arr=currentCar.getArr();
		}
		else marca.setText("----");
			 model.setText("----");
			 an.setText("----");
			 combustibil.setText("----");
			 km.setText("----");
		
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
	
			marca.setFont(new Font(null, Font.BOLD, 50)); 
			marca.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
			model.setFont(new Font(null, Font.BOLD, 25));
			an.setFont(new Font(null, Font.PLAIN, 20));
			combustibil.setFont(new Font(null, Font.PLAIN, 20));
			
			leftPanel.setBackground(new Color(0xc7d3eb));
			leftPanel.setPreferredSize(new Dimension(732/2, 200));
			leftPanel.add(marca);
			leftPanel.add(model);
			leftPanel.add(an);
			leftPanel.add(combustibil);
			
			
			
			
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
			
			km.setFont(new Font(null, Font.BOLD, 30));
			changeKM.setFont(new Font(null, Font.PLAIN, 30));
			serSetup.setFont(new Font(null, Font.PLAIN, 30));
			
			changeKM.setBackground(new Color(0xe9f1f5));
			changeKM.setFocusable(false);
			changeKM.addActionListener(this);
			
			
			serSetup.setBackground(new Color(0xe9f1f5));
			serSetup.setFocusable(false);
			serSetup.setPreferredSize(changeKM.getSize());
			serSetup.addActionListener(this);
			
			rightPanel.setBackground(new Color(0xc7d3eb));
			rightPanel.add(km);
			rightPanel.add(changeKM);
			rightPanel.add(serSetup);
	
	
	//--------set up carInfo panel-----
		setPreferredSize(new Dimension(0, 159));
		setBackground(new Color(0xc7d3eb));
		setLayout(new BorderLayout());
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);; 

		
	}
	public void fillInfo(Car car){
		marca.setText(car.getmarca());
		model.setText(car.getModel());
		an.setText(Integer.toString(car.getAn()));
		combustibil.setText(car.getComb().toString());
		km.setText(Integer.toString(car.getKm()));
	}
	
	public void fillEmpty() {
		marca.setText("----");
		model.setText("----");
		an.setText("----");
		combustibil.setText("----");
		km.setText("----");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== changeKM && km.getText()!="----") {
			
			 KmChange kC = new KmChange(this);
			 
			 kC.addWindowListener(new java.awt.event.WindowAdapter() {
                 public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                	 if(kC.returnKm()> Integer.valueOf(km.getText()))
                		 km.setText(String.valueOf(kC.returnKm()));
                	 	 currentCar.setKm(Integer.valueOf(km.getText()));
                 }
			 });
			
		}
		
		if(e.getSource()== serSetup && km.getText()!="----") {
			ServiceSetup ss = new ServiceSetup();
			
			 ss.addWindowListener(new java.awt.event.WindowAdapter() {
                 public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                     arr= ss.returnStats();
                 }
			 });
			
		}
		
	}
	public ArrayList<Integer> returnArr() {
		return arr;
	}
	
}
