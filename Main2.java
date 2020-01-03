package main;

import user.opening.Opening;
import database.*;
public class Main2{
	
	public static void main(String[] args)
	{
	    String command="java -classpath \".;sqlite-jdbc-3.21.0.jar;sphinx4-core.jar;sphinx4-data.jar\" main.Main";
		try{
		Process p = Runtime.getRuntime().exec(command);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}