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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Car;

public class MainFrame1 extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame();
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
		Car currentCar;
		CarInfo carInfo;
		JPanel sMenu = new JPanel();
			int kmOil;
			int kmFBrakes;
			int kmRBrakes;
			int kmBFluid;
			int kmSPlugs;
			int kmAFilter;
			int daysITP;
			int daysRov;
	
			
	
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
			carInfo = new CarInfo(currentCar);
			carInfo.fillEmpty();
	
				//----------------------SERVICE MENU-----------------------------------------------------
			
			 fillPanel();
			sMenu.setLayout(new GridLayout(3, 3, 0, 0));
			sMenu.setBackground(new Color(0xeef2f9));
			sMenu.setPreferredSize(new Dimension(732,568));
			
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/oil.png"), "Oil change", 10000, kmOil));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/fBrake.png"), "Front brakes", 35000, kmFBrakes));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/rBrake.png"), "Rear brakes", 55000, kmRBrakes));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/bFluid.png"), "Brake fluid", 40000, kmBFluid));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/sPlugs.png"), "Spark plugs", 90000, kmSPlugs));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/cFilter.png"), "Air Filter", 15000, kmAFilter));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/ITP.png"), "ITP", 365, daysITP));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/rov.png"), "Rovinieta", 365, daysRov));
			sMenu.add(new ServicePanel(new ImageIcon("src/serviceIcons/Other.png"), "Other", 100, 100));
				
				//--------------------------------RIGHT PANEL SETUP---------------------------------------------
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension(732,768));
		rightPanel.setBackground(new Color(0xeef2f9));
		rightPanel.add(carInfo, BorderLayout.NORTH);
		rightPanel.add(sMenu, BorderLayout.SOUTH);
		rightPanel.setBorder(BorderFactory.createMatteBorder(1, 17, 1, 1, Color.gray));

		carInfo.serSetup.addActionListener(carInfo);
		
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
                     }finally {}
                     
                 }
			 });
		 }
		
		if(e.getSource() == delB){
			int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.removeElementAt(selectedIndex);
                carInfo.fillEmpty();
            }
         
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		 if (!e.getValueIsAdjusting()) {
             int selectedIndex = list.getSelectedIndex();
             if (selectedIndex != -1) {
            	 currentCar = listModel.elementAt(selectedIndex);
                 carInfo.fillInfo(currentCar);
                 fillPanel();
             }
         }
			
	}
	
	public void fillPanel() {
		ArrayList<Integer> stats = carInfo.returnArr();
		kmOil= stats.get(0);
		kmFBrakes= stats.get(1);
		kmRBrakes= stats.get(2);
		kmBFluid= stats.get(3);
		kmSPlugs= stats.get(4);
		kmAFilter= stats.get(5);
		daysITP= stats.get(6);
		daysRov= stats.get(7);
	}

	
}
