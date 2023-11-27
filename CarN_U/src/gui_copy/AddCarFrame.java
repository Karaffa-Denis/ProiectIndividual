package gui_copy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import main.Car;
import main.Combustibil;

public class AddCarFrame extends JFrame implements ActionListener{
	
	JTextField marca = new JTextField("Marca");
	JTextField model = new JTextField("Model");
	JTextField an = new JTextField("An");
	JComboBox<Combustibil> combustibil;
	JTextField km = new JTextField("Kilometrii");
	JButton submit = new JButton("Submit");
	AddCarFrame(){
		
		
		marca.setPreferredSize(new Dimension(290,87));
		marca.setFont(new Font(null, Font.PLAIN, 40));
		
		model.setPreferredSize(new Dimension(290,87));
		model.setFont(new Font(null, Font.PLAIN, 40));
		
		an.setPreferredSize(new Dimension(290,75));
		an.setFont(new Font(null, Font.PLAIN, 40));
		
		
		combustibil = new JComboBox<Combustibil>(Combustibil.values());
		combustibil.setPreferredSize(new Dimension(290,87));
		combustibil.setFont(new Font(null, Font.PLAIN, 40));
		
		km.setPreferredSize(new Dimension(290,87));
		km.setFont(new Font(null, Font.PLAIN, 40));
		
		submit.setPreferredSize(new Dimension(290, 87));
		submit.setFont(new Font(null, Font.PLAIN, 40));
		submit.addActionListener(this);
		
		add(marca);
		add(model);
		add(an);
		add(combustibil);
		add(km);
		add(submit);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300,600);
		setResizable(false);
		setTitle("Add Car");
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			this.dispose();
			
		}
		
	}
	
	public Car returnCar() {
		return new Car(marca.getText(),
				model.getText(), 
				Integer.parseInt(an.getText()), 
				(Combustibil) combustibil.getSelectedItem(), 
				Integer.parseInt(km.getText()));
	}
}
