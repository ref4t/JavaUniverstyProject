package main;
import user.opening.*;
import database.*;
public class Main{
	public static void main(String[] args)
	{
		DB2 db2=new DB2();
	 /*GUI gui=new GUI();
	  gui.setVisible(true);
		//DB db=new DB();
		*/
		Opening op = new Opening();
		op.setVisible(true);
	}

}