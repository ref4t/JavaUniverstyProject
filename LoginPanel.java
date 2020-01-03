package user.panel;

import user.registration.*;
import user.home.Home;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;


public class LoginPanel extends JPanel implements MouseListener,ActionListener{
         
		 JButton regButton, logButton;

         JTextField email;
        
   		 JPasswordField pass;
		 
         JLabel lb1; 
         
		 JFrame jf;
		 
		 Login log;

public LoginPanel()
{
	this(null);
}
		 
 public LoginPanel(Login l)
 {
	 log=l;
 	
    regButton=new JButton("<html><i>Registration</i><html>");
	logButton=new JButton("<html><i>Log in</i><html>"+"<border-radius: 25px>");
    
	
	
	email=new JTextField(20);
	pass=new JPasswordField(20);
    pass.setEchoChar((char) 0);
	lb1=new JLabel();
    
    
    ImageIcon welcome = new ImageIcon("Image/welcome.jpg");
  
     this.setBounds(100,100,300,300);
   //  this.setLocationRelativeTo(null);

    lb1.setBounds(100,50,100,57);
   email.setBounds(50,150,200,20);
   pass.setBounds(50,172,200,20);
   logButton.setBounds(57,200,80,20);
   regButton.setBounds(140,200,100,20);

   email.setText("Email-Address");
   pass.setText("Password");
   email.setEditable(false);
    pass.setEditable(false);
   this.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.gray));
   
   this.add(lb1);
   this.add(email);
   this.add(pass);
   this.add(logButton);
   this.add(regButton);


   email.addMouseListener(this);
   pass.addMouseListener(this);

   regButton.addActionListener(this);
   logButton.addActionListener(this);
   lb1.setIcon(welcome);   
 }
 	public void mouseEntered(MouseEvent me)
	{
		
	    if(me.getSource().equals(email))
		   {
	      	if(email.getText().equals("Email-Address"))
	         {
			      email.setEditable(true);
			      email.setText("Enter");
		        }
   	       }
	       
		else if(me.getSource().equals(pass))
		{
			if(pass.getText().equals("Password"))
			{
            pass.setEditable(true);
			pass.setText("Enter");
		    }
		}
	}
	public void mouseExited(MouseEvent me)
	{
	   if(me.getSource().equals(email))
		{
			if(email.getText().equals("Enter"))
			{
			email.setEditable(false);
			email.setText("Email-Address");
		   }
		}
		else if(me.getSource().equals(pass))
		{
			if(pass.getText().equals("Enter"))
			{
            pass.setEditable(false);
			pass.setText("Password");
		    }
		}
	}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me)
		{
	      	 if(me.getSource().equals(email))
	         {
			      email.setEditable(true);
			      email.setText(null);
	        }
   	          
		else if(me.getSource().equals(pass))
		{
			
            pass.setEditable(true);
			pass.setText(null);
			pass.setEchoChar('*');
		  
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(regButton))
		{
			Registration rp=new Registration(log);
			rp.setVisible(true);
			log.setVisible(false);
		}
		else if(ae.getSource().equals(logButton))
		{
			login();
		}
	}
	public void login(){
	 
		 String p = new String(pass.getPassword());
		 boolean check=loginCheck(email.getText(),p);
		 if(check==false)
          JOptionPane.showMessageDialog(null,"Wrong Email or Password");
	     else
		 {
			 Home home=new Home(this);
			 home.setVisible(true);
			 log.setVisible(false);
		 }
	}
	public boolean loginCheck(String email,String pass)
	{
        Connection c=null;		
		ResultSet rs=null;
	    String remail=null;
	    String rpass=null;
	    String sql = "SELECT Email, Password "
                          + "FROM user WHERE user.Email =? AND user.Password =?";
	   try{
		   Class.forName("org.sqlite.JDBC");
		   c= DriverManager.getConnection("jdbc:sqlite:database/user.db");
			  PreparedStatement pstmt  = c.prepareStatement(sql);
			  pstmt.setString(1,email);
			  pstmt.setString(2,pass);
			  
			  rs  = pstmt.executeQuery();
			  while (rs.next()) {
			     remail=rs.getString("Email");
				 rpass=rs.getString("Password");
		   		// System.out.println(rpass+"  --  "+remail);
			  }  
		 }
		 catch (Exception e) {
            System.out.println(e.getMessage());
		 }
		if(email.equals(remail))
		{
			return true;
		   		
		}
		else 
		{
			return false;
		}
	}
	public Login getLogin(){
		return log;
	}
	public void reset() {
		email.setText("Email-Address");
		pass.setText("Password");
	}
}