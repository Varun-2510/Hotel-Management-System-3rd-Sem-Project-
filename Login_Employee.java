package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;

public class Login_Employee extends JFrame implements ActionListener {
	
	JLabel l1 , l2 , l3 , l4;
	JTextField t1;
	JPasswordField t2;
	JButton b1 , b2, b3;
	
	
	Login_Employee(){
		
        setLocation(450,250);
        setSize(650,350);

		l1 = new JLabel("Employee Login");
        l1.setLocation(75,0);
        l1.setSize(200,60);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("serif", Font.PLAIN ,30));
		add(l1);
		
		l2 = new JLabel("Username");
        l2.setLocation(40,70);
        l2.setSize(100,60);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif", Font.PLAIN ,20));
		add(l2);
		
		l3 = new JLabel("Password");
        l3.setLocation(40,130);
        l3.setSize(100,60);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("serif", Font.PLAIN ,20));
		add(l3);
		
		t1 = new JTextField();
		t1.setLocation(150,85);
		t1.setSize(150,30);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setLocation(150,150);
		t2.setSize(150,30);
		add(t2);
		
        b1 = new JButton("Login");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setLocation(25,230);
        b1.setSize(130,40);
        b1.setFont(new Font("serif", Font.PLAIN ,23));
        b1.setFocusable(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setLocation(180,230);
        b2.setSize(130,40);
        b2.setFont(new Font("serif", Font.PLAIN ,23));
        b2.setFocusable(false);
        b2.addActionListener(this);
        add(b2);
		
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(280, 310, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setLocation(310,0);
        l4.setSize(340,310);
        add(l4);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== b1) {
			String username = t1.getText();
			String password = t2.getText();
			
			Connect c = new Connect();
			
			String str = "select * from employee_login where username = '"+username+"' and password = '"+password+"'";
			try {
			ResultSet rs = c.s.executeQuery(str);
			
			if(rs.next()) {
				new Employee_DashBoard().setVisible(true);
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid Username and Password");
				this.setVisible(true);
			}
			}catch (Exception e) {}
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
			new Login_Frame().setVisible(true);
		}
	}
	
	
public static void main(String[] args) {

	new Login_Employee();
}
}
