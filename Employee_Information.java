package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Employee_Information extends JFrame implements ActionListener{

	JTable t1;
	JButton b1 , b2;
	JLabel l1 , l2 , l3 , l4 , l5 , l6 , l7, l8 , l9;
	
	Employee_Information(){
			
		setLocation(210,70);
		setSize(1250,650);
		
		l1 = new JLabel("Name");
		l1.setLocation(70,10);
		l1.setSize(70,20);
		l1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l1);
		
		l2 = new JLabel("Age");
		l2.setLocation(210,10);
		l2.setSize(70,25);
		l2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l2);
		
		l3 = new JLabel("Gender");
		l3.setLocation(350,10);
		l3.setSize(70,25);
		l3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l3);
		
		l4 = new JLabel("Department");
		l4.setLocation(490,10);
		l4.setSize(100,25);
		l4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l4);
		
		l5 = new JLabel("Salary");
		l5.setLocation(660,10);
		l5.setSize(100,25);
		l5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l5);
		
		l6 = new JLabel("Phone");
		l6.setLocation(810,10);
		l6.setSize(100,25);
		l6.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l6);
		
		l7 = new JLabel("Aadhar");
		l7.setLocation(960,10);
		l7.setSize(100,25);
		l7.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l7);
		
		l8 = new JLabel("Email");
		l8.setLocation(1120,10);
		l8.setSize(100,25);
		l8.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l8);
		
		t1 = new JTable();
		t1.setLocation(15, 50);
		t1.setSize(1200 , 500);
		add(t1);
		
		b1 = new JButton("Load Data");
		b1.setLocation(450,560);
		b1.setSize(120,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setLocation(630,560);
		b2.setSize(120,30);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setFocusable(false);
        b2.addActionListener(this);
		add(b2);
		
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		
	}
	
public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				Connect c = new Connect();
				String str = "select * from employee";
				ResultSet rs = c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				t1.setGridColor(Color.BLUE);
				
			}
			catch(Exception e){}
		}
		
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	
public static void main(String[] args) {

		new Employee_Information();
}
}
