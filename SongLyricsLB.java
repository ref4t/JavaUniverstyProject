package user.home.option;

import user.home.option.*;
import java.lang.*;
import java.sql.*;

class SongLyricsLB{

//public static String dbLyrics = "why oh why tell me why not me why oh why we were meant to be baby I know I could be all you need why oh why oh why";
int numCount;
private String lyrics,name;
public SongLyricsLB(){
	numCount=1;
		wordSet();	
}
 
 public void wordSet(){
	   String sql="select * from slyLrn where Number="+numCount;
	//   System.out.println("Entered in  wordSet: numCount: "+numCount);
	     try
		 {
			 Connection con=null;
		 Class.forName("org.sqlite.JDBC");
		 con = DriverManager.getConnection("jdbc:sqlite:database/SongLyrics.db");
		 Statement stmt = con.createStatement();
		 ResultSet result=stmt.executeQuery(sql);
		 while(result.next())
		 {
			 name=result.getString("Name");
			 lyrics=result.getString("Lyrics");
			 
		 }}
		 catch(Exception e)
		 {
			   System.err.println( "error in catch: "+e.getClass().getName() + ": " + e.getMessage() );
		 }
		 
		 
   }
   public String getLyrics(){
	   return lyrics;
   }
  public void setCount(){
		numCount+=1;
		//System.out.println("Entered: numCount: "+numCount);
	    wordSet();
	}
	public int getAudioNumber()
	{
        return numCount;
	}
}