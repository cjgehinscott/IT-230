import java.util.Scanner;

public class ExceptionDivisionExample {
 
 public static void main(String [] args) {
  
  Scanner scn = new Scanner(System.in);
  System.out.println("Please enter a numerator:");
  int numerator = scn.nextInt();
  System.out.println("Please enter a denominator:");
  int denominator = scn.nextInt();
  try{
    if(denominator == 0){
      throw new DivideByZeroException();
    }
    if(denominator <= 0 || numerator <=0){
      throw new NegativeNumberException();
    }
    int quotient = numerator / denominator;
    System.out.println(numerator + " / " + denominator + " = " + quotient); 
  }
  catch(DivideByZeroException dze){
    System.out.println(dze.toString());
    dze.printStackTrace();
    //System.out.println("Error!! You can't divide by Zero");
  }
  catch(NegativeNumberException nne){
    System.out.println(nne.toString());
  }
  finally{
    System.out.println("Move Along!!");
  }
  System.out.println("Program has reached the end of line.");
  
 } 
}