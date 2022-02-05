package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class Update_Room extends JFrame implements ActionListener{

	JLabel l1 , l2 , l3 , l4 , l5 , l6, l7 , l8;
	JTextField t1 , t2 , t3 , t4 , t5;
	JButton b1 ,b2 , b3;
	Choice c1;
	
	Update_Room(){
		
		setLocation(340,110);
		setSize(1000,590);
		
		l1 = new JLabel("Update Room Status");
		l1.setFont(new Font("Tahoma", Font.PLAIN ,35));
		l1.setLocation(80,10);
		l1.setSize(320,40);
        l1.setForeground(Color.BLUE);
		add(l1);
		
		l2 = new JLabel("Room Number");
		l2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l2.setLocation(60,100);
		l2.setSize(130,20);
		add(l2);
		
		c1 = new Choice();
		try {
			Connect c = new Connect();
			String str = "select * from room";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next()){
				c1.add(rs.getString("room_number"));
			}
			
		}catch (Exception e) {}
		c1.setLocation(280,100);
		c1.setSize(150,30);
        c1.setFocusable(false);
		add(c1);
		
		l3 = new JLabel("Availability");
		l3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l3.setLocation(60,160);
		l3.setSize(130,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setLocation(280,160);
		t1.setSize(150,30);
		add(t1);
		
		l4 = new JLabel("Clean Status");
		l4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l4.setLocation(60,220);
		l4.setSize(130,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setLocation(280,220);
		t2.setSize(150,30);
		add(t2);
		
		l5 = new JLabel("Room Price");
		l5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l5.setLocation(60,280);
		l5.setSize(115,20);
		add(l5);
		
		t3 = new JTextField();
		t3.setLocation(280,280);
		t3.setSize(150,30);
		add(t3);
		
		l6 = new JLabel("Bed Type");	
		l6.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l6.setLocation(60,340);
		l6.setSize(115,20);
		add(l6);
		
		t4 = new JTextField();
		t4.setLocation(280,340);
		t4.setSize(150,30);
		add(t4);
		
		l7 = new JLabel("Room Type");
		l7.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l7.setLocation(60,400);
		l7.setSize(115,20);
		add(l7);
		
		t5 = new JTextField();
		t5.setLocation(280,400);
		t5.setSize(150,30);
		add(t5);
		
		b1 = new JButton("Check");
		b1.setLocation(30,480);
		b1.setSize(120,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setLocation(170,480);
		b2.setSize(120,30);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setFocusable(false);
        b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setLocation(310,480);
		b3.setSize(120,30);
		b3.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setFocusable(false);
        b3.addActionListener(this);
		add(b3);
		
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/update_room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 590, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l8 = new JLabel(i3);
        l8.setLocation(410,-40);
        l8.setSize(600,600);
        add(l8);
        
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== b1) {
			String s1 = c1.getSelectedItem();
			Connect c = new Connect();
			try {
				ResultSet rs = c.s.executeQuery("select * from room where room_number = '" +s1+ "'");
				while(rs.next()) {
					t1.setText(rs.getString("available"));
					t2.setText(rs.getString("status"));
					t3.setText(rs.getString("price"));
					t4.setText(rs.getString("bed_type"));
					t5.setText(rs.getString("room_type"));
				}
		} catch (Exception e) {
			System.out.println(e);
		}
			}
		
		else if(ae.getSource()== b2) {

			try {
				String s1 = c1.getSelectedItem();
				Connect c = new Connect();
				
				String available = t1.getText();
				String status = t2.getText();
				String price = t3.getText();
				String bed_type = t4.getText();
				String room_type = t5.getText();
				
				String str = "update room set available = '"+available+"',status = '"+status+"', price = '"+price+"',bed_type = '"+bed_type+"',room_type = '"+room_type+"' where room_number = '"+s1+"'";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"Room Updated Successfully");
				
				new Reception().setVisible(true);
				this.setVisible(false);
				}
				
		 catch (Exception e) {
			System.out.println(e);
		 }
	}
		
		else if(ae.getSource()== b3){
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	
public static void main(String[] args) {

	new Update_Room();
}
}
