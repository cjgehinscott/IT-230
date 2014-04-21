import java.net.*;
import java.io.*;
import java.util.Scanner;

public class DatagramServer{
  
  private DatagramSocket socket;
  
  public DatagramServer() { //constructor
    System.out.println("Server is running!!!");
    try{
      socket = new DatagramSocket(1097);
      while(true){
      byte data [] = new byte[100];
      DatagramPacket packet = new DatagramPacket(data, data.length);
      socket.receive(packet);
      String message = new String(packet.getData());
      System.out.println(message);
      
      Scanner input = new Scanner(System.in);
      System.out.println("Client says: ");
      message = input.nextLine();
      data = message.getBytes();
      packet = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
      socket.send(packet);
      
      }
    }catch(SocketException se){
      se.printStackTrace();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }
  public static void main(String[] args){
    DatagramServer ds = new DatagramServer();
  }
}
