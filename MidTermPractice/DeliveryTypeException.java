public class DeliveryTypeException extends Exception{
 
  public DeliveryTypeException(){
   super("Error: Please select type of delivery!!!"); 
  }
  
  public DeliveryTypeException(String message){
   super(message); 
  }
}