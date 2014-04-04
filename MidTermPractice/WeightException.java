public class WeightException extends Exception{
 
  public WeightException(){
   super("Error: Weight is not in range 0.1 - 50.0 !!!"); 
  }
  
  public WeightException(String message){
   super(message); 
  }
}