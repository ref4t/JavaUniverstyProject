package user.home.option;

import user.home.option.*;
import java.lang.*;
import java.sql.*;
class SpellingBeeLB{
    static String wordInput;
	 String res;
	 
	 
	public static int numCount;
	
	private String word,pos,origin,defination;

	public SpellingBeeLB(){
		numCount=1;
		wordSet();
	}
	
	
	public void setCount(){
		numCount+=1;
		//System.out.println("Entered: numCount: "+numCount);
	    wordSet();
	}
	public  String getWord()
	{
		return word;
	}
	public  String getPoS()
	{
		return pos;
	}
	public  String getOrigin()
	{
		return origin;
	}
	public  String getDefination()
	{
		return defination;
	}
	public int getAudioNumber()
	{
        return numCount;
	}
	
	 public void wordSet(){
	   String sql="select * from sbLrn where Number="+numCount;
	//   System.out.println("Entered in  wordSet: numCount: "+numCount);
	     try
		 {
			 Connection con=null;
		 Class.forName("org.sqlite.JDBC");
		 con = DriverManager.getConnection("jdbc:sqlite:database/SpellingBee.db");
		 Statement stmt = con.createStatement();
		 ResultSet result=stmt.executeQuery(sql);
		 while(result.next())
		 {
			 word=result.getString("Word");
			 pos=result.getString("PoS");
			 origin=result.getString("Origin");
			 defination=result.getString("Defination");
		 }}
		 catch(Exception e)
		 {
			   System.err.println( "error in catch: "+e.getClass().getName() + ": " + e.getMessage() );
		 }
		 
		 
   }
}