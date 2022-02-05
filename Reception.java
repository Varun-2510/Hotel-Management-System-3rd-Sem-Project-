package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;


public class Reception extends JFrame implements ActionListener {
	
	JButton b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8 , b9 , b10 , b11 , b12;
	JLabel l1;
	
	Reception(){
		
		setLocation(420,145);
		setSize(800,530);
		
		b1 = new JButton("New Customer Form");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b1.setLocation(10 , 30);
		b1.setSize(250,30);
        b1.setFocusable(false);
        b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Room Information");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b2.setLocation(10 , 70);
		b2.setSize(250,30);
        b2.setFocusable(false);
        b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Department");
		b3.setBackground(Color.white);
		b3.setForeground(Color.black);
		b3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b3.setLocation(10 , 110);
		b3.setSize(250,30);
        b3.setFocusable(false);
        b3.addActionListener(this);
		add(b3);
		
		b4 = new JButton("All Employee Information");
		b4.setBackground(Color.white);
		b4.setForeground(Color.black);
		b4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b4.setLocation(10 , 150);
		b4.setSize(250,30);
        b4.setFocusable(false);
        b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("Customer Information");
		b5.setBackground(Color.white);
		b5.setForeground(Color.black);
		b5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b5.setLocation(10 , 190);
		b5.setSize(250,30);
		b5.setFocusable(false);
        b5.addActionListener(this);
		add(b5);
		
		b6 = new JButton("Manager Information");
		b6.setBackground(Color.white);
		b6.setForeground(Color.black);
		b6.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b6.setLocation(10 , 230);
		b6.setSize(250,30);
		b6.setFocusable(false);
        b6.addActionListener(this);
		add(b6);
		
		b7 = new JButton("Check Out");
		b7.setBackground(Color.white);
		b7.setForeground(Color.black);
		b7.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b7.setLocation(10, 270);
		b7.setSize(250,30);
		b7.setFocusable(false);
        b7.addActionListener(this);
		add(b7);
		
		b8 = new JButton("Update Check Status");
		b8.setBackground(Color.white);
		b8.setForeground(Color.black);
		b8.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b8.setLocation(10 , 310);
		b8.setSize(250,30);
		b8.setFocusable(false);
        b8.addActionListener(this);
		add(b8);
		
		b9 = new JButton("Update Room Status");
		b9.setBackground(Color.white);
		b9.setForeground(Color.black);
		b9.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b9.setLocation(10 , 350);
		b9.setSize(250,30);
		b9.setFocusable(false);
        b9.addActionListener(this);
		add(b9);
		
		b10 = new JButton("Search Room");
		b10.setBackground(Color.white);
		b10.setForeground(Color.black);
		b10.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b10.setLocation(10 , 390);
		b10.setSize(250,30);
        b10.setFocusable(false);
        b10.addActionListener(this);
		add(b10);
		
		b11 = new JButton("Logout");
		b11.setBackground(Color.white);
		b11.setForeground(Color.black);
		b11.setFont(new Font("Tahoma", Font.PLAIN ,18));
		b11.setLocation(10 , 430);
		b11.setSize(250,30);
        b11.setFocusable(false);
        b11.addActionListener(this);
		add(b11);		
		
	     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/Reception.jpg"));
	     Image i2 = i1.getImage().getScaledInstance(590, 500, Image.SCALE_DEFAULT);
	     ImageIcon i3 = new ImageIcon(i2);
	     l1 = new JLabel(i3);
	     l1.setLocation(250,10);
	     l1.setSize(600,510);
	     add(l1);
	        
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			new Add_Customer().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b2) {
			new Room_Information().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b3) {
			new Department().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b4) {
			new Employee_Information().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b5) {
			new Customer_Information().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b6) {
			new Manager_Information().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b7) {
			new Check_Out().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b8) {
			new Update_Check_Status().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b9) {
			new Update_Room().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b10) {
			new Search_Room().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b11) {
			setVisible(false);
		}
		
	}

public static void main(String[] args) {
	new Reception();
}
}
