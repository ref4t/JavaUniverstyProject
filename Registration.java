 package user.registration;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import user.panel.RegiPanel;


public class Registration extends JFrame{
    Login log;	
	public Registration(Login l)
	{
       log=l;
       this.setTitle("Registration");
	this.setSize(550,600);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	ImageIcon icon = new ImageIcon("Image/in.png");
	this.setIconImage(icon.getImage());
	RegiPanel rp= new RegiPanel(this,log);
	this.add(rp);

	}



}
