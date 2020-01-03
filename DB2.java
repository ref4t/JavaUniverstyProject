package database;
import java.sql.*;
import java.lang.*;

public class DB2{
  public DB2() {
      Connection c = null;
      String db="CREATE TABLE IF NOT EXISTS user(First_Name text NOT NULL,"+
                                                  "Last_Name text NOT NULL,"
                                                   +" Email text NOT NULL ,"
                                                   +"Password text NOT NULL,"
                                                   +"Gender text NOT NULL,"
                                                   +"Birth text );";
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:database/user.db");
         Statement stmt = c.createStatement(); 
           // create a new table
            stmt.execute(db);
      } catch ( Exception e ) {
         System.err.println( "error in catch: "+e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
	  if(c!=null)
      System.out.println("Opened database successfully");
   }
}