package gui_copy;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Car;
import main.Combustibil;
import main.Dbconnection;

import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class MainFrame1 extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame();
	
	Car currentCar;
	private int userId;
	DefaultListModel<String> l1 = new DefaultListModel<String>();
	JPanel leftPanel = new JPanel();
	//--------------------BANNER VARIABLES---------------------------------
		JPanel banner = new JPanel();
			JButton logout;
			JButton notifButton;
			JLabel username;
			ImageIcon noNotifIcon = new ImageIcon("src/bell.png");
			ImageIcon notifIcon = new ImageIcon("src/bellNotif.png");
		
		
		//----------------------CAR LIST VARIABLES-----------------------------------
		JPanel carList = new JPanel();
			DefaultListModel<Car> listModel = new DefaultListModel<Car>();
			JList<Car> list = new JList<Car>(listModel);
			JButton addB = new JButton("Add new car");
			JButton delB = new JButton("Delete selected car");
		
	JPanel rightPanel = new JPanel();
	
	
		
		JPanel carInfo;
			JPanel leftInfoPanel;
				JLabel marca = new JLabel();
				JLabel model = new JLabel();
				JLabel an = new JLabel();
				JLabel combustibil = new JLabel();
				
			JPanel rightInfoPanel;
				JLabel km = new JLabel();
				JButton changeKM = new JButton("Update Kilometers");
				JButton serSetup = new JButton("Setup service info");
		
		JPanel otherMenuPanel = new JPanel();
		JPanel cardPanel = new JPanel();	
		CardLayout cardLayout = new CardLayout();
		JPanel sMenu = new JPanel();
			
			ServicePanel oilPanel = new ServicePanel("Oil change", 10000, 0);
			JButton oilButton = new JButton(new ImageIcon("src/serviceIcons/oil.png"));
			
			ServicePanel fBrakesPanel = new ServicePanel( "Front brakes", 35000, 0);
			JButton fBrakesButton = new JButton(new ImageIcon("src/serviceIcons/fBrake.png"));
			
			ServicePanel rBrakesPanel = new ServicePanel( "Rear brakes", 55000, 0);
			JButton rBrakesButton = new JButton(new ImageIcon("src/serviceIcons/rBrake.png"));
			
			ServicePanel bFluidPanel = new ServicePanel( "Brake fluid", 40000, 0);
			JButton bFluidButton = new JButton(new ImageIcon("src/serviceIcons/bFluid.png"));
			
			ServicePanel sPlugsPanel = new ServicePanel( "Spark plugs", 90000, 0);
			JButton sPlugsButton = new JButton(new ImageIcon("src/serviceIcons/sPlugs.png"));
			
			ServicePanel cFilterPanel = new ServicePanel( "Air Filter", 15000, 0);
			JButton cFilterButton = new JButton(new ImageIcon("src/serviceIcons/cFilter.png"));
			
			ServicePanel ITPPanel = new ServicePanel( "ITP", 365, 0);
			JButton ITPButton = new JButton(new ImageIcon("src/serviceIcons/ITP.png"));
			
			ServicePanel rovPanel = new ServicePanel( "Rovinieta", 365, 0);
			JButton rovButton = new JButton(new ImageIcon("src/serviceIcons/rov.png"));
			
			JPanel otherPanel = new JPanel();
			JButton otherButton = new JButton(new ImageIcon("src/serviceIcons/Other.png"));
			private final JButton returnButton = new JButton("Return");
			private final JButton btnNewButton = new JButton("itp");

			
	
			
	
	public MainFrame1(String userN, int userId){
		
		
		
		this.userId = userId;
//--------------------------------------------------LEFT PANEL------------------------------------------------------------
		// ---------------------------------------------BANNER--------------------------------------------
		
				notifButton = new JButton();
				notifButton.setIcon(noNotifIcon);
				notifButton.addActionListener(this);
				notifButton.setBackground(null);
				notifButton.setFocusable(false);
				notifButton.setPreferredSize(new Dimension(96,0));
				notifButton.setBorder(null);
							
							
						//create username PANEL
				JPanel usernamePanel = new JPanel();
				usernamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0,20));
				usernamePanel.setPreferredSize(new Dimension(292-96, 0));
					
					
						//create username label
				username = new JLabel(" USER: " + userN);
				username.setFont(new Font(null, Font.BOLD, 15));
					
					
						//create logout button
				logout = new JButton("Log Out");
				logout.addActionListener(this);
				logout.setFocusable(false);
				logout.setFont(new Font(null, Font.BOLD, 15));
					
					
						//add label and button to Panel
				usernamePanel.add(username);
				usernamePanel.add(logout);
				usernamePanel.setBackground(null);
							
							
						//add button and panel to banner panel
			banner.setPreferredSize(new Dimension(292,96));
			banner.setBackground(new Color(0xaec8e2));
			banner.setLayout(new BorderLayout());
			banner.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray));
			banner.add(notifButton, BorderLayout.WEST);
			banner.add(usernamePanel, BorderLayout.EAST);
				
				
				
				// ----------------------------CAR LIST------------------------------------------------------
			list.addListSelectionListener(this);
			JScrollPane scrollPane = new JScrollPane(list);
			scrollPane.setPreferredSize(new Dimension(292,636));
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
			list.setFont(new Font(null, Font.PLAIN, 30));
			
			addB.addActionListener(this);
			addB.setFocusable(false);
			delB.addActionListener(this);
			delB.setFocusable(false);
			
			carList.setPreferredSize(new Dimension(292, 636));
			carList.setBackground(new Color(228, 228, 228));
			carList.setBorder(null);
			carList.setLayout(new FlowLayout());
			carList.add(addB);
			carList.add(delB);
			carList.add(scrollPane);
		leftPanel.setBounds(0, 0, 292, 768);
				
				// ----------------------------LEFT PANEL EDITS------------------------------------------------------
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setPreferredSize(new Dimension(292, 768));
		leftPanel.add(banner, BorderLayout.NORTH);
		leftPanel.add(carList, BorderLayout.CENTER);
		
	
//-------------------------------------------------RIGHT PANEL---------------------------------------------------		
			
		
		//--------------------------------------------------------------------CAR INFO-------------------------------------------//
		fillEmpty();
		carInfo = new JPanel();
			
			leftInfoPanel = new JPanel();
			leftInfoPanel.setLayout(new BoxLayout(leftInfoPanel, BoxLayout.Y_AXIS));
			
				marca.setFont(new Font("Sylfaen", Font.BOLD, 50)); 
				model.setFont(new Font("Sylfaen", Font.BOLD, 25));
				an.setFont(new Font("Sylfaen", Font.PLAIN, 20));
				combustibil.setFont(new Font("Sylfaen", Font.PLAIN, 20));
			
			leftInfoPanel.setBackground(new Color(0xc7d3eb));
			leftInfoPanel.setPreferredSize(new Dimension(366, 150));
			leftInfoPanel.add(marca);
			leftInfoPanel.add(model);
			leftInfoPanel.add(an);
			leftInfoPanel.add(combustibil);
			
			rightInfoPanel = new JPanel();
			rightInfoPanel.setLayout(new BoxLayout(rightInfoPanel, BoxLayout.Y_AXIS));
			
				km.setFont(new Font(null, Font.BOLD, 30));
				changeKM.setFont(new Font(null, Font.PLAIN, 30));
				serSetup.setForeground(new Color(0, 0, 0));
				serSetup.setFont(new Font(null, Font.PLAIN, 30));
			
				changeKM.setBackground(new Color(255, 255, 255));
				changeKM.setFocusable(false);
				changeKM.addActionListener(this);
			
			
				serSetup.setBackground(new Color(255, 255, 255));
				serSetup.setFocusable(false);
				serSetup.setPreferredSize(changeKM.getSize());
				serSetup.addActionListener(this);
			
			rightInfoPanel.setBackground(new Color(0xc7d3eb));
			rightInfoPanel.add(km);
			rightInfoPanel.add(changeKM);
			rightInfoPanel.add(serSetup);
	
	
									//--------set up carInfo panel-----
			carInfo.setPreferredSize(new Dimension(0, 150));
			carInfo.setBackground(new Color(0xc7d3eb));
			carInfo.setLayout(new BorderLayout());
			carInfo.add(leftInfoPanel, BorderLayout.WEST);
			carInfo.add(rightInfoPanel, BorderLayout.EAST);
				oilButton.setForeground(new Color(230, 230, 230));
			
			
			
			
			
	
		//-----------------------------------------------------SERVICE MENU-----------------------------------------------------
				oilButton.addActionListener(this);
				oilButton.setFocusable(false);
			oilPanel.add(oilButton, BorderLayout.CENTER);
				fBrakesButton.setForeground(new Color(230, 230, 230));
			
				fBrakesButton.addActionListener(this);
				fBrakesButton.setFocusable(false);
				fBrakesButton.setBackground(null);
			fBrakesPanel.add(fBrakesButton, BorderLayout.CENTER);
				rBrakesButton.setForeground(new Color(230, 230, 230));
			
				rBrakesButton.addActionListener(this);
				rBrakesButton.setFocusable(false);
				rBrakesButton.setBackground(null);
			rBrakesPanel.add(rBrakesButton, BorderLayout.CENTER);
				bFluidButton.setForeground(new Color(230, 230, 230));
			
				bFluidButton.addActionListener(this);
				bFluidButton.setFocusable(false);
				bFluidButton.setBackground(null);
			bFluidPanel.add(bFluidButton, BorderLayout.CENTER);
				sPlugsButton.setForeground(new Color(230, 230, 230));
			
				sPlugsButton.addActionListener(this);
				sPlugsButton.setFocusable(false);
				sPlugsButton.setBackground(null);
			sPlugsPanel.add(sPlugsButton, BorderLayout.CENTER);
				cFilterButton.setForeground(new Color(230, 230, 230));
			
				cFilterButton.addActionListener(this);
				cFilterButton.setFocusable(false);
				cFilterButton.setBackground(null);
			cFilterPanel.add(cFilterButton, BorderLayout.CENTER);
				ITPButton.setForeground(new Color(230, 230, 230));
			
				ITPButton.addActionListener(this);
				ITPButton.setFocusable(false);
				ITPButton.setBackground(null);
			ITPPanel.add(ITPButton, BorderLayout.CENTER);
				rovButton.setForeground(new Color(230, 230, 230));
			
				rovButton.addActionListener(this);
				rovButton.setFocusable(false);
				rovButton.setBackground(null);
			rovPanel.add(rovButton, BorderLayout.CENTER);
			
			
				JLabel otherLabel = new JLabel("Other");
				otherLabel.setHorizontalAlignment(SwingConstants.CENTER);
				otherLabel.setHorizontalTextPosition(SwingConstants.CENTER);
				otherLabel.setFont(new Font("Sylfaen", Font.PLAIN, 15));
				otherLabel.setBackground(new Color(255, 255, 255));
				otherLabel.setPreferredSize(new Dimension(0,30));
				otherButton.setForeground(new Color(230, 230, 230));
				otherButton.addActionListener(this);
				otherButton.setFocusable(false);
				otherButton.setBackground(new Color(255, 255, 255));
				JProgressBar bar = new JProgressBar();
				bar.setPreferredSize(new Dimension(0,30));
				bar.setStringPainted(true);
				bar.setFont(new Font(null, Font.BOLD, 15));
				bar.setValue(0);
				bar.setBackground(Color.lightGray);
				bar.setString("");
				
				
			otherPanel.setBackground(new Color(255, 255, 255));
			otherPanel.setLayout(new BorderLayout());
			otherPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
			otherPanel.setPreferredSize(new Dimension(200,150));
			
			otherPanel.add(otherLabel,BorderLayout.NORTH);
			otherPanel.add(otherButton, BorderLayout.CENTER);
			otherPanel.add(bar, BorderLayout.SOUTH);
			sMenu.setSize(new Dimension(732, 618));
			
			
			
			sMenu.setLayout(new GridLayout(3, 3, 0, 0));
			sMenu.setBackground(new Color(0xeef2f9));
			sMenu.setPreferredSize(new Dimension(732, 618));	
		
			sMenu.add(oilPanel);
			sMenu.add(fBrakesPanel);
			sMenu.add(rBrakesPanel);
			sMenu.add(bFluidPanel);
			sMenu.add(sPlugsPanel);
			sMenu.add(cFilterPanel);
			sMenu.add(ITPPanel);
			sMenu.add(rovPanel);					
			sMenu.add(otherPanel);
			otherMenuPanel.setLayout(new BorderLayout(0, 0));
			otherMenuPanel.setBackground(new Color(187, 198, 198));
			
			cardPanel.setLayout(cardLayout);
			cardPanel.setPreferredSize(new Dimension(732, 618));
			cardPanel.setBackground(new Color(0xeef2f9));
			cardPanel.add(sMenu,"serviceMenu");
			cardPanel.add(otherMenuPanel,"otherMenuPanel");
			returnButton.setIcon(new ImageIcon(MainFrame1.class.getResource("/serviceIcons/return.png")));
			returnButton.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			otherMenuPanel.add(returnButton, BorderLayout.SOUTH);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					    Desktop.getDesktop().browse(new URL("https://programare-itp.ro").toURI());
					} catch (Exception e1) {}
				}
			});
			btnNewButton.setIcon(new ImageIcon(MainFrame1.class.getResource("/serviceIcons/Programare ITP.png")));
			
			otherMenuPanel.add(btnNewButton, BorderLayout.NORTH);
			returnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cardLayout.next(cardPanel);
				}
			});
		rightPanel.setBounds(293, 0, 732, 768);
		rightPanel.setBackground(new Color(0xeef2f9));
		rightPanel.setLayout(new BorderLayout(0, 0));
		rightPanel.add(carInfo, BorderLayout.NORTH);
		rightPanel.add(cardPanel);
		rightPanel.setBorder(null);
		

		// Color Scheme
		Color primaryBlue = new Color(72, 133, 237);  // Primary color (blue)
		Color secondaryBlue = new Color(105, 170, 255); // Slightly lighter shade of blue
		Color lightGray = new Color(0xe9e9e9);     // Light gray
		Color darkGray = new Color(80, 80, 80);         // Dark gray

		// ...

		// Banner
		banner.setPreferredSize(new Dimension(292, 96));
		banner.setBackground(primaryBlue);
		banner.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, darkGray));

		// Buttons and Labels
		logout.setBackground(secondaryBlue);
		logout.setForeground(Color.black);
		logout.setFont(new Font(null, Font.BOLD, 15));

		username.setFont(new Font(null, Font.BOLD, 15));
		username.setForeground(Color.black);

		addB.setBackground(primaryBlue);
		addB.setForeground(Color.white);

		delB.setBackground(primaryBlue);
		delB.setForeground(Color.white);

		// Left Panel
		leftPanel.setPreferredSize(new Dimension(292, 768));
		leftPanel.setBackground(lightGray);

		// Car List
		carList.setPreferredSize(new Dimension(292, 636));
		carList.setBackground(lightGray);

		list.setSelectionBackground(secondaryBlue);
		list.setSelectionForeground(Color.white);

		// Right Panel
		rightPanel.setBounds(293, 0, 732, 768);
		rightPanel.setBackground(Color.white);

		// Car Info
		carInfo.setBackground(primaryBlue);

		leftInfoPanel.setBackground(primaryBlue);
		leftInfoPanel.setPreferredSize(new Dimension(366, 150));

		rightInfoPanel.setBackground(primaryBlue);

		marca.setForeground(Color.white);
		model.setForeground(Color.white);
		an.setForeground(Color.white);
		combustibil.setForeground(Color.white);
		km.setForeground(Color.white);

		changeKM.setBackground(secondaryBlue);
		serSetup.setBackground(secondaryBlue);

		// Service Menu
		sMenu.setBackground(lightGray);
		sMenu.setPreferredSize(new Dimension(732, 618));

		// Service Panels
		oilPanel.setBackground(new Color(255, 255, 255));
		fBrakesPanel.setBackground(new Color(255, 255, 255));
		rBrakesPanel.setBackground(new Color(255, 255, 255));
		bFluidPanel.setBackground(new Color(255, 255, 255));
		sPlugsPanel.setBackground(new Color(255, 255, 255));
		cFilterPanel.setBackground(new Color(255, 255, 255));
		ITPPanel.setBackground(new Color(255, 255, 255));
		rovPanel.setBackground(new Color(255, 255, 255));
		otherPanel.setBackground(lightGray);

		// Service Buttons
		oilButton.setBackground(lightGray);
		fBrakesButton.setBackground(lightGray);
		rBrakesButton.setBackground(lightGray);
		bFluidButton.setBackground(lightGray);
		sPlugsButton.setBackground(lightGray);
		cFilterButton.setBackground(lightGray);
		ITPButton.setBackground(lightGray);
		rovButton.setBackground(lightGray);
		otherButton.setBackground(lightGray);

		// Other Menu Panel
		otherMenuPanel.setBackground(primaryBlue);

		// Card Panel
		cardPanel.setBackground(lightGray);

		// Return Button
		returnButton.setBackground(secondaryBlue);
		returnButton.setForeground(Color.white);

		// New Button (ITP)
		btnNewButton.setBackground(secondaryBlue);
		btnNewButton.setForeground(Color.white);
		

		
//----------------------------------------------------MAIN FRAME SETUP ------------------------------------------------------
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1036, 807);
		frame.setResizable(false);
		frame.setTitle("Car n' U");
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(leftPanel);
		frame.getContentPane().add(rightPanel);
		frame.setVisible(true);
		
		carListQuery();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logout) {
			frame.dispose();
			new Login();
			
		}
		if(e.getSource() == addB) {
			 AddCarFrame acf = new AddCarFrame();
			 
			 acf.addWindowListener(new java.awt.event.WindowAdapter() {
                 public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                     try {
                    	 listModel.addElement( acf.returnCar());
                    	 dbCarInsert(acf.returnCar());
                     }catch (Exception e) {
						// TODO: handle exception
					}
                     
                 }
			 });
		 }
		
		if(e.getSource() == delB){
			int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
            	bdDelete(listModel.elementAt(selectedIndex));
                listModel.removeElementAt(selectedIndex);
                fillEmpty();
                
             
            }
         
		}
		if(e.getSource()== changeKM && km.getText()!="----") {
			
			 KmChange kC = new KmChange(carInfo);
			 
			 kC.addWindowListener(new java.awt.event.WindowAdapter() {
               int oldKm = currentCar.getKm();

				public void windowClosed(java.awt.event.WindowEvent windowEvent) {
               	 if( kC.returnKm(currentCar.getKm())> Integer.valueOf(km.getText()) ) {
            
               		 km.setText( String.valueOf( kC.returnKm(currentCar.getKm()) ));
               	 	 currentCar.setKm(Integer.valueOf(km.getText()));
               	 	 
               	 	 	currentCar.setServiceVar(0, currentCar.getArr().get(0) - currentCar.getKm() + oldKm);
               	 	 	currentCar.setServiceVar(1, currentCar.getArr().get(1) - currentCar.getKm() + oldKm);
               	 		currentCar.setServiceVar(2, currentCar.getArr().get(2) - currentCar.getKm() + oldKm);
               	 		currentCar.setServiceVar(3, currentCar.getArr().get(3) - currentCar.getKm() + oldKm);
               	 		currentCar.setServiceVar(4, currentCar.getArr().get(4) - currentCar.getKm() + oldKm);
               	 		currentCar.setServiceVar(5, currentCar.getArr().get(5) - currentCar.getKm() + oldKm);
               	
               	 		oilPanel.setKm(currentCar.getArr().get(0));
               	 		fBrakesPanel.setKm(currentCar.getArr().get(1));
               	 		rBrakesPanel.setKm(currentCar.getArr().get(2));
               	 		bFluidPanel.setKm(currentCar.getArr().get(3));
               	 		sPlugsPanel.setKm(currentCar.getArr().get(4));
               	 		cFilterPanel.setKm(currentCar.getArr().get(5));
               	 		
               	 		dbServiceUpdate(currentCar);
               	 	if (checkNotifications()==1)
                      	 notifButton.setIcon(notifIcon);
               	 else {notifButton.setIcon(noNotifIcon);
					l1.clear();
			}
               	 }
   						
                }
			 });
			
		}
		if(e.getSource()== notifButton) {
			if(l1.isEmpty()==false)
				new Notifications(l1);
			
		}
		
		if(e.getSource()== serSetup && km.getText()!="----") {
			ServiceSetup ss = new ServiceSetup();
			
			 ss.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                	
                	
                    currentCar.setArr( ss.returnStats(currentCar.getArr()) );
                    oilPanel.setKm(currentCar.getArr().get(0));
                    fBrakesPanel.setKm(currentCar.getArr().get(1));
   					rBrakesPanel.setKm(currentCar.getArr().get(2));
   					bFluidPanel.setKm(currentCar.getArr().get(3));
   					sPlugsPanel.setKm(currentCar.getArr().get(4));
   					cFilterPanel.setKm(currentCar.getArr().get(5));
   					ITPPanel.setKm(currentCar.getArr().get(6));
   					rovPanel.setKm(currentCar.getArr().get(7));
   					
   					dbServiceUpdate(currentCar);
   					if (checkNotifications()==1)
   	               	 notifButton.setIcon(notifIcon);
   					else {notifButton.setIcon(noNotifIcon);
					l1.clear();
			}

                   
                   
                   
                }
			 });
			
		}
		
		
		//-------------------------------SERVICE PANEL BUTTONS-------------------------------------
	if(currentCar != null) {
		if(e.getSource()==oilButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + oilPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(0, 10000);
				oilPanel.setKm(currentCar.getArr().get(0));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
	               	 notifButton.setIcon(notifIcon);
				else {notifButton.setIcon(noNotifIcon);
				l1.clear();
		}
				
			}
		}
		if(e.getSource()==fBrakesButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + fBrakesPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(1, 35000);
				fBrakesPanel.setKm(currentCar.getArr().get(1));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
	               	 notifButton.setIcon(notifIcon);
				else {notifButton.setIcon(noNotifIcon);
				l1.clear();
		}
			}
		}
		if(e.getSource()==rBrakesButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + rBrakesPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(2, 55000);
				rBrakesPanel.setKm(currentCar.getArr().get(2));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
	               	 notifButton.setIcon(notifIcon);
				else {notifButton.setIcon(noNotifIcon);
				l1.clear();
		}
			}
		}
		if(e.getSource()==bFluidButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + bFluidPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(3, 40000);
				bFluidPanel.setKm(currentCar.getArr().get(3));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
	               	 notifButton.setIcon(notifIcon);
				else {notifButton.setIcon(noNotifIcon);
				l1.clear();
		}
			}
		}
		if(e.getSource()==sPlugsButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + sPlugsPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(4, 90000);
				sPlugsPanel.setKm(currentCar.getArr().get(4));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
	               	 notifButton.setIcon(notifIcon);
				else {notifButton.setIcon(noNotifIcon);
				l1.clear();
		}
			}
		}
		if(e.getSource()==cFilterButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + cFilterPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(5, 15000);
				cFilterPanel.setKm(currentCar.getArr().get(5));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
	               	 notifButton.setIcon(notifIcon);
					else {notifButton.setIcon(noNotifIcon);
							l1.clear();
					}
			}
		}
		if(e.getSource()==ITPButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + ITPPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(6, 365);
				ITPPanel.setKm(currentCar.getArr().get(6));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
               	 notifButton.setIcon(notifIcon);
				else {notifButton.setIcon(noNotifIcon);
				l1.clear();
		}
			}
		}
		if(e.getSource()==rovButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + rovPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(7, 365);
				rovPanel.setKm(currentCar.getArr().get(7));
				dbServiceUpdate(currentCar);
				if (checkNotifications()==1)
	               	 notifButton.setIcon(notifIcon);
				else {notifButton.setIcon(noNotifIcon);
				l1.clear();
		}
			}
		}
		if(e.getSource()==otherButton) {
			cardLayout.next(cardPanel);
		}
		
	}
	
}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		 if (!e.getValueIsAdjusting()) {
             int selectedIndex = list.getSelectedIndex();
             if (selectedIndex != -1) {
            	 currentCar = listModel.elementAt(selectedIndex);
                 fillInfo(currentCar);             
                 fillPanel(currentCar.getArr());
                
                 if (checkNotifications()==1)
                	 notifButton.setIcon(notifIcon);
                 else {notifButton.setIcon(noNotifIcon);
					l1.clear();
			}
             }
         }
			
	}
	
	public void fillPanel(ArrayList<Integer> car) {
		oilPanel.setKm(car.get(0)); 
		fBrakesPanel.setKm(car.get(1));
		rBrakesPanel.setKm(car.get(2));
		bFluidPanel.setKm(car.get(3));
		sPlugsPanel.setKm(car.get(4));
		cFilterPanel.setKm(car.get(5));
		ITPPanel.setKm(car.get(6));
		rovPanel.setKm(car.get(7));
	}
	
	public void fillEmpty() {
		marca.setText("----");
		model.setText("----");
		an.setText("----");
		combustibil.setText("----");
		km.setText("----");
	}
	public void fillInfo(Car car){
		marca.setText(car.getmarca());
		model.setText(car.getModel());
		an.setText(Integer.toString(car.getAn()));
		combustibil.setText(car.getComb().toString());
		km.setText(Integer.toString(car.getKm()));
	}
	private void dbCarInsert(Car car) {
		
		String sql = "INSERT INTO CarList (OwnerID, Make, Model, Year, Fuel, Kilometers,"
					+" OilKm, FbrakeKm, RbrakeKm, BFluidKm, SPlugsKm, AirFilterKm, ITPDate, RovDate)"
					+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        try (Connection con = Dbconnection.connect();
        	 PreparedStatement ps = con.prepareStatement(sql)) { 
        	
        	ps.setInt(1, userId);     						 ps.setString(2, car.getmarca());
        	ps.setString(3, car.getModel()); 				 ps.setInt(4, car.getAn()); 
        	ps.setString(5, String.valueOf(car.getComb()));  ps.setInt(6, car.getKm()); 			   
        	ps.setInt(7, car.getArr().get(0));				 ps.setInt(8, car.getArr().get(1));			
        	ps.setInt(9, car.getArr().get(2));				 ps.setInt(10, car.getArr().get(3));				 
        	ps.setInt(11, car.getArr().get(4));				 ps.setInt(12, car.getArr().get(5));		 
        	ps.setInt(13, 365);     					 	 ps.setInt(14, 365);						 
        	
        	ps.execute();
        	 } catch (Exception e2) {
			
        		 System.out.println(e2.toString());
		}
	}
	private void dbServiceUpdate(Car car) {
		String sql = "UPDATE CarList SET OilKm=?, FbrakeKm=?, RbrakeKm=?, BFluidKm=?, SPlugsKm=?, AirFilterKm=?, ITPDate=?, RovDate=?, Kilometers=?"
				+ "WHERE OwnerId=? AND Make=? AND Model=?";
    
    
		try (Connection con = Dbconnection.connect();
				PreparedStatement ps = con.prepareStatement(sql)) { 
    	
			ps.setInt(1, car.getArr().get(0));     
			ps.setInt(2, car.getArr().get(1));     
			ps.setInt(3, car.getArr().get(2));     
			ps.setInt(4, car.getArr().get(3));     
			ps.setInt(5, car.getArr().get(4));     
			ps.setInt(6, car.getArr().get(5));     
			ps.setInt(7, car.getArr().get(6));     
			ps.setInt(8, car.getArr().get(7));     
			ps.setInt(9, car.getKm());    
			
			///where
			ps.setInt(10, userId);     
			ps.setString(11, car.getmarca());     
			ps.setString(12, car.getModel());    
			
    		ps.execute();
    	 } catch (Exception e2) {
		
    		 System.out.println(e2.toString());
    	 }
	}
	
	private void carListQuery() {
		String sql = "SELECT * from CarList WHERE OwnerId = ?";
		
		try (Connection con = Dbconnection.connect();
			 PreparedStatement ps = con.prepareStatement(sql)){ 
			
			ps.setString(1, String.valueOf(userId));
            
            try (ResultSet rs=ps.executeQuery()){
            	while (rs.next()) {
            		
                    Car newcar= new Car(rs.getString("Make"), rs.getString("Model"), rs.getInt("Year"), Combustibil.valueOf(rs.getString("Fuel")), rs.getInt("Kilometers"));
                    
                    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList( rs.getInt("OilKm"),  rs.getInt("FBrakeKm"),  rs.getInt("RBrakeKm"),  rs.getInt("BFluidKm"),  
                    														rs.getInt("SPlugsKm"),  rs.getInt("AirFilterKm"),  rs.getInt("ITPDate"),  rs.getInt("RovDate")));
                    
                    newcar.setArr(arr);
                    newcar.toString();
                    listModel.addElement( newcar);
                } 
            	    
				
            	
			} catch (Exception e2) {
				System.out.println(e2.toString());
			}
			        	
			        	
		} catch (SQLException e1) {
			System.out.println(e1.toString()); 	
		}
	}
	private void bdDelete(Car car) {
		String sql = "DELETE FROM CarList WHERE OwnerId=? AND Make=? AND Model=?";
    
    
		try (Connection con = Dbconnection.connect();
			 PreparedStatement ps = con.prepareStatement(sql)) { 
			
			///where
			ps.setInt(1, userId);     
			ps.setString(2, car.getmarca());     
			ps.setString(3, car.getModel());    
			
    		ps.execute();
    	 } catch (Exception e2) {
		
    		 System.out.println(e2.toString());
    	 }
	}
	
	
	
	private int checkNotifications() {
		
		int c=0;
			if(oilPanel.returnKm()<1000) {
				l1.addElement("Oil will need changing soon");
				c=1;
			}
			if(fBrakesPanel.returnKm()<1000) {
				l1.addElement("Front brakes will need changing soon");
			c=1;
			}
			if(rBrakesPanel.returnKm()<1000) {
				l1.addElement("Rear brakes will need changing soon");
			c=1;
			}
			if(bFluidPanel.returnKm()<1000) {
				l1.addElement("Brake fluid will need changing soon");
			c=1;
			}
			if(sPlugsPanel.returnKm()<1000) {
				l1.addElement("Spark plugs will need changing soon");
			c=1;
			}
			if(cFilterPanel.returnKm()<1000) {
				l1.addElement("Air filter will need changing soon");
			c=1;
			}
			if(ITPPanel.returnKm()<60) {
				l1.addElement("ITP will need to be retaken soon");
			c=1;
			}
			if(rovPanel.returnKm()<60) {
				l1.addElement("Rovignette will need to be repaid soon");
			c=1;
			}
			return c;
	}
}
