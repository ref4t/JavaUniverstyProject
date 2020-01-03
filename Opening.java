package user.opening;

import user.registration.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Opening extends JFrame implements ActionListener
{
	JButton btn;
public Opening()
{
	this.setTitle("Your English");
	this.setSize(800,602);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	this.setResizable(false);
    ImageIcon icon = new ImageIcon("Image/in.png");
	this.setIconImage(icon.getImage());

	JLabel label=new JLabel(new ImageIcon("Image/logo.png"));
    btn=new JButton(new ImageIcon("Image/blank.png"));
    label.setBounds(0,0,800,582);
    btn.setBounds(252,470,300,80);
    btn.addActionListener(this);
    this.add(label);
    this.add(btn);
   
}
public void actionPerformed(ActionEvent ae)
	{
	   if(ae.getSource().equals(btn))
	   {
	   	 Login log=new Login();
	     log.setVisible(true);
	     this.setVisible(false);
	   }	
	}
}