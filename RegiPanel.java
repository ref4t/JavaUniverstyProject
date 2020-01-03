package user.panel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import user.registration.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class RegiPanel extends JPanel implements ActionListener,MouseListener{
    
	JTextField fname,lname,email,birth;
	
	JPasswordField pass,rpass;
	
    JRadioButton male,female;
	
    JButton confirm,reset,back;
	
    JLabel label;
	
	String f_name, l_name, password, birthday, gender, emailadd, uname;
	
    Registration rr;
	
	Login log;
	
	
    private Pattern pattern;
	
    private Matcher matcher;
	
	  private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	
	//default constructor;
    public RegiPanel()
    {
    	this(null,null);
    }

    //constructor with parameter 
   public RegiPanel(Registration r,Login l)
   {
		
   	    rr=r;
		log=l;
		
		
		
	back=new JButton(new ImageIcon("Image/back3.JPG"));
    back.setBackground(Color.GRAY);
    back.setForeground(Color.GRAY);
    back.setOpaque(true);	
	 back.setBounds(10,10,27,24);	
		
		 this.gender="Male";
		
   	    label=new JLabel("Enter your information for registration. ");
        
		fname=new JTextField();
        lname=new JTextField();
        email=new JTextField();
		birth=new JTextField(); 
		
        pass=new JPasswordField();
        rpass=new JPasswordField();
          
        male=new JRadioButton("Male",true);
        female=new JRadioButton("Female",false);
		
		
	    confirm=new JButton("Confirm");
        reset=new JButton("Reset");
 
        this.setLayout(null);

    
    this.setBounds(0,0,500,600);
    
    label.setBounds(160,10,300,15);

    fname.setBounds(100,40,160,20);
    fname.setText("First Name");
    fname.setEditable(false);

    lname.setBounds(290,40,160,20);
    lname.setText("Last Name");
    lname.setEditable(false);
    
    email.setBounds(100,80,350,20);
    email.setText("Email");
    email.setEditable(false);

    pass.setBounds(100,105,350,20);
    pass.setText("Password");
    pass.setEditable(false);
	pass.setEchoChar((char) 0);

    rpass.setBounds(100,130,350,20);
    rpass.setText("Re-type Password");
    rpass.setEditable(false);
	rpass.setEchoChar((char) 0);
    
    birth.setBounds(100,155,350,20);
    birth.setText("Age");
    birth.setEditable(false);

    male.setBounds(100,180,100,30);
    female.setBounds(100,200,100,50);

    confirm.setBounds(100,260,100,20);
    reset.setBounds(220,260,100,20);

    fname.addMouseListener(this);
    lname.addMouseListener(this);
    email.addMouseListener(this);
    pass.addMouseListener(this);
    rpass.addMouseListener(this);
    birth.addMouseListener(this);
    male.addMouseListener(this);
    female.addMouseListener(this);
     
	confirm.addActionListener(this);
    reset.addActionListener(this);
	male.addActionListener(this);
	female.addActionListener(this);
    back.addActionListener(this);


    this.add(label);
    this.add(fname);
    this.add(lname);
    this.add(email);
    this.add(pass);
    this.add(rpass);
    this.add(birth);
    this.add(male);
    this.add(female);
    this.add(confirm);
    this.add(reset);
	this.add(back);
   }

   //method for working with mouse enter listener
   public void mouseEntered(MouseEvent me)
	{
		
	    if(me.getSource().equals(fname))
		   {
	      	if(fname.getText().equals("First Name"))
	         {
			      fname.setEditable(true);
			      fname.setText("Enter");
		        }
   	       }
	       
		else if(me.getSource().equals(lname))
		{
			if(lname.getText().equals("Last Name"))
			{
            lname.setEditable(true);
			lname.setText("Enter");
		    }
		}
		
	    else if(me.getSource().equals(email))
		{
			if(email.getText().equals("Email"))
			{
            email.setEditable(true);
			email.setText("Enter");
		    }
		}
		
		else if(me.getSource().equals(pass))
		{
			if(pass.getPassword().equals("Password"))
			{
            pass.setEditable(true);
			pass.setText("Enter");
		    }
		}
		
		else if(me.getSource().equals(rpass))
		{
			if(rpass.getPassword().equals("Re-type Password"))
			{
            rpass.setEditable(true);
			rpass.setText("Enter");
		    }
		}

		else if(me.getSource().equals(birth))
		{
			if(birth.getText().equals("Age"))
			{
            birth.setEditable(true);
			birth.setText("Enter");
		    }
		}

	}
	
	//method for working with mouse exit listener
	public void mouseExited(MouseEvent me)
	{
	   if(me.getSource().equals(fname))
		{
			if(fname.getText().equals("Enter"))
			{
			fname.setEditable(false);
			fname.setText("First Name");
		   }
		}
		else if(me.getSource().equals(lname))
		{
			if(lname.getText().equals("Enter"))
			{
            lname.setEditable(false);
			lname.setText("Last Name");
		    }
		}
		
		else if(me.getSource().equals(email))
		{
			if(email.getText().equals("Enter"))
			{
            email.setEditable(false);
			email.setText("Email");
		    }
		}
		
		else if(me.getSource().equals(pass))
		{
			if(pass.getPassword().equals("Enter"))
			{
            pass.setEditable(false);
			pass.setText("Password");
		    }
		}
		
		else if(me.getSource().equals(rpass))
		{
			if(rpass.getPassword().equals("Enter"))
			{
            rpass.setEditable(false);
			rpass.setText("Re-type Password");
			
		    }
		}
		
		else if(me.getSource().equals(birth))
		{
			if(birth.getText().equals("Enter"))
			{
            birth.setEditable(false);
			birth.setText("Age");
		    }
		}

	}
	
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	
	//method for working with mouse click listener
	public void mouseClicked(MouseEvent me)
		{
    	 if(me.getSource().equals(fname))
	         {
			      fname.setEditable(true);
			      fname.setText(null);
	        }
   	          
		else if(me.getSource().equals(lname))
		{
			
            lname.setEditable(true);
			lname.setText(null);
		  
		}
	    else if(me.getSource().equals(email))
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
		else if(me.getSource().equals(rpass))
		{
			
            rpass.setEditable(true);
			rpass.setText(null);
		    rpass.setEchoChar('*');
		}
		else if(me.getSource().equals(birth))
		{
			
            birth.setEditable(true);
			birth.setText(null);
		  
		}
		else if(me.getSource().equals(male))
		{
			female.setSelected(false);
            male.setSelected(true);
			this.gender="Male";
		  
		}
		else if(me.getSource().equals(female))
		{
			male.setSelected(false);
            female.setSelected(true);
		    this.gender="Female";
		}

	}
	
	//method for action perform
	public void actionPerformed(ActionEvent ae)
	{
	
		 if(ae.getSource().equals(reset))
		{
			resetAll();
		}
		else if(ae.getSource().equals(confirm))
		{
			confirmed();
		}
		else if(ae.getSource().equals(back))
		{
			log.setVisible(true);
			rr.setVisible(false);
		}

	}

	//method for reset all values
	public void resetAll()
	{
		 fname.setText("First Name");
		 lname.setText("Last Name");
		 email.setText("Email");
		 pass.setText("Password");
		 pass.setEchoChar((char) 0);
		 rpass.setText("Re-type Password");
         rpass.setEchoChar((char) 0);		
		birth.setText("Age");
		 male.setSelected(true);
		 female.setSelected(false);
	}

	//method for setting value
	public void confirmed()
	{
		System.out.println(pass.getPassword()+"  "+rpass.getPassword());
		if(pass.getText().equals(rpass.getText()))
		{

			
			
			this.f_name=String.valueOf(fname.getText());
			this.l_name=String.valueOf(lname.getText());
			this.password=String.valueOf(pass.getPassword());
			this.birthday=String.valueOf(birth.getText());
			this.emailadd=String.valueOf(email.getText());
			boolean vr=emailVerifie();
			if(vr==false)
			{
				JOptionPane.showMessageDialog(null,"Email address pattern wrong");
				resetAll();
			}
			else{
			// String result = JOptionPane.showInputDialog(this, "Enter a user name (As you like) : ");
			// this.uname=result;
			 createDb();
	         JOptionPane.showMessageDialog(null,"Registration Success");
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Password don't matched");
			resetPassword();
		}
	}
	
	public void resetPassword()
	{
		pass.setText("Password");
		pass.setEchoChar((char) 0);
		rpass.setText("Re-type Password");
		rpass.setEchoChar((char) 0);
	}
	
	public String getFirstName()
	{
		return f_name;
	}
	
	public String getLastName()
	{
		return l_name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getBirth()
	{
		return this.birthday;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public String getEmail()
	{
		return emailadd;
	}

	/*public String getUserName()
	{
		return uname;
	}*/
	public boolean emailVerifie()
	{
		pattern = Pattern.compile(EMAIL_PATTERN);
		  matcher = pattern.matcher(emailadd);
        return matcher.matches();
	}
	
	//method for create database
   public void createDb()
   {
	  CreateDB create =new CreateDB(this);
	      
		 log.setVisible(true);
      	 rr.setVisible(false);
   }
   
}//end of class