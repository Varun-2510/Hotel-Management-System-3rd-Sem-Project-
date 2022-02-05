package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login_Frame extends JFrame implements ActionListener{

    JLabel l1,l2;
    JButton b1,b2;
    
    Login_Frame(){
    	
        setLocation(500,250);
        setSize(650,360);
    	
		l1 = new JLabel(" LOGIN ");
        l1.setLocation(250,30);
        l1.setSize(200,80);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN ,38));
		add(l1);
        
        b1 = new JButton("ADMIN");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setLocation(100,200);
        b1.setSize(200,50);
        b1.setFont(new Font("Tahoma", Font.PLAIN ,28));
        b1.setFocusable(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("EMPLOYEE");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setLocation(350,200);
        b2.setSize(200,50);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,28));
        b2.setFocusable(false);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login_frame.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setLocation(0,0);
        l2.setSize(870,330);
        add(l2);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setVisible(true);
    }
    
        
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== b1) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
			new Login_Employee().setVisible(true);
		}
	}
    

public static void main(String[] args) {

new Login_Frame();

}

}
