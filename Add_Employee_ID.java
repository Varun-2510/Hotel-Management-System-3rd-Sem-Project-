package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Employee_ID extends JFrame implements ActionListener{
	
    JLabel l1 , l2 , l3 ,l4;
    JTextField t1 ,t2;
    JButton b1,b2;
    
    Add_Employee_ID(){
    	
        setLocation(500,250);
        setSize(650,360);
    	
		l1 = new JLabel("Add Employee Id");
        l1.setLocation(70,5);
        l1.setSize(200,60);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.PLAIN ,26));
		add(l1);
        
		l2 = new JLabel("Username");
        l2.setLocation(40,70);
        l2.setSize(100,60);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.PLAIN ,20));
		add(l2);
		
		t1 = new JTextField();
		t1.setLocation(150,85);
		t1.setSize(150,30);
		add(t1);
        
		l3 = new JLabel("Password");
        l3.setLocation(40,130);
        l3.setSize(100,60);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.PLAIN ,20));
		add(l3);
        
		t2 = new JTextField();
		t2.setLocation(150,150);
		t2.setSize(150,30);
		add(t2);
        
        b1 = new JButton("Add");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setLocation(20,230);
        b1.setSize(140,30);
        b1.setFont(new Font("Tahoma", Font.PLAIN ,23));
        b1.setFocusable(false);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setLocation(180,230);
        b2.setSize(140,30);
		b2.setFont(new Font("Tahoma", Font.PLAIN ,23));
        b2.setFocusable(false);
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/employee_id.jpg"));
        Image i2 = i1.getImage().getScaledInstance(340, 330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4 = new JLabel(i3);
        l4.setLocation(340,-5);
        l4.setSize(280,315);
        add(l4);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
    	
        if(ae.getSource()==b1){
        	
            String username=t1.getText();
            String password=t2.getText();
            
            Connect c = new Connect();
  String str = "insert into employee_login value('" + username + "','" + password + "')";
  
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Employee-Id Added");
                this.setVisible(false);
                
            }catch(Exception e){
            	System.out.println(e);
            }
            
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
   
     public static void main(String[] args) {
        new Add_Employee_ID();
    }
}