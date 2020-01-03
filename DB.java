package database;
import java.sql.*;

public class DB {
  public DB() {
      Connection c = null;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Aminihal9525");
      } catch ( Exception e ) {
         System.err.println( "error in catch"+e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
	  if(c!=null)
	  {
      System.out.println("Opened database successfully");
	  System.out.println(c);
	  }
   }
}