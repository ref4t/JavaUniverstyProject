package user.home.option;

import user.home.option.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;

public class SpellingBeebgn extends JFrame implements MouseListener , ActionListener

{
	private JLabel title;
	
	
	private JPanel panel;
	
	private beginners h;
	private JButton btn1,btn2,btn3,btn4,btn5,audioButton,back;
	//private ImageIcon img;
	private JTextField tf1,tf2;
    SpellingBeeBB sbee;

    AudioInputStream audioInputStream;
    Clip clip;
	
	public SpellingBeebgn(beginners h)
	{
		super("Beginner Level");
		sbee=new SpellingBeeBB();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.h=h;
		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("Image/in.png");
	    this.setIconImage(icon.getImage());
		

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		back=new JButton(new ImageIcon("Image/back1.png"));
	back.setBounds(10,20,56,54);
    back.setBackground(Color.WHITE);
    back.setForeground(Color.white);
    back.setOpaque(true);	
	panel.add(back);	

	title = new JLabel("  Spelling Bee");
	title.setBounds(200,30,200,25);
	title.setBackground(Color.CYAN);
	title.setForeground(Color.BLACK);
	title.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	title.setOpaque(true);
	panel.add(title);
	

	tf1 = new JTextField();
	tf1.setBounds(80,100,150,40);
	tf1.setText(" ");
	
	panel.add(tf1);
	
	tf2 = new JTextField(10);
	tf2.setBounds(80,200,450,215);
	tf2.setText("Show Info");
	tf2.setEditable(false);
	tf2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	tf2.setHorizontalAlignment(JTextField.CENTER);
	//tf2.setLineWrap(true);
	//tf2.setWrapStyleWord(true);
	panel.add(tf2);
	
	
	
	btn1 = new JButton("Check");
	btn1.setBounds(240,100,160,40);
	btn1.setBackground(Color.GRAY);
	btn1.setForeground(Color.white);
	btn1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn1);
	 
	audioButton=new JButton(new ImageIcon("Image/Audio.png"));
	audioButton.setBounds(405,100,50,41);
    panel.add(audioButton);
	
	btn2 = new JButton("Defination");
	btn2.setBounds(80,150,190,40);
	btn2.setBackground(Color.GRAY);
	btn2.setForeground(Color.white);
	btn2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn2);
	btn3 = new JButton("Part Of Speech");
	btn3.setBounds(280,150,250,40);
	btn3.setBackground(Color.GRAY);
	btn3.setForeground(Color.white);
	btn3.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn3);

	btn4 = new JButton("Language of Origin");
	btn4.setBounds(80,420,450,40);
	btn4.setBackground(Color.GRAY);
	btn4.setForeground(Color.white);
	btn4.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn4);
	
	btn5 = new JButton("Next Word");
	btn5.setBounds(470,480,160,40);
	btn5.setBackground(Color.GRAY);
	btn5.setForeground(Color.white);
	btn5.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn5);
	
	back.addActionListener(this);
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	btn3.addActionListener(this);
	btn4.addActionListener(this);
	btn5.addActionListener(this);
	audioButton.addActionListener(this);
	tf1.addMouseListener(this);
	
	this.add(panel);
	//this.setVisible(true);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){
		if(me.getSource().equals(tf1)){
			tf1.setText(null);
		}
	}
	public void mousePressed(MouseEvent me){}
	

	
	
public void mouseReleased(MouseEvent me){}
 public void actionPerformed(ActionEvent e){
      if(e.getSource().equals(back))
	   {
	   	 
	     this.h.setVisible(true);
	     this.setVisible(false);
	   }
	    else if(e.getSource().equals(btn5)){
			if(sbee.numCount==5){
			 if(e.getSource().equals(btn5)){
				 int selectedOption = JOptionPane.showConfirmDialog(null, "Do you wanna close the window?", "You have Completed", JOptionPane.YES_NO_OPTION); 
                if (selectedOption == JOptionPane.YES_OPTION) {
                             this.h.setVisible(true);
	            this.setVisible(false);
                 }
				
			 }
		 }
		 else {
		 sbee.setCount();
		 }
			   }
	   else if(e.getSource().equals(btn1)){
		  // Check();
		  if(tf1.getText().equals(" ")){
			  JOptionPane.showMessageDialog(null,"Text Field Empty!!!!");
		  }
		  else{
		  String input=tf1.getText();
		  //input=(input.substring(0,1).toUpperCase()) + (input.substring(1).toLowerCase());
		  if(sbee.getWord().equalsIgnoreCase(input))
		  {
			  tf2.setText("Spelling is Correct");
		  }
		  else
			  tf2.setText("Spelling is Incorrect.   Correct spelling is: "+sbee.getWord());
		  
	   }}
	   else if(e.getSource().equals(btn2))
	   {
		   tf2.setText(sbee.getDefination());
	   }
		   else if(e.getSource().equals(btn3))
		   {
			   tf2.setText(sbee.getPoS());
		   }
			   else if(e.getSource().equals(btn4))
			   {
				   tf2.setText(sbee.getOrigin());
			   }
			   else if(e.getSource().equals(btn5)){
				   if(tf1.getText().equals(null)){
					 JOptionPane.showMessageDialog(null,"Please try spelling once to proceed !");  
				   }
				   else if(tf1.getText().equals(" ")){
					  JOptionPane.showMessageDialog(null,"Please try spelling once to proceed !"); 
				   }
				   else{
				   sbee.setCount();
				   }
			   }
			   else if(e.getSource().equals(audioButton))
			   {
			   	audioStart();
			   }
 	
}
  public void audioStart()
  {
  	String audioFile="Audio/b/aw"+sbee.getAudioNumber()+".wav"; 
  	try{
       audioInputStream =
        AudioSystem.getAudioInputStream(new File(audioFile).getAbsoluteFile());
     clip = AudioSystem.getClip();
    clip.open(audioInputStream);
    clip.start();
}
catch(Exception ex)
{
	System.out.println(ex);

}
  }

  /*public void Check(){
	if(SpellingBee.getWord()
	sb.wordCase(tf1.getText());
	this.tf2.setText(sb.getRes());
}*/
  








}	