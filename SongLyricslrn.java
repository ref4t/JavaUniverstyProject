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
public class SongLyricslrn extends JFrame implements MouseListener , ActionListener

{
	private JLabel title,title2;
	
		
	private JPanel panel;
	
	private Learners h;
	private JButton back,btn2,btn3,btn4,audioButton;
	private JTextField tf2;
	SongLyricsLB sly;
	AudioInputStream audioInputStream;
    Clip clip;
	public SongLyricslrn(Learners h)
	{
		super("Learner's Level");
		sly=new SongLyricsLB();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.h=h;
		this.setSize(600,550);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		
		title = new JLabel("   Song Lyrics Challenge");
	title.setBounds(150,30,300,25);
	title.setBackground(Color.CYAN);
	title.setForeground(Color.BLACK);
	title.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	title.setOpaque(true);
	panel.add(title);
	title2 = new JLabel("Click Sound Icon to start the song");
	title2.setBounds(100,70,400,40);
	title2.setBackground(Color.cyan);
	title2.setForeground(Color.BLACK);
	title2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(title2);
	

	/* tf1 = new JTextField();
	tf1.setBounds(80,100,150,40);
	
	panel.add(tf1); */
	
	tf2 = new JTextField();
	tf2.setBounds(80,150,450,185);
	
	panel.add(tf2);
	
	
	/*img = new ImageIcon("bulletpoint.jpg");
	btn5 = new JButton(img);
	btn5.setBounds(600,50,160,40);
    panel.add(btn5);*/
	
	/* btn1 = new JButton("Song Lyrics Challenge");
	btn1.setBounds(240,100,160,40);
	btn1.setBackground(Color.GRAY);
	btn1.setForeground(Color.white);
	btn1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn1); */
	
	audioButton=new JButton(new ImageIcon("Image/Audio.png"));
	audioButton.setBounds(497,70,50,47);
    panel.add(audioButton);
	
	btn3 = new JButton("Check");
	btn3.setBounds(80,420,190,40);
	btn3.setBackground(Color.GRAY);
	btn3.setForeground(Color.white);
	btn3.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn3);

	btn4 = new JButton("Try Another");
	btn4.setBounds(300,420,190,40);
	btn4.setBackground(Color.GRAY);
	btn4.setForeground(Color.white);
	btn4.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn4);
	this.add(panel);
	
	back=new JButton(new ImageIcon("Image/back1.png"));
	back.setBounds(10,20,56,54);
    back.setBackground(Color.WHITE);
    back.setForeground(Color.white);
    back.setOpaque(true);	
	panel.add(back);
	
    btn3.addActionListener(this);
	btn4.addActionListener(this);
	back.addActionListener(this);
	audioButton.addActionListener(this);
	
	this.add(panel);
	//this.setVisible(true);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	
	

	
	
public void mouseReleased(MouseEvent me){}
 public void actionPerformed(ActionEvent e){
  if(e.getSource().equals(back))
	   {
	   	 
	     this.h.setVisible(true);
	     this.setVisible(false);
	   }
	 else if(e.getSource().equals(btn3)){
		   String input=tf2.getText();
		   input=input.replaceAll("[^a-zA-Z0-9\\s+]", "");
		   String res = input.trim().replaceAll(" +", " ");
		   if(res.equalsIgnoreCase(sly.getLyrics())){
	      JOptionPane.showMessageDialog(null,"Correct Lyrics");	
	}
	      else{
		JOptionPane.showMessageDialog(null, "Wrong Lyrics.\n Correct Lyrics is: "+sly.getLyrics());
	}
		   	   
	 }
	 else if(e.getSource().equals(btn4)){
		 if(sly.numCount==2){
			 if(e.getSource().equals(btn4)){
				 int selectedOption = JOptionPane.showConfirmDialog(null, "Do you wanna close the window?", "You have Completed", JOptionPane.YES_NO_OPTION); 
                if (selectedOption == JOptionPane.YES_OPTION) {
                             this.h.setVisible(true);
	            this.setVisible(false);
                 }
				
			 }
		 }
		 else {
		 sly.setCount();
	 }}
	 else if(e.getSource().equals(audioButton)){
		 audioStart();
	 }
 	
}
public void audioStart()
  {
  	String audioFile="Audio/l/bly"+sly.getAudioNumber()+".wav"; 
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
}	