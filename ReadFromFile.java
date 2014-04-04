import java.io.*;
import java.util.Scanner;
public class ReadFromFile{
  public static void main(String[] args){
    String filename = "testfile.txt";
    File file = new File(filename);
   try{
     Scanner reader = new Scanner(file);
     while(reader.hasNextLine()){
       String line = reader.nextLine();
       System.out.println(line);
     }
   }catch(FileNotFoundException fnfe){
     System.out.println(fnfe.toString());
   }
  }
}