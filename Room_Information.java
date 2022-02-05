package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.ResultSet;

public class Room_Information extends JFrame implements ActionListener{

	JTable t1;
	JButton b1 , b2;
	JLabel l1 , l2 , l3 , l4 , l5, l6;
	
	Room_Information(){
		setLocation(210,70);
		setSize(1250,650);
		
		l1 = new JLabel("Room Number");
		l1.setLocation(70,10);
		l1.setSize(115,20);
		l1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l1);
		
		l2 = new JLabel("Availability");
		l2.setLocation(285,10);
		l2.setSize(110,25);
		l2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l2);
		
		l3 = new JLabel("Clean Status");
		l3.setLocation(460,10);
		l3.setSize(130,25);
		l3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l3);
		
		l4 = new JLabel("Room Price");
		l4.setLocation(660,10);
		l4.setSize(130,25);
		l4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l4);
		
		l5 = new JLabel("Bed Type");
		l5.setLocation(860,10);
		l5.setSize(130,25);
		l5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l5);
		
		l6 = new JLabel("Room Type");
		l6.setLocation(1060,10);
		l6.setSize(130,25);
		l6.setFont(new Font("Tahoma", Font.PLAIN ,18));
		add(l6);
		
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
			String str = "select * from room";
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
	
	new Room_Information();
		
}
}
