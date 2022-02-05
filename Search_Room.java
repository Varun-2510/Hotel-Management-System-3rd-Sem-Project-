package Hotel.Management.System;


import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class Search_Room extends JFrame implements ActionListener{

	JLabel l1 , l2 , l3 , l4 , l5 , l6, l7;
	JButton b1 ,b2;
	JComboBox c1;
	JCheckBox c2;
	JTable table1;
	
	Search_Room(){
		
		setLocation(210,65);
		setSize(1245,650);
		
		l1 = new JLabel("Search for Room");
		l1.setFont(new Font("Tahoma", Font.PLAIN ,35));
		l1.setLocation(485,15);
		l1.setSize(320,40);
        l1.setForeground(Color.BLUE);
		add(l1);
		
		l2 = new JLabel("Room Bed Type");
		l2.setFont(new Font("Tahoma", Font.PLAIN ,25));
		l2.setLocation(95,100);
		l2.setSize(180,40);
		add(l2);
		
		String bed_type[] = {"Single Bed" , "Double Bed" , "Triple Bed"};
		c1 = new JComboBox(bed_type);
		c1.setLocation(310 , 105);
		c1.setSize(150,30);
		c1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		c1.setBackground(Color.white);
		c1.setFocusable(false);
		add(c1);
		
		c2 = new JCheckBox("Only Display Available");
		c2.setLocation(780 , 100);
		c2.setSize(270,30);
		c2.setFont(new Font("Tahoma", Font.PLAIN ,25));
		c2.setBackground(Color.white);
		c2.setFocusable(false);
		add(c2);
		
		l3 = new JLabel("Room Number");
		l3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l3.setLocation(105,175);
		l3.setSize(150,35);
		add(l3);
		
		l4 = new JLabel("Availability");
		l4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l4.setLocation(300,175);
		l4.setSize(150,35);
		add(l4);
		
		l5 = new JLabel("Clean Status");
		l5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l5.setLocation(470,175);
		l5.setSize(150,35);
		add(l5);
		
		l5 = new JLabel("Room Price");
		l5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l5.setLocation(660,175);
		l5.setSize(150,35);
		add(l5);
		
		l6 = new JLabel("Bed Type");
		l6.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l6.setLocation(845,175);
		l6.setSize(150,35);
		add(l6);
		
		l7 = new JLabel("Room Type");
		l7.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l7.setLocation(1020,175);
		l7.setSize(150,35);
		add(l7);
		
		table1 = new JTable();
		table1.setLocation(70 , 220);
		table1.setSize(1100,350);
		add(table1);
		
		b1 = new JButton("Load Data");
		b1.setLocation(450,570);
		b1.setSize(120,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setLocation(630,570);
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
				String str = "select * from room where bed_type = '"+c1.getSelectedItem()+"'";
				String str2 = "select * from room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
				
				ResultSet rs;
				
				if(c2.isSelected()) {
					rs = c.s.executeQuery(str2);
				table1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				else {
					rs = c.s.executeQuery(str);
					table1.setModel(DbUtils.resultSetToTableModel(rs));
				}
			}
			catch(Exception e){}
		}
		
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		new Search_Room();
		
}
}
