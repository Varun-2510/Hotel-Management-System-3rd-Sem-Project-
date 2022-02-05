package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;			
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener {
	JLabel room , room_number , room_available , status , price , type ,type1, l1 ,l2;
	JTextField t1 , t2 ;
	JComboBox c1, c2, c3 ,c4;
	JButton b1 , b2;
	
	AddRooms(){
		setLocation(340,165);
		setSize(985,540);
		
		room_number = new JLabel("Room Number");
		room_number.setFont(new Font("Tahoma", Font.PLAIN ,20));
		room_number.setLocation(60,50);
		room_number.setSize(160,30);
		add(room_number);
		
		t1 = new JTextField();
		t1.setLocation(280,50);
		t1.setSize(160,30);
		add(t1);
		
		room_available = new JLabel("Room Available");
		room_available.setFont(new Font("Tahoma", Font.PLAIN ,20));
		room_available.setLocation(60,110);
		room_available.setSize(190,30);
		add(room_available);
		
		String choice[] = {"Available" ,"Occupied"};
		c1 = new JComboBox(choice);
		c1.setLocation(280 , 110);
		c1.setSize(160,30);
		c1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		c1.setFocusable(false);
		c1.setBackground(Color.white);
		add(c1);
		
		status = new JLabel("Cleaning Status");
		status.setFont(new Font("Tahoma", Font.PLAIN ,20));
		status.setLocation(60,170);
		status.setSize(190,30);
		add(status);
		
		String choice1[] = {"Cleaned" ,"Dirty"};
		c2 = new JComboBox(choice1);
		c2.setLocation(280 , 170);
		c2.setSize(160,30);
		c2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		c2.setFocusable(false);
		c2.setBackground(Color.white);
		add(c2);
		
		price = new JLabel("Price");
		price.setFont(new Font("Tahoma", Font.PLAIN ,20));
		price.setLocation(60,230);
		price.setSize(190,30);
		add(price);
		
		t2 = new JTextField();
		t2.setLocation(280,230);
		t2.setSize(160,30);
		add(t2);
		
		type = new JLabel("Bed Type");
		type.setFont(new Font("Tahoma", Font.PLAIN ,20));
		type.setLocation(60,290);
		type.setSize(190,30);
		add(type);
		
		String choice2[] = {"Single Bed" ,"Double Bed" , "Triple Bed"};
		c3 = new JComboBox(choice2);
		c3.setLocation(280 , 290);
		c3.setSize(160,30);
		c3.setFont(new Font("Tahoma", Font.PLAIN ,18));
		c3.setFocusable(false);
		c3.setBackground(Color.white);
		add(c3);
		
		type1 = new JLabel("Room Type");
		type1.setFont(new Font("Tahoma", Font.PLAIN ,20));
		type1.setLocation(60,350);
		type1.setSize(190,30);
		add(type1);
		
		String choice3[] = {"AC" ,"Non AC"};
		c4 = new JComboBox(choice3);
		c4.setLocation(280 , 350);
		c4.setSize(160,30);
		c4.setFont(new Font("Tahoma", Font.PLAIN ,18));
		c4.setFocusable(false);
		c4.setBackground(Color.white);
		add(c4);
		
        b1 = new JButton("Add Room");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setLocation(60,430);
        b1.setSize(140,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,20));
        b1.setFocusable(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setLocation(250,430);
        b2.setSize(140,30);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,20));
        b2.setFocusable(false);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setLocation(455,40);
        l1.setSize(500,450);
        add(l1);
        
        l2 = new JLabel("ADD ROOM DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setLocation(570,5);
        l2.setSize(400,30);
    	l2.setFont(new Font("Tahoma", Font.PLAIN ,30));
        add(l2);
        
        getContentPane().setBackground(Color.WHITE);
        
		setLayout(null);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== b1) {
			
			String room_no = t1.getText();
			String available  = (String) c1.getSelectedItem();
			String Status = (String) c2.getSelectedItem();
			String Price = t2.getText();
			String bed_Type = (String) c3.getSelectedItem();
			String room_Type = (String) c4.getSelectedItem();
	
			Connect c = new Connect();
			
			try {

		        String str = "INSERT INTO Room values( '"+room_no+"', '"+available+"', '"+Status+"','"+Price+"', '"+bed_Type+"','"+room_Type+"')";
				
						c.s.executeUpdate(str);
						JOptionPane.showMessageDialog(null,"New Room Added");
						this.setVisible(false);
					
				}catch(Exception e) {
					System.out.println(e);
				}
		
		}
		else if(ae.getSource()== b2){
			this.setVisible(false);
		}
	}

public static void main(String[] args) {

		new AddRooms();
}

}
