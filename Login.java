package user.registration;


import javax.swing.*;

import java.awt.*;
import java.util.*;
import user.panel.*;

public class Login extends JFrame{
 

public Login()
{
	this.setTitle("Start Page");
	this.setSize(500,600);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	ImageIcon icon = new ImageIcon("Image/in.png");
	this.setIconImage(icon.getImage());
   LoginPanel panel= new LoginPanel(this);
   panel.setLayout(null);
   this.add(panel);

}


}