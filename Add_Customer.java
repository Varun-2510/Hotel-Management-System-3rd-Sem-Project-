package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Add_Customer extends JFrame implements ActionListener{
	
	JLabel l1 , l2 , l3 , l4 , l5 , l6 , l7 ,l8 , l9 , l10 , l11 ,l12;
	JTextField t1 , t2 , t3 , t4 , t5 , t6 ,t7;
	JButton b1 ,b2;
	JComboBox c1;
	Choice c2;
	JRadioButton r1 , r2;
	
	Add_Customer(){
		
		setLocation(330,68);
		setSize(1030,660);
		
		l1 = new JLabel("New Customer Form");
		l1.setFont(new Font("Tahoma", Font.PLAIN ,35));
		l1.setLocation(110,5);
		l1.setSize(320,30);
        l1.setForeground(Color.BLUE);
		add(l1);
		
		l2 = new JLabel("ID");
		l2.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l2.setLocation(60,70);
		l2.setSize(150,30);
		add(l2);
		
		c1 = new JComboBox(new String[] {"Aadhar Card " , "Passport" , "Voter-id Card", "Pan Card" ,"Driving License"});
		c1.setLocation(360,70);
		c1.setSize(150,30);
		c1.setBackground(Color.white);
        c1.setFocusable(false);
		add(c1);
		
		l3 = new JLabel("Number");
		l3.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l3.setLocation(60,120);
		l3.setSize(150,30);
		add(l3);
		
		t1 = new JTextField();
		t1.setLocation(360,120);
		t1.setSize(150,30);
		add(t1);
		
		l4 = new JLabel("Name");
		l4.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l4.setLocation(60,170);
		l4.setSize(150,30);
		add(l4);
		
		t2 = new JTextField();
		t2.setLocation(360,170);
		t2.setSize(150,30);
		add(t2);
		
		l5 = new JLabel("Gender");
		l5.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l5.setLocation(60,220);
		l5.setSize(150,30);
		add(l5);
		
		r1 = new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		r1.setLocation(350, 220);
		r1.setSize(80,30);
        r1.setFocusable(false);
		r1.setBackground(Color.white);
		add(r1);

		r2 = new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		r2.setLocation(428, 220);
		r2.setSize(110,30);
        r2.setFocusable(false);
		r2.setBackground(Color.white);
		add(r2);
		
		l6 = new JLabel("Country");
		l6.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l6.setLocation(60,270);
		l6.setSize(150,30);
		add(l6);
		
		t3 = new JTextField();
		t3.setLocation(360,270);
		t3.setSize(150,30);
		add(t3);
		
		l7 = new JLabel("Allocated Room Number");
		l7.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l7.setLocation(60,320);
		l7.setSize(220,30);
		add(l7);
		
		c2 = new Choice();
		try {
			Connect c = new Connect();
			String str = "select * from room where available = 'Available'";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next()){
				c2.add(rs.getString("room_number"));
			}
			
		}catch (Exception e) {}
		c2.setLocation(360,320);
		c2.setSize(150,30);
		c2.setFocusable(false);
		add(c2);
		
		l8 = new JLabel("Checked In Status");
		l8.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l8.setLocation(60,370);
		l8.setSize(163,30);
		add(l8);
		
		t4 = new JTextField();
		t4.setLocation(360,370);
		t4.setSize(150,30);
		add(t4);
		
		l9 = new JLabel("Checked In Date");
		l9.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l9.setLocation(60,420);
		l9.setSize(150,30);
		add(l9);
			
		t5 = new JTextField();
		t5.setLocation(360,420);
		t5.setSize(150,30);
		add(t5);
		
		SimpleDateFormat Date = new SimpleDateFormat("yyyy / MM / dd");
		Calendar cal = Calendar.getInstance();
		t5.setText(Date.format(cal.getTime()));
        t5.setFocusable(false);
		t5.setBackground(Color.white);
		t5.setEditable(false);
		
		l11 = new JLabel("Number of Days");
		l11.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l11.setLocation(60,470);
		l11.setSize(150,30);
		add(l11);
		
		t7 = new JTextField();
		t7.setLocation(360,470);
		t7.setSize(150,30);
		add(t7);
		
		l10 = new JLabel("Deposit");
		l10.setFont(new Font("Tahoma", Font.PLAIN ,20));
		l10.setLocation(60,520);
		l10.setSize(150,30);
		add(l10);
		
		t6 = new JTextField();
		t6.setLocation(360,520);
		t6.setSize(150,30);
		add(t6);
		
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setLocation(130,580);
        b1.setSize(160,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,20));
        b1.setFocusable(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setLocation(350,580);
        b2.setSize(160,30);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,20));
        b2.setFocusable(false);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/customer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l11 = new JLabel(i3);
        l11.setLocation(470,25);
        l11.setSize(600,600);
        add(l11);
		
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== b1) {
		String id =(String) c1.getSelectedItem();
		String number =	t1.getText();
		String name	= t2.getText();
		String gender = null;
		if(r1.isSelected()) {
			gender = "Male";
		}
		else if(r2.isSelected()) {
			gender = "Female";
		}
		
		String country	= t3.getText();
		String room_number = c2.getSelectedItem();
		String status	= t4.getText();
		String check_in_date   = t5.getText();
		String deposit	= t6.getText();
		String days = t7.getText();
		
		String str = "insert into customer (id,number,name,gender,country,room_number,status,deposit,days) values ( '"+id+"', '"+number+"', '"+name+"','"+gender+"', '"+country+"', '"+room_number+"','"+status+"', '"+deposit+"','"+days+"')";
		String str1 =  "update room set available = 'Occupied' where room_number = '"+room_number+"'";
		String str2 = "update customer set check_in_date = '"+check_in_date+"' where name = '"+name+"'";
		
		try {
			Connect c = new Connect();
	   
					c.s.executeUpdate(str);
					c.s.executeUpdate(str1);
					c.s.executeUpdate(str2);
					
					JOptionPane.showMessageDialog(null,"New Customer Added");
					new Reception().setVisible(true);
					this.setVisible(false);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource()== b2){
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	
public static void main(String[] args) {
	
	new Add_Customer();

}
}
