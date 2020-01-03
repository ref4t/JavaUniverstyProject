import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


import java.util.*;



import javax.sound.sampled.*;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;




public class PronounceTest extends JFrame implements MouseListener, ActionListener
{
	 JLabel title;
	
	 JButton start,nextB,back;
	 
     JTextField field1;
	 JTextArea field2;	 
	
 	 JPanel panel;
	 
	 String word;
	 
	 private LiveSpeechRecognizer recognizer;
	
	private String speechRecognitionResult;
	
	 

    AudioInputStream audioInputStream;
    Clip clip;
	 
	public PronounceTest()
	{
	  this.setTitle("Beginner's Level");
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0,0,800,550);
		
		title=new JLabel(new ImageIcon("pronounce.png"));
		title.setBounds(80,40,600,30);
		title.setBackground(Color.WHITE);
		
		field1=new JTextField(50);
		field1.setBounds(100,150,600,115);
		field1.setEditable(false);
		field1.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		
		field2=new JTextArea(5,450);
		field2.setBounds(100,270,600,115);
		field2.setBackground(Color.GRAY);
		field2.setEditable(true);
		
		start=new JButton("Click and say the word");
		start.setBounds(100,390,600,40);
		
	
	    back=new JButton(new ImageIcon("Image/back1.png"));
	    back.setBounds(10,20,56,54);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.white);
        back.setOpaque(true);	
		
		nextB= new JButton("Next Word");
     	nextB.setBounds(540,460,160,40);
	    nextB.setBackground(Color.GRAY);
	    nextB.setForeground(Color.white);
	    nextB.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		
		panel.add(title);
		panel.add(field1);
		panel.add(field2);
		panel.add(start);
		panel.add(back);
		panel.add(nextB);
		
		back.addActionListener(this);
		start.addActionListener(this);
		nextB.addActionListener(this);
		
		this.add(panel);
		this.setVisible(true);
		this.showWord();
		
	}
	
		public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(start))
		{
			start.setText("Wait");
			
			speech();
			speak();
			
			checkWord();
		}
	}
	
	
	public void showWord()
	{
		field1.setText("Anxiety");
	}
	public void checkWord()
	{
		field2.setText(null);
		if(field1.getText().equalsIgnoreCase(word))
		{
			field2.setText("\n\n\n                                                        You said: "+word+"\n                                                    Correct Pronunciation");
		}
		else
		{
			String audioFile1="cpi.wav";
			field2.setText("\n\n\n                                                         You said: "+word+"\n                                                    Incorrect Pronunciation");
				try{
		  audioInputStream = AudioSystem.getAudioInputStream(new File(audioFile1).getAbsoluteFile());
         clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.start();
		 try{
			 Thread.sleep(2000);
		 }
		 catch(Exception e){}
		// clip.stop();
		}
		catch(Exception ex)
        {
	      System.out.println(ex);
        }
			 correctPronunciation();
		}
	}
	
	
	public void correctPronunciation()
	{
		String audioFile2="aw2.wav";
		try{
		 audioInputStream = AudioSystem.getAudioInputStream(new File(audioFile2).getAbsoluteFile());
         clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.start();
		}
		catch(Exception ex)
        {
	      System.out.println(ex);
        }
	}
	
	
	public void speech() {
			
		Configuration configuration = new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setGrammarPath("resource:/grammars");
		configuration.setGrammarName("grammar");
		configuration.setUseGrammar(true);
		
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
	             System.out.println(ex);
		}
		
		
		startSpeechRecognition();
	}
	public void startSpeechRecognition() {
	    recognizer.startRecognition(true);
			field2.append("\n\n\n                                                        Pronounce the word now");
		
		
			
			
	}
	public void speak()
	{
		try {	
			    	SpeechResult speechResult = recognizer.getResult();
						if (speechResult == null)
							System.out.println("null");
						else {
							speechRecognitionResult = speechResult.getHypothesis();
							System.out.println("You said: [" + speechRecognitionResult + "]\n");
							word=speechRecognitionResult;
							}
						} 
					
			 catch (Exception ex) {
					
				System.out.println(ex);
					
				}
	}
	
	
	
	
	public static void main(String[] args)
	{
		new PronounceTest();
	}
}