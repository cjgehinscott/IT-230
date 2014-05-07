import java.net.*;
import java.io.*;
import java.sql.*;


public class CreditCardServer {
 private ServerSocket serverSocket;
 private Socket socket;
 private ObjectInputStream input;
 private ObjectOutputStream output;
 private String dbPath = "jdbc:mysql://localhost/hotelReservations?user=root&password=";
 private String jdbcDriver = "com.mysql.jdbc.Driver";
 
 public CreditCardServer(){
  System.out.println("Server is running...");
  
  //Receives message from GUI containing CC info to be validated against the database
   try{
    //server trying port 1098
    //maximum clients 500
    serverSocket = new ServerSocket(1098,500);
    socket = serverSocket.accept(); //accept incoming connection
    //get input from client in stream format
    input = new ObjectInputStream(socket.getInputStream());
    while(true){
    //convert to string
    String message = (String) input.readObject();
    String validateQuery = "SELECT * FROM creditCard WHERE ccInfo = '" + message + "';";
    //create connection with/query database for CC info then respond to the GUI
    Class.forName(jdbcDriver);
    Connection conn = DriverManager.getConnection(dbPath);
    Statement stmt = conn.createStatement();
    ResultSet result = stmt.executeQuery(validateQuery);
    result.last(); //go to the end of the ResultSet
    int rowNum = result.getRow(); //finds the row number for the last row in the RowSet
    sendResponse(rowNum,socket);//sends a response back to the GUI whether the CC is valid or not
    }
   }catch(IOException ioe){
    ioe.printStackTrace();
   }catch(ClassNotFoundException cnfe){
    cnfe.printStackTrace();
   }catch(SQLException sqle){
    sqle.printStackTrace(); 
   }
 }
 //takes in a number that is used to determine whether the credit card is valid or not and sends a response back to the GUI
 public void sendResponse(int num, Socket socket){
  int _num = num;
  Socket _socket = socket;
  if(_num == 0){
    try{
       output = new ObjectOutputStream(_socket.getOutputStream());
       String message = "NO";
       output.writeObject(message);//converts message string to stream format
       output.flush(); 
    }catch(UnknownHostException uhe){
      uhe.printStackTrace();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }else{
    try{
       output = new ObjectOutputStream(_socket.getOutputStream());
       String message = "YES";
       output.writeObject(message);//converts message string to stream format
       output.flush(); 
    }catch(UnknownHostException uhe){
      uhe.printStackTrace();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }
 }
 public static void main(String[] args){
  new CreditCardServer();
 }
}
