import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class DatagramClient {
 
 private DatagramSocket socket;
 public DatagramClient(){
  try{
    socket = new DatagramSocket();
    while(true){
      Scanner input = new Scanner(System.in);
      String message = input.nextLine();
      byte data[] = message.getBytes();
      DatagramPacket packet = new DatagramPacket(data, data.length,InetAddress.getLocalHost(),1097);
      socket.send(packet);
      
      data = new byte[100];
      packet = new DatagramPacket(data, data.length);
      socket.receive(packet);
      message = new String(packet.getData());
      System.out.println("Server says: " + message);
    }
  }catch(IOException se){
   se.printStackTrace();
  }
 }
 public static void main(String[] args){
  DatagramClient dc = new DatagramClient();
 }
}