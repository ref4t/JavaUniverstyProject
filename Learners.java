package user.home.option;

import user.home.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Learners extends JFrame implements MouseListener , ActionListener

{
	private JLabel title;
	
	
	
	
	private JPanel panel;
	
    private Home h;
	private JButton btn1,btn2,btn3,btn4,btn5,back;
	
	public Learners(Home h)
	{
		super("Learner's Level");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.h=h;
		this.setSize(800,550);
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("Image/in.png");
	    this.setIconImage(icon.getImage());
	
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

	back=new JButton(new ImageIcon("Image/back1.png"));
	back.setBounds(10,20,56,54);
    back.setBackground(Color.WHITE);
    back.setForeground(Color.white);
    back.setOpaque(true);	
	panel.add(back);
  	
	title = new JLabel(" Choose an option");
	title.setBounds(140,20,800,60);
	title.setBackground(Color.BLUE);
	title.setForeground(Color.white);
	title.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	title.setOpaque(true);
	panel.add(title);
	
	btn1 = new JButton("Practice Grammer");
	btn1.setBounds(220,120,260,40);
	btn1.setBackground(Color.RED);
	btn1.setForeground(Color.white);
	btn1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn1);
	
	btn2 = new JButton("Random MIX");
	btn2.setBounds(220,180,260,40);
	btn2.setBackground(Color.RED);
	btn2.setForeground(Color.white);
	btn2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn2);
	btn3 = new JButton("Spelling Bee");
	btn3.setBounds(220,240,260,40);
	btn3.setBackground(Color.RED);
	btn3.setForeground(Color.white);
	btn3.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn3);

	btn4 = new JButton("Song Lyrics Challenges");
	btn4.setBounds(220,300,260,40);
	btn4.setBackground(Color.RED);
	btn4.setForeground(Color.white);
	btn4.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn4);

	/*btn5 = new JButton("Pronunciation");
	btn5.setBounds(220,360,260,40);
	btn5.setBackground(Color.RED);
	btn5.setForeground(Color.white);
	btn5.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn5);*/
	
	back.addActionListener(this);
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	btn3.addActionListener(this);
	btn4.addActionListener(this);
	//btn5.addActionListener(this);
	
		
		
	this.add(panel);
	//this.setVisible(true);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}

	 public void actionPerformed(ActionEvent ae)
 	{
		 if(ae.getSource().equals(back))
	   {
	   	 
	     this.h.setVisible(true);
	     this.setVisible(false);
	   }
        else if(ae.getSource().equals(btn1))
	   {
	   	 PractiseGrammerlrn pgl=new PractiseGrammerlrn(this);
	     pgl.setVisible(true);
	     this.setVisible(false);
	   }
        else if(ae.getSource().equals(btn2))
	   {
	   	 YourResponselrn yrl=new YourResponselrn(this);
	     yrl.setVisible(true);
	     this.setVisible(false);
	   }
        else if(ae.getSource().equals(btn3))
	   {
	   	 SpellingBeelrn sbl=new SpellingBeelrn(this);
	     sbl.setVisible(true);
	     this.setVisible(false);
	   }
        else if(ae.getSource().equals(btn4))
	   {
	   	 SongLyricslrn slr=new SongLyricslrn(this);
	     slr.setVisible(true);
	     this.setVisible(false);
	   }	   
	} 
		
	}

	
	




