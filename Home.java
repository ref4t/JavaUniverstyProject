package user.home;

import user.home.option.*;
import user.panel.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
	private JLabel title,title1,title2;
	
	private JButton bgn , lrn, adv,logout;
	private JPanel panel,panel2,panel3;
	LoginPanel lp;
	public Home()
	{
		this(null);
	}
	
	public Home(LoginPanel l)
	{
		this.setTitle("Home");
		lp=l;
		lp.getLogin().setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,750);
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("Image/in.png");
	    this.setIconImage(icon.getImage());
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		
		title = new JLabel("WELCOME TO ");
		title.setBounds(150,85,400,40);
		//titelJFrame.setSize(200,150);
		title.setBackground(Color.WHITE);
		title.setForeground(Color.blue);
		title.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,45));
		title.setOpaque(true);
		panel.add(title);
		
		
		title1 = new JLabel("Your English");
		title1.setBounds(170,155,400,30);
		title1.setBackground(Color.WHITE);
		title1.setForeground(Color.blue);
		title1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,30));
		title1.setOpaque(true);
		panel.add(title1);
	
		title2 = new JLabel("Choose your option ");
		title2.setBounds(170,250,700,35);
		title2.setBackground(Color.WHITE);
		title2.setForeground(Color.blue);
		title2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,40));
		title2.setOpaque(true);
		panel.add(title2);	
		
		
		
		
		bgn = new JButton(new ImageIcon("Image/begin.png"));
		bgn.setBounds(220,300,216,66);
		bgn.setBackground(Color.RED);
		panel.add(bgn);
		lrn = new JButton(new ImageIcon("Image/learn.png"));
		lrn.setBounds(220,367,216,66);
		lrn.setBackground(Color.GRAY);
		panel.add(lrn);
		adv = new JButton(new ImageIcon("Image/advance.png"));
		adv.setBounds(220,434,216,66);
		adv.setBackground(Color.GREEN);
		panel.add(adv);
		
        logout = new JButton("LogOut");
		logout.setBounds(520,580,160,40);
		logout.setBackground(Color.RED);
		logout.setForeground(Color.white);
	    logout.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		panel.add(logout);

		
		
		this.add(panel);
		
		
		bgn.addActionListener(this);
		lrn.addActionListener(this);
		adv.addActionListener(this);
		logout.addActionListener(this);
		this.setVisible(true);
	}
	
	  public void actionPerformed(ActionEvent ae)
 	{
		 if(ae.getSource().equals(bgn))
	   {
	   	beginners b=new beginners(this);
		//this.setVisible (false);
		b.setVisible(true);
		this.setVisible (false);
	   }
        else if(ae.getSource().equals(lrn))
		{
			Learners l=new Learners(this);
		//this.setVisible (false);
		l.setVisible(true);
		this.setVisible (false);
		}
        else if(ae.getSource().equals(adv))
		{
			Advance a=new Advance(this);
		//this.setVisible (false);
		a.setVisible(true);
		this.setVisible (false);
		}
        else if(ae.getSource().equals(logout)){
			//LoginPanel lp=new LoginPanel();
			lp.getLogin().setVisible(true);
			lp.reset();
			this.setVisible(false);

		}		
		 
	}   
}