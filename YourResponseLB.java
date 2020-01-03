package user.home.option;

import user.home.option.*;
import java.lang.*;
import java.sql.*;

class YourResponseLB{
	public static int numCount;
	String question,answer1,answer2,answer3,answer4,canswer;
	public YourResponseLB(){
		numCount=1;
		wordSet();
	}
	 public void wordSet(){
	   String sql="select * from respoLrn where Number="+numCount;
	//   System.out.println("Entered in  wordSet: numCount: "+numCount);
	     try
		 {
			 Connection con=null;
		 Class.forName("org.sqlite.JDBC");
		 con = DriverManager.getConnection("jdbc:sqlite:database/respobgn.db");
		 Statement stmt = con.createStatement();
		 ResultSet result=stmt.executeQuery(sql);
		 while(result.next())
		 {
			 question=result.getString("Question");
			 answer1=result.getString("Answer1");
			 answer2=result.getString("Answer2");
			 answer3=result.getString("Answer3");
			 answer4=result.getString("Answer4");
			 canswer=result.getString("Canswer");
		 }}
		 catch(Exception e)
		 {
			   System.err.println( "error in catch: "+e.getClass().getName() + ": " + e.getMessage() );
		 }
	 }
	 public String getQues(){
		 return question;
	 }
	 public String getAns1(){
		 return answer1;
	 }
	 public String getAns2(){
		 return answer2;
	 }
	 public String getAns3(){
		 return answer3;
	 }
	 public String getAns4(){
		 return answer4;
	 }
	 public String getCans(){
		 return canswer;
	 }
	 public void setCount(){
		numCount+=1;
		//System.out.println("Entered: numCount: "+numCount);
	    wordSet();
	}
}