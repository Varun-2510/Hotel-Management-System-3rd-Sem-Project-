package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class Update_Check_Status extends JFrame implements ActionListener{

	JLabel l1 , l2 , l3 , l4 , l5 , l6, l7 , l8 ,l9, l10;
	JTextField t1 , t2 , t3 , t4 , t5, t6, t7;
	JButton b1 ,b2 , b3;
	Choice c1;
	
	Update_Check_Status(){
		
		setLocation(340,68);
		setSize(1000,670);
		
		l1 = new JLabel("Check-In Details");
		l1.setFont(new Font("Tahoma", Font.PLAIN ,35));
		l1.setLocation(110,15);
		l1.setSize(320,40);
        l1.setForeground(Color.BLUE);
		add(l1);
		
		l2 = new JLabel("Customer Name");
		l2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l2.setLocation(60,100);
		l2.setSize(130,20);
		add(l2);
		
		c1 = new Choice();
		try {
			Connect c = new Connect();
			String str = "select * from customer where status = 'In' ";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next()){
				c1.add(rs.getString("name"));
			}
			
		}catch (Exception e) {}
		c1.setLocation(280,100);
		c1.setSize(150,30);
        c1.setFocusable(false);
		add(c1);
		
		l3 = new JLabel("Customer Id");
		l3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l3.setLocation(60,160);
		l3.setSize(130,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setLocation(280,160);
		t1.setSize(150,30);
		add(t1);
		
		l4 = new JLabel("Id Number");
		l4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l4.setLocation(60,220);
		l4.setSize(130,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setLocation(280,220);
		t2.setSize(150,30);
		add(t2);
		
		l5 = new JLabel("Room Number");
		l5.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l5.setLocation(60,280);
		l5.setSize(115,20);
		add(l5);
		
		t3 = new JTextField();
		t3.setLocation(280,280);
		t3.setSize(150,30);
		add(t3);
		
		l6 = new JLabel("Check Status");	
		l6.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l6.setLocation(60,340);
		l6.setSize(130,20);
		add(l6);
		
		t4 = new JTextField();
		t4.setLocation(280,340);
		t4.setSize(150,30);
		add(t4);
		
		l10 = new JLabel("Number of Days");	
		l10.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l10.setLocation(60,400);
		l10.setSize(160,20);
		add(l10);
		
		t7 = new JTextField();
		t7.setLocation(280,400);
		t7.setSize(150,30);
		add(t7);
		
		l7 = new JLabel("Amount Paid");
		l7.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l7.setLocation(60,460);
		l7.setSize(115,20);
		add(l7);
			
		t5 = new JTextField();
		t5.setLocation(280,460);
		t5.setSize(150,30);
		add(t5);
		
		l8 = new JLabel("Pending Amount");
		l8.setFont(new Font("Tahoma", Font.PLAIN ,18));
		l8.setLocation(60,520);
		l8.setSize(133,25);
		add(l8);
		
		t6 = new JTextField();
		t6.setLocation(280,520);
		t6.setSize(150,30);
		add(t6);
		
		b1 = new JButton("Check");
		b1.setLocation(30,580);
		b1.setSize(120,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setLocation(170,580);
		b2.setSize(120,30);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setFocusable(false);
        b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setLocation(310,580);
		b3.setSize(120,30);
		b3.setFont(new Font("Tahoma", Font.PLAIN ,18));
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setFocusable(false);
        b3.addActionListener(this);
		add(b3);
		
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/check_update_status.jpg"));
        Image i2 = i1.getImage().getScaledInstance(615, 595, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l9 = new JLabel(i3);
        l9.setLocation(400,0);
        l9.setSize(620,630);
        add(l9);
        
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}

	public void actionPerformed(ActionEvent ae) {
		
	if(ae.getSource()== b1) {
			String room = null;
			String deposit = null;
			String price = null;
			String days = null;
			int amount_paid;
			int actual_price;
			
			String s1 = c1.getSelectedItem();
			Connect c = new Connect();
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where name = '" +s1+ "'");
				while(rs.next()) {
					t1.setText(rs.getString("id"));
					t2.setText(rs.getString("number"));
					t3.setText(rs.getString("room_number"));
					t4.setText(rs.getString("status"));
					t5.setText(rs.getString("deposit"));
					t7.setText(rs.getString("days"));
					room = rs.getString("room_number");
					deposit = rs.getString("deposit");
					days = rs.getString("days");
				}
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" +room+ "'");
				while(rs2.next()) {
					price = rs2.getString("price");
								
					actual_price = Integer.parseInt(price) * Integer.parseInt(days);
					
					amount_paid = actual_price - Integer.parseInt(deposit);
					
					t6.setText(Integer.toString(amount_paid));
				}
			}
			
		 catch (Exception e) { System.out.println(e); }
			
		}
		else if(ae.getSource()== b2) {

			try {
				String s1 = c1.getSelectedItem();
				Connect c = new Connect();
				String room_number = t3.getText();
				String status = t4.getText();
				String deposit = t5.getText();
				String days = t7.getText();
				
				String str = "update customer set room_number = '"+room_number+"',status = '"+status+"',deposit = '"+deposit+"',days = '"+days+"' where name = '"+s1+"'";
				c.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null,"Data Updated Successfully");
				new Reception().setVisible(true);
				this.setVisible(false);
				}
			
			 catch (Exception e) { System.out.println(e); }
			
		}
		else if(ae.getSource()== b3){
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
public static void main(String[] args) {

	new Update_Check_Status();
}
}
