public class NegativeNumberException extends Exception{
 
  public NegativeNumberException(){
    super("You used a negative number!");
  }
  
  public NegativeNumberException(String message){
   super(message); 
  }
}