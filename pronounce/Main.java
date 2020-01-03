import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main 
{
	
  public static void main(String[] args)
  {
  	  String command="java -classpath \".;sphinx4-core.jar;sphinx4-data.jar\" PronounceTest";
		try{
		Process p = Runtime.getRuntime().exec(command);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
  }

}