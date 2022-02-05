package Hotel.Management.System;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener{

	JMenuBar menubar;
	JMenu m1 , m2 ,m3;
	JMenuItem menuitem1 , menuitem2, menuitem3 , menuitem4 ,menuitem5;
	
	DashBoard(){
		
		setLocation(0,0);
		setSize(1610,865);
			
		menubar  = new JMenuBar();
		add(menubar);
		
		m1  = new JMenu("HOTEL MANAGEMENT");
		m1.setForeground(Color.BLUE);
		menubar.add(m1);
		
		m2  = new JMenu("ADMIN");
		m2.setForeground(Color.BLUE);
		menubar.add(m2);
		
		m3  = new JMenu("EXIT");
		m3.setForeground(Color.BLUE);
		menubar.add(m3);
		
		menuitem1 = new JMenuItem("RECEPTION");
		menuitem1.addActionListener(this);
		m1.add(menuitem1);
		
		menuitem2 = new JMenuItem("ADD EMPLOYEES");
		menuitem2.addActionListener(this);
		m2.add(menuitem2);
		
		menuitem3 = new JMenuItem("ADD ROOMS");
		menuitem3.addActionListener(this);
		m2.add(menuitem3);
		
		menuitem4 = new JMenuItem("ADD EMPLOYEE ID");
		menuitem4.addActionListener(this);
		m2.add(menuitem4);
		
		menuitem5 = new JMenuItem("LOGOUT");
		menuitem5.addActionListener(this);
		m3.add(menuitem5);
		
		
		menubar.setLocation(0,0);
		menubar.setSize(1600,30);
		
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/background.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1590, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setLocation(0,0);
        l1.setSize(1585,860);
        add(l1);
        
        JLabel l2 = new JLabel("THE SUNSHINE GROUP WELCOMES YOU");
        l2.setLocation(250,685);
        l2.setSize(1350,90);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif", Font.PLAIN ,60));
        l1.add(l2);
        
        
        setLayout(null);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD EMPLOYEES")) {
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD EMPLOYEE ID")) {
			new Add_Employee_ID().setVisible(true);
		}
		else if(ae.getActionCommand().equals("LOGOUT")) {
			this.setVisible(false);
		}
		
	}
	
public static void main(String[] args) {

	new DashBoard().setVisible(true);
}
}
