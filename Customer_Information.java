package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customer_Information extends JFrame implements ActionListener{

	JTable t1;
	JButton b1 , b2;
	JLabel l1 , l2 , l3 , l4 , l5 , l6 , l7, l8 , l9, l10 , l11;
	
	Customer_Information(){
			
		setLocation(70,70);
		setSize(1500,650);
		
		l1 = new JLabel("Document Type");
		l1.setLocation(10,15);
		l1.setSize(125,20);
		l1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l1);
		
		l2 = new JLabel("Number");
		l2.setLocation(175,10);
		l2.setSize(70,25);
		l2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l2);
		
		l3 = new JLabel("Name");
		l3.setLocation(315,10);
		l3.setSize(70,25);
		l3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l3);
		
		l4 = new JLabel("Gender");
		l4.setLocation(455,10);
		l4.setSize(70,25);
		l4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l4);
		
		l5 = new JLabel("Country");
		l5.setLocation(580,10);
		l5.setSize(80,25);
		l5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l5);
		
		l6 = new JLabel("Room Number");
		l6.setLocation(685,10);
		l6.setSize(115,25);
		l6.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l6);
		
		l7 = new JLabel("Checked Status");
		l7.setLocation(815,10);
		l7.setSize(130,25);
		l7.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l7);
		
		l8 = new JLabel("Amount Paid");
		l8.setLocation(960,10);
		l8.setSize(128,25);
		l8.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l8);
		
		l9 = new JLabel("Check-In Date");
		l9.setLocation(1090,10);
		l9.setSize(135,25);
		l9.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l9);
		
		l10 = new JLabel("Check-Out Date");
		l10.setLocation(1215,10);
		l10.setSize(135,25);
		l10.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l10);
		
		l10 = new JLabel("Number of Days");
		l10.setLocation(1350,10);
		l10.setSize(160,25);
		l10.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l10);
		
		t1 = new JTable();
		t1.setLocation(10, 50);
		t1.setSize(1300 , 500);
		add(t1);
		
		b1 = new JButton("Load Data");
		b1.setLocation(600,560);
		b1.setSize(120,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setLocation(750,560);
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
				String str = "select * from customer";
				ResultSet rs = c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				t1.setGridColor(Color.BLUE);
				t1.setSize(1470,100);
				
			}
			catch(Exception e){}
		}
		
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	
public static void main(String[] args) {

		new Customer_Information();
}
}

 