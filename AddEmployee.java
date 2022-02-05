package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;						// Awt [ Abstract Window Toolkit ]
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener{
	
	JLabel name , age , gender , job , salary , phone , aadhar , email , l1 , l2;
	JTextField t1 , t2 , t3 , t4 , t5 , t6;
	JRadioButton r1 , r2;
	JButton b1;
	JComboBox c1;

	AddEmployee(){
		
		setLocation(400,130);
		setSize(850,560);
		
		name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.PLAIN ,20));
		name.setLocation(60,30);
		name.setSize(120,30);
		add(name);
		
		t1 = new JTextField();
		t1.setLocation(180,30);
		t1.setSize(160,30);
		add(t1);
		
		age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.PLAIN ,20));
		age.setLocation(60,90);
		age.setSize(120,30);
		add(age);
		
		t2 = new JTextField();
		t2.setLocation(180,90);
		t2.setSize(160,30);
		add(t2);
		
		gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.PLAIN ,20));
		gender.setLocation(60,140);
		gender.setSize(120,30);
		gender.setBackground(Color.white);
		add(gender);
		
		r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN ,18));
		r1.setLocation(170, 140);
		r1.setSize(85,30);
        r1.setFocusable(false);
		r1.setBackground(Color.white);
		add(r1);

		r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN ,18));
		r2.setLocation(255, 140);
		r2.setSize(110,30);
        r2.setFocusable(false);
		r2.setBackground(Color.white);
		add(r2);
		
		job = new JLabel("Job");
        job.setFont(new Font("Tahoma", Font.PLAIN ,20));
		job.setLocation(60,190);
		job.setSize(120,30);
		add(job);
		
		String job[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
		c1 = new JComboBox(job);
		c1.setLocation(180 , 190);
		c1.setSize(160,30);
		c1.setFont(new Font("Tahoma", Font.PLAIN ,16));
		c1.setBackground(Color.white);
		add(c1);
		
		salary = new JLabel("Salary");
		salary.setFont(new Font("Tahoma", Font.PLAIN ,20));
		salary.setLocation(60,240);
		salary.setSize(120,30);
		add(salary);
		
		t3 = new JTextField();
		t3.setLocation(180,240);
		t3.setSize(160,30);
		add(t3);
		
		phone = new JLabel("Phone");
		phone.setFont(new Font("Tahoma", Font.PLAIN ,20));
		phone.setLocation(60,290);
		phone.setSize(120,30);
		add(phone);
		
		t4 = new JTextField();
		t4.setLocation(180,290);
		t4.setSize(160,30);
		add(t4);
		
		aadhar = new JLabel("Aadhar");
		aadhar.setFont(new Font("Tahoma", Font.PLAIN ,20));
		aadhar.setLocation(60,340);
		aadhar.setSize(120,30);
		add(aadhar);
		
		t5 = new JTextField();
		t5.setLocation(180,340);
		t5.setSize(160,30);
		add(t5);
		
		email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.PLAIN ,20));
		email.setLocation(60,390);
		email.setSize(120,30);
		add(email);
		
		t6 = new JTextField();
		t6.setLocation(180,390);
		t6.setSize(160,30);
		add(t6);
		
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/staff.jpg"));
        Image i2 = i1.getImage().getScaledInstance(460, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setLocation(355,50);
        l1.setSize(500,500);
        add(l1);
        
        l2 = new JLabel("ADD EMPLOYEE DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setLocation(430,25);
        l2.setSize(400,30);
    	l2.setFont(new Font("Tahoma", Font.PLAIN ,30));
        add(l2);
		
        getContentPane().setBackground(Color.WHITE);
        
        b1 = new JButton("Add");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setLocation(180,450);
        b1.setSize(160,30);
		b1.setFont(new Font("Tahoma", Font.PLAIN ,20));
        b1.setFocusable(false);
        b1.addActionListener(this);
        add(b1);
        
        
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {

		String name	=	t1.getText();
		String age 	= 	t2.getText();
		String salary = t3.getText();
		String phone = 	t4.getText();
		String aadhar = t5.getText();
		String email = 	t6.getText();
		
		String gender = null;
		if(r1.isSelected()) {
			gender = "Male";
		}
		else if(r2.isSelected()) {
			gender = "Female";
		}
		
		String job =(String) c1.getSelectedItem();
		
	try {
		Connect c = new Connect();
        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
		
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"New Employee Added");
				this.setVisible(false);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
public static void main(String[] args) {

	new AddEmployee().setVisible(true);
}
}
