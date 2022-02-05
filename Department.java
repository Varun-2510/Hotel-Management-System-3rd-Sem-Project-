package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class Department extends JFrame implements ActionListener{

	JLabel l1 , l2 , l3;
	JButton b1 ,b2;
	JTable table1;
	
	Department(){
		
		setLocation(390,75);
		setSize(850,650);
		
		l1 = new JLabel("Department Details");
		l1.setFont(new Font("Tahoma", Font.PLAIN ,35));
		l1.setLocation(270,25);
		l1.setSize(320,40);
        l1.setForeground(Color.BLUE);
		add(l1);
		
		l2 = new JLabel("Department");
		l2.setFont(new Font("Tahoma", Font.PLAIN ,25));
		l2.setLocation(150,120);
		l2.setSize(180,40);
		add(l2);
		
		l3 = new JLabel("Budget");
		l3.setFont(new Font("Tahoma", Font.PLAIN ,25));
		l3.setLocation(570,120);
		l3.setSize(150,35);
		add(l3);

		table1 = new JTable();
		table1.setLocation(20 , 170);
		table1.setSize(800,350);
		add(table1);
		
		b1 = new JButton("Load Data");
		b1.setLocation(260,550);
		b1.setSize(150,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setLocation(470,550);
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

				String str = "select * from department";
				
				Connect c = new Connect();
				
				ResultSet rs = c.s.executeQuery(str);
				table1.setModel(DbUtils.resultSetToTableModel(rs));
				table1.setGridColor(Color.BLUE);
				table1.setFont(new Font("Tahoma", Font.PLAIN ,14));
			}
			catch(Exception e){}
		
	}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	
	}	
		
	public static void main(String[] args) {

		new Department();
		
}
}
