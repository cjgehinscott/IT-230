import java.io.*;

public class WriteToFile{
  public static void main(String[] args){
   String filename = "testfile.txt";
   File file = new File(filename);
   try{
   FileWriter writer = new FileWriter(file, true);
   String data = "\nHello";
   writer.write(data);
   writer.write("\nJava!!!");
   writer.close();
   }catch(IOException ioe){
     System.out.println(ioe.toString());
   }
  }
}