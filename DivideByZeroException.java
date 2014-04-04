

public class DivideByZeroException extends Exception {
  
  public DivideByZeroException(){
     super("Error: Divide By Zero Exception!!!!");
  }
  
  public DivideByZeroException(String message){
    super(message);
  }
}