/*CJ Gehin-Scott
 * 01/16/2014
 * IT-230*/
import java.util.Scanner;
import javax.swing.*;//lightweight components

public class firstClass extends JFrame{
  private JLabel numeratorLabel; //declaring
  private JTextField numeratorTF; //declaring
  private JPanel panel1;//declaring
  
//constructor
  public firstClass() {
    setTitle("Example 1");
    //initializing
    numeratorLabel = new JLabel("Numerator");
    numeratorTF = new JTextField(5);
    panel1 = new JPanel();
    panel1.add(numeratorLabel);
    panel1.add(numeratorTF);
    add(panel1);
    setSize(400,400);
    setVisible(true);
  }
  
  public static void main(String[] args){
      /*Scanner input = new Scanner(System.in);
      System.out.println("Please enter the numerator: ");
      double numerator = input.nextDouble();
      System.out.println("Please enter the denominator: ");
      double denominator = input.nextDouble();
      double divide = numerator / denominator;
      System.out.printf("The result of dividing %.1f by %.1f is %.1f",numerator,denominator,divide);*/
    
    firstClass ex1 = new firstClass();
    

  }//end main method
}//end FirstClass