package user.home.option;

import user.home.option.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PractiseGrammerlrn extends JFrame implements MouseListener , ActionListener

{
	private JLabel title,title2,title3;
	
		
	private JPanel panel;
	
	private Learners h;
	private JButton back,btn2,btn3,btn4,btn1,next;
	private JTextField tf2;
	PractiseGrammerLB pgBgn;
	public PractiseGrammerlrn(Learners h)
	{
		super("Learner's Level");
		pgBgn=new PractiseGrammerLB();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.h=h;
		this.setSize(600,550);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		
		title = new JLabel("    Grammer Practise");
	title.setBounds(150,30,300,25);
	title.setBackground(Color.CYAN);
	title.setForeground(Color.BLACK);
	title.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	title.setOpaque(true);
	panel.add(title);
	
	title2 = new JLabel("Choose The Correct The Correct Answer");
	title2.setBounds(120,70,400,40);
	title2.setBackground(Color.cyan);
	title2.setForeground(Color.BLACK);
	title2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,18));
	panel.add(title2); 
		
	title3 = new JLabel(pgBgn.getQues());
	title3.setBounds(100,115,400,40);
	title3.setBackground(Color.white);
	title3.setForeground(Color.BLACK);
	title3.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,15));
	panel.add(title3);

	/* tf1 = new JTextField();
	tf1.setBounds(80,100,150,40);
	
	panel.add(tf1); */
	
	/* tf2 = new JTextField();
	tf2.setBounds(80,150,450,185);
	
	panel.add(tf2); */
	
	
	/*img = new ImageIcon("bulletpoint.jpg");
	btn5 = new JButton(img);
	btn5.setBounds(600,50,160,40);
    panel.add(btn5);*/
	
	btn1 = new JButton(pgBgn.getAns1());
	btn1.setBounds(155,210,250,40);
	btn1.setBackground(Color.GRAY);
	btn1.setForeground(Color.white);
	btn1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn1); 
	
	/* audioButton=new JButton(new ImageIcon("Image/Audio.png"));
	audioButton.setBounds(497,70,50,47);
    panel.add(audioButton); */
	
	btn2 = new JButton(pgBgn.getAns2());
	btn2.setBounds(155,260,250,40);
	btn2.setBackground(Color.GRAY);
	btn2.setForeground(Color.white);
	btn2.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn2);
	
	btn3 = new JButton(pgBgn.getAns3());
	btn3.setBounds(155,310,250,40);
	btn3.setBackground(Color.GRAY);
	btn3.setForeground(Color.white);
	btn3.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn3);

	btn4 = new JButton(pgBgn.getAns4());
	btn4.setBounds(155,360,250,40);
	btn4.setBackground(Color.GRAY);
	btn4.setForeground(Color.white);
	btn4.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(btn4);
	
	//this.add(panel);
	
	next = new JButton("Next");
	next.setBounds(370,415,160,40);
	next.setBackground(Color.GRAY);
	next.setForeground(Color.white);
	next.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
	panel.add(next);
	
	back=new JButton(new ImageIcon("Image/back1.png"));
	back.setBounds(10,20,56,54);
    back.setBackground(Color.WHITE);
    back.setForeground(Color.white);
    back.setOpaque(true);	
	panel.add(back);
	
	btn1.addActionListener(this);
	btn2.addActionListener(this);
    btn3.addActionListener(this);
	btn4.addActionListener(this);
	back.addActionListener(this);
	next.addActionListener(this);
	//audioButton.addActionListener(this); 
	
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
	 else if(e.getSource().equals(btn1)){
		  if(pgBgn.getAns1().equals(pgBgn.getCans())){
			  btn1.setBackground(Color.GREEN);
		  }
		  else{
			  btn1.setBackground(Color.RED);
		  }
	 }
	 else if(e.getSource().equals(btn2)){
		 if(pgBgn.getAns2().equals(pgBgn.getCans())){
			  btn2.setBackground(Color.GREEN);
		  }
		  else{
			  btn2.setBackground(Color.RED);
		  }
	 }
	 else if(e.getSource().equals(btn3)){
		 if(pgBgn.getAns3().equals(pgBgn.getCans())){
			  btn3.setBackground(Color.GREEN);
		  }
		  else{
			  btn3.setBackground(Color.RED);
		  }
	 }
	 else if(e.getSource().equals(btn4)){
		 if(pgBgn.getAns4().equals(pgBgn.getCans())){
			  btn4.setBackground(Color.GREEN);
		  }
		  else{
			  btn4.setBackground(Color.RED);
		  }
	 }
	 else if(e.getSource().equals(next)){
		 if(pgBgn.numCount==8){
			 if(e.getSource().equals(next)){
				 int selectedOption = JOptionPane.showConfirmDialog(null, "Do you wanna close the window?", "You have Completed", JOptionPane.YES_NO_OPTION); 
                if (selectedOption == JOptionPane.YES_OPTION) {
                             this.h.setVisible(true);
	            this.setVisible(false);
                 }
				
			 }
		 }
		 else {
		 pgBgn.setCount();
		title3.setText(pgBgn.getQues());
		btn1.setText(pgBgn.getAns1());
		btn2.setText(pgBgn.getAns2());
		btn3.setText(pgBgn.getAns3());
		btn4.setText(pgBgn.getAns4());
		btn1.setBackground(Color.GRAY);
		btn2.setBackground(Color.GRAY);
		btn3.setBackground(Color.GRAY);
		btn4.setBackground(Color.GRAY);
		 }
	 }
 	
}
}	