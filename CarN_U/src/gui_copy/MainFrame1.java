package gui_copy;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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

public class MainFrame1 extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame();
	
	Car currentCar;
	
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
	
			
	
	public MainFrame1(){
//--------------------------------------------------LEFT PANEL------------------------------------------------------------
		// ---------------------------------------------BANNER--------------------------------------------
				notifButton = new JButton();
				notifButton.setIcon(notifIcon);
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
				username = new JLabel(" USER: user here ");
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
			carList.setBackground(new Color(0xd6e4ef));
			carList.setLayout(new FlowLayout());
			carList.add(addB);
			carList.add(delB);
			carList.add(scrollPane);
				
				// ----------------------------LEFT PANEL EDITS------------------------------------------------------
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setPreferredSize(new Dimension(292, 768));
		leftPanel.add(banner, BorderLayout.NORTH);
		leftPanel.add(carList, BorderLayout.SOUTH);
		
	
//-------------------------------------------------RIGHT PANEL---------------------------------------------------		
			
		
		//--------------------------------------------------------------------CAR INFO-------------------------------------------//
		fillEmpty();
		carInfo = new JPanel();
			
			leftInfoPanel = new JPanel();
			leftInfoPanel.setLayout(new BoxLayout(leftInfoPanel, BoxLayout.Y_AXIS));
			
				marca.setFont(new Font(null, Font.BOLD, 50)); 
				marca.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
				model.setFont(new Font(null, Font.BOLD, 25));
				an.setFont(new Font(null, Font.PLAIN, 20));
				combustibil.setFont(new Font(null, Font.PLAIN, 20));
			
			leftInfoPanel.setBackground(new Color(0xc7d3eb));
			leftInfoPanel.setPreferredSize(new Dimension(732/2, 200));
			leftInfoPanel.add(marca);
			leftInfoPanel.add(model);
			leftInfoPanel.add(an);
			leftInfoPanel.add(combustibil);
			
			rightInfoPanel = new JPanel();
			rightInfoPanel.setLayout(new BoxLayout(rightInfoPanel, BoxLayout.Y_AXIS));
			
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
			
			rightInfoPanel.setBackground(new Color(0xc7d3eb));
			rightInfoPanel.add(km);
			rightInfoPanel.add(changeKM);
			rightInfoPanel.add(serSetup);
	
	
									//--------set up carInfo panel-----
			carInfo.setPreferredSize(new Dimension(0, 159));
			carInfo.setBackground(new Color(0xc7d3eb));
			carInfo.setLayout(new BorderLayout());
			carInfo.add(leftInfoPanel, BorderLayout.WEST);
			carInfo.add(rightInfoPanel, BorderLayout.EAST);
			
			
			
			
			
	
		//-----------------------------------------------------SERVICE MENU-----------------------------------------------------
				oilButton.addActionListener(this);
				oilButton.setFocusable(false);
				oilButton.setBackground(null);
			oilPanel.add(oilButton, BorderLayout.CENTER);
			
				fBrakesButton.addActionListener(this);
				fBrakesButton.setFocusable(false);
				fBrakesButton.setBackground(null);
			fBrakesPanel.add(fBrakesButton, BorderLayout.CENTER);
			
				rBrakesButton.addActionListener(this);
				rBrakesButton.setFocusable(false);
				rBrakesButton.setBackground(null);
			rBrakesPanel.add(rBrakesButton, BorderLayout.CENTER);
			
				bFluidButton.addActionListener(this);
				bFluidButton.setFocusable(false);
				bFluidButton.setBackground(null);
			bFluidPanel.add(bFluidButton, BorderLayout.CENTER);
			
				sPlugsButton.addActionListener(this);
				sPlugsButton.setFocusable(false);
				sPlugsButton.setBackground(null);
			sPlugsPanel.add(sPlugsButton, BorderLayout.CENTER);
			
				cFilterButton.addActionListener(this);
				cFilterButton.setFocusable(false);
				cFilterButton.setBackground(null);
			cFilterPanel.add(cFilterButton, BorderLayout.CENTER);
			
				ITPButton.addActionListener(this);
				ITPButton.setFocusable(false);
				ITPButton.setBackground(null);
			ITPPanel.add(ITPButton, BorderLayout.CENTER);
			
				rovButton.addActionListener(this);
				rovButton.setFocusable(false);
				rovButton.setBackground(null);
			rovPanel.add(rovButton, BorderLayout.CENTER);
			
			
				JLabel otherLabel = new JLabel("Other");
				otherLabel.setPreferredSize(new Dimension(0,30));
				otherButton.addActionListener(this);
				otherButton.setFocusable(false);
				otherButton.setBackground(null);
				JProgressBar bar = new JProgressBar();
				bar.setPreferredSize(new Dimension(0,30));
				bar.setStringPainted(true);
				bar.setFont(new Font(null, Font.BOLD, 15));
				bar.setValue(0);
				bar.setBackground(Color.lightGray);
				bar.setString("");
				
				
			otherPanel.setBackground(null);
			otherPanel.setLayout(new BorderLayout());
			otherPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
			otherPanel.setPreferredSize(new Dimension(200,150));
			
			otherPanel.add(otherLabel,BorderLayout.NORTH);
			otherPanel.add(otherButton, BorderLayout.CENTER);
			otherPanel.add(bar, BorderLayout.SOUTH);
			
			
			
			sMenu.setLayout(new GridLayout(3, 3, 0, 0));
			sMenu.setBackground(new Color(0xeef2f9));
			sMenu.setPreferredSize(new Dimension(732,568));	
		
			sMenu.add(oilPanel);
			sMenu.add(fBrakesPanel);
			sMenu.add(rBrakesPanel);
			sMenu.add(bFluidPanel);
			sMenu.add(sPlugsPanel);
			sMenu.add(cFilterPanel);
			sMenu.add(ITPPanel);
			sMenu.add(rovPanel);
			sMenu.add(otherPanel);
				
				//--------------------------------RIGHT PANEL SETUP---------------------------------------------
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension(732,768));
		rightPanel.setBackground(new Color(0xeef2f9));
		rightPanel.add(carInfo, BorderLayout.NORTH);
		rightPanel.add(sMenu, BorderLayout.SOUTH);
		rightPanel.setBorder(BorderFactory.createMatteBorder(1, 17, 1, 1, Color.gray));

		
//----------------------------------------------------MAIN FRAME SETUP ------------------------------------------------------
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(1024, 768);
		frame.setResizable(false);
		frame.setTitle("Car n' U");
		
		frame.add(leftPanel, BorderLayout.WEST);
		frame.add(rightPanel, BorderLayout.EAST);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addB) {
			 AddCarFrame acf = new AddCarFrame();
			 
			 acf.addWindowListener(new java.awt.event.WindowAdapter() {
                 public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                     try {
                    	 listModel.addElement( acf.returnCar());
                     }catch (Exception e) {
						// TODO: handle exception
					}
                     
                 }
			 });
		 }
		
		if(e.getSource() == delB){
			int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
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
               	 	 
               	 	 	currentCar.setServiceVar(0, currentCar.getArr().get(0) - currentCar.getKm() - oldKm);
               	 	 	currentCar.setServiceVar(1, currentCar.getArr().get(1) - currentCar.getKm() - oldKm);
               	 		currentCar.setServiceVar(2, currentCar.getArr().get(2) - currentCar.getKm() - oldKm);
               	 		currentCar.setServiceVar(3, currentCar.getArr().get(3) - currentCar.getKm() - oldKm);
               	 		currentCar.setServiceVar(4, currentCar.getArr().get(4) - currentCar.getKm() - oldKm);
               	 		currentCar.setServiceVar(5, currentCar.getArr().get(5) - currentCar.getKm() - oldKm);
               	
               	 		oilPanel.setKm(currentCar.getArr().get(0));
               	 		fBrakesPanel.setKm(currentCar.getArr().get(1));
               	 		rBrakesPanel.setKm(currentCar.getArr().get(2));
               	 		bFluidPanel.setKm(currentCar.getArr().get(3));
               	 		sPlugsPanel.setKm(currentCar.getArr().get(4));
               	 		cFilterPanel.setKm(currentCar.getArr().get(5));
               	 }
   						
                }
			 });
			
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

                   
                   
                   
                }
			 });
			
		}
		
		//-------------------------------SERVICE PANEL BUTTONS-------------------------------------
	if(currentCar != null) {
		if(e.getSource()==oilButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + oilPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(0, 10000);
				oilPanel.setKm(currentCar.getArr().get(0));
			}
		}
		if(e.getSource()==fBrakesButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + fBrakesPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(1, 35000);
				fBrakesPanel.setKm(currentCar.getArr().get(1));
			}
		}
		if(e.getSource()==rBrakesButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + rBrakesPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(2, 55000);
				rBrakesPanel.setKm(currentCar.getArr().get(2));
			}
		}
		if(e.getSource()==bFluidButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + bFluidPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(3, 40000);
				bFluidPanel.setKm(currentCar.getArr().get(3));
			}
		}
		if(e.getSource()==sPlugsButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + sPlugsPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(4, 90000);
				sPlugsPanel.setKm(currentCar.getArr().get(4));
			}
		}
		if(e.getSource()==cFilterButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + cFilterPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(5, 15000);
				cFilterPanel.setKm(currentCar.getArr().get(5));
			}
		}
		if(e.getSource()==ITPButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + ITPPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(6, 365);
				ITPPanel.setKm(currentCar.getArr().get(6));
			}
		}
		if(e.getSource()==rovButton) {
			if(JOptionPane.showConfirmDialog( null, "Do you wish to reset " + rovPanel.label.getText() + "?", "Reset?", JOptionPane.YES_NO_OPTION) == 0) {
				currentCar.setServiceVar(7, 365);
				rovPanel.setKm(currentCar.getArr().get(7));
			}
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
}
