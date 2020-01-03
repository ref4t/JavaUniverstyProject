package user.registration;
import java.sql.*;
import database.*;
import user.panel.*;
import java.sql.*;


public class CreateDB {
             RegiPanel rpanel;
             String userName;
             Connection c;
   public CreateDB()
   {
	   this(null);
   }
   public CreateDB(RegiPanel rp) {
        
	      c = null;
             rpanel=rp;
		  if(rp!=null){
            dbConnection();  
		    }
   }

   public void dbConnection()
   {
      //try to connect database
	    try {
	    		Class.forName("org.sqlite.JDBC");
           // userName=rpanel.getUserName();
            String dbName=userName+".db";
            c = DriverManager.getConnection("jdbc:sqlite:database/"+dbName);
          }
      //catch the exception
      catch ( Exception e ) 
          { 
            System.err.println( "error in catch"+e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
          }
	   if(c!=null)
	  {
       System.out.println("Opened database successfully");
	    System.out.println(c);
       createData();
	}
   }
   public void createData()
   {
       /*String sql = "CREATE TABLE IF NOT EXISTS "+userName+"(\n"
                + "  Grammer,\n"
                + "  name text NOT NULL,\n"
                + "  capacity real\n"
                + ");";
        
       // try (Connection conn = DriverManager.getConnection(url);
                try{
                Statement stmt = conn.createStatement() 
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/

      
       
       
       String store="INSERT INTO user( First_Name,Last_Name,Email,Gender,Password,Birth) VALUES(?,?,?,?,?,?)";


         try {
            //c.close();
       c= DriverManager.getConnection("jdbc:sqlite:database/user.db");
       PreparedStatement pstmt = c.prepareStatement(store);
        System.out.println("in sql");
            pstmt.setString(1, rpanel.getFirstName());
            pstmt.setString(2, rpanel.getLastName());
            pstmt.setString(3, rpanel.getEmail());
            pstmt.setString(4, rpanel.getGender());
            pstmt.setString(5, rpanel.getPassword());
			pstmt.setString(6, rpanel.getBirth());
            pstmt.executeUpdate();
            System.out.println("in");
      } catch ( Exception e ) {
         System.err.println( "error in catch"+e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      if(c!=null)
          System.out.println("done");

   }
 
}
