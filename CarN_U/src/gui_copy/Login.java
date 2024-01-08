package gui_copy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import main.Dbconnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField loginUserField;
	private JPasswordField loginPassField;
	private JTextField registerUserField;
	private JPasswordField registerPassField;
	private JPasswordField registerPassCField;

	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 440, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cardLayout = new CardLayout(0,0);
		frame.getContentPane().setLayout(cardLayout);
		
		JPanel login = new JPanel();
		frame.getContentPane().add(login, "loginCardPanel");
		login.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		usernameLabel.setBounds(42, 85, 108, 47);
		login.add(usernameLabel);
		
		JLabel loginLabel = new JLabel("Log In");
		loginLabel.setBounds(159, 10, 108, 47);
		loginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		login.add(loginLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblPassword.setBounds(42, 221, 108, 47);
		login.add(lblPassword);
		
		loginUserField = new JTextField();
		loginUserField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		loginUserField.setBounds(126, 129, 184, 47);
		login.add(loginUserField);
		loginUserField.setColumns(10);
		
		loginPassField = new JPasswordField();
		loginPassField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		loginPassField.setColumns(10);
		loginPassField.setBounds(126, 265, 184, 47);
		login.add(loginPassField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(frame.getContentPane());
				
			}
		});
		registerButton.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		registerButton.setBounds(159, 441, 126, 41);
		login.add(registerButton);
		
		JButton btnSubmit_1 = new JButton("Log in");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginUserField.getText().isEmpty() == false && loginPassField.getPassword().length !=0) {
					
					String sql = "SELECT ID from Users WHERE Username = ? AND Password = ? ";
					
					try (Connection con = Dbconnection.connect();
						 PreparedStatement ps = con.prepareStatement(sql)){ 
						
						ps.setString(1, loginUserField.getText());
			            ps.setString(2, String.valueOf(loginPassField.getPassword()));
			            
			            try (ResultSet rs=ps.executeQuery()){
			            	if (rs.next()) {
			                    
			                    int userId = rs.getInt("ID");
			                    System.out.println("Login successful. User ID: " + userId);
			                    new MainFrame1(loginUserField.getText(), userId);
								frame.dispose();
			                } 
			            	else
			            		JOptionPane.showMessageDialog(null,"Incorrect Password or Username!",null,JOptionPane.WARNING_MESSAGE);     
							
			            	
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null,"Incorrect Password or Username!",null,JOptionPane.WARNING_MESSAGE);
						}
						        	
						        	
					} catch (SQLException e1) {
						System.out.println(e1.toString()); 	
					}
					
					
				}
			}
		});
		btnSubmit_1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnSubmit_1.setBounds(141, 356, 156, 47);
		login.add(btnSubmit_1);
		
		
		
		
	//-----------------------------REGISTER PANEL-----------------------------------------------
		JPanel register = new JPanel();
		frame.getContentPane().add(register, "registerCardPanel");
		register.setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(147, 5, 132, 47);
		lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		register.add(lblRegister);
		
		JLabel usernameLabel_1 = new JLabel("Username:");
		usernameLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		usernameLabel_1.setBounds(38, 69, 108, 47);
		register.add(usernameLabel_1);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblPassword_1.setBounds(38, 168, 108, 47);
		register.add(lblPassword_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password:");
		lblConfirmPassword.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(38, 290, 191, 47);
		register.add(lblConfirmPassword);
		
		registerUserField = new JTextField();
		registerUserField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		registerUserField.setColumns(10);
		registerUserField.setBounds(123, 111, 184, 47);
		register.add(registerUserField);
		
		registerPassField = new JPasswordField();
		registerPassField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		registerPassField.setColumns(10);
		registerPassField.setBounds(123, 222, 184, 47);
		register.add(registerPassField);
		
		registerPassCField = new JPasswordField();
		registerPassCField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		registerPassCField.setColumns(10);
		registerPassCField.setBounds(123, 339, 184, 47);
		register.add(registerPassCField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Arrays.equals(registerPassField.getPassword(), registerPassCField.getPassword() ) ) {
					String username = registerUserField.getText();
			        String password = new String(registerPassField.getPassword());
			       
			        String sql = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
			        
			        
			        try (Connection con = Dbconnection.connect();
			        	 PreparedStatement ps = con.prepareStatement(sql)) { 
			        	
			        	ps.setString(1, username);
			        	ps.setString(2, password);
			        	ps.executeUpdate();
			        	
			        	 } catch (Exception e2) {
						
			        		 System.out.println(e2.toString());
					}
			        cardLayout.next(frame.getContentPane());
				}
				else JOptionPane.showMessageDialog(null,"Password incorrect!",null,JOptionPane.WARNING_MESSAGE);     
			}
		});
		btnSubmit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnSubmit.setBounds(153, 406, 126, 41);
		register.add(btnSubmit);
		
		JButton btnReturn = new JButton("Go back");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.next(frame.getContentPane());
				
			}
		});
		btnReturn.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnReturn.setBounds(163, 463, 108, 35);
		register.add(btnReturn);
		frame.setVisible(true);
	}
}
