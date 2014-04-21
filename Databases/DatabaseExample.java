import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseExample {
 
  public static void main(String[] args){
   String url = "jdbc:mysql://localhost/hotelReservations?user=root&password=";
   try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(url);
    System.out.println("connected");
    /*Statement stmt = conn.createStatement();
    String query = "select * from student;";
    ResultSet response = stmt.executeQuery(query);
    while(response.next()) {
       System.out.println(response.getString(1));
       System.out.println(response.getString(2));
    }
    String str = "insert into student values('1297567','CJ','G.S.', 1, 20);";
    stmt.execute(str);*/
   }
   catch(ClassNotFoundException cnfe) {
    cnfe.printStackTrace(); 
   }
   catch(SQLException sqle){
     sqle.printStackTrace();
   }/*catch(InstantiationException ie){
    ie.printStackTrace(); 
   }catch(IllegalAccessException iae){
     iae.printStackTrace();
   }*/
  }
}