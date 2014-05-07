public class InvalidCreditCardException extends Exception{
  
  public InvalidCreditCardException(){
    super("Invalid Credit Card Information");
  }
  
  public InvalidCreditCardException(String message){
    super(message);
  }
}