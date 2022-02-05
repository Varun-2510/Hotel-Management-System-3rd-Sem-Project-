package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
	
		HotelManagementSystem(){
        setLocation(300,20);
        setSize(1000,807);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setLocation(0,0);
        l1.setSize(1000,807);
        add(l1);
        
        JLabel l2 = new JLabel("Hotel Management System");
        l2.setLocation(140,5);
        l2.setSize(980,100);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif", Font.PLAIN ,70));
        l1.add(l2);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setLocation(840,730);
        b1.setSize(100,30);
        b1.setFont(new Font("serif", Font.PLAIN ,25));
        b1.setFocusable(false);
        b1.addActionListener(this);
        l1.add(b1);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setVisible(true);
        
        while(true) {
        	l2.setVisible(false);
        	try {
        		Thread.sleep(500);
        	}catch(Exception e){}
        	
    		l2.setVisible(true);
    		try {
            	Thread.sleep(500);
    		}catch(Exception e) {}

}
}
		public void actionPerformed(ActionEvent ae) {
			new Login_Frame().setVisible(true);
			this.setVisible(false);
		}
  
public static void main(String[] args) {
	
 new HotelManagementSystem();
   
} 
}
 