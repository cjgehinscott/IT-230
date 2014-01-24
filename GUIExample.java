/*CJ Gehin-Scott
 * IT-230
 * 01/23/2014*/

import javax.swing.*;
import java.awt.*;

public class GUIExample extends JFrame{
  private JLabel numeratorLabel, denominatorLabel; //declaring
  private JTextField numeratorTF, denominatorTF; //declaring
  private JPanel panel1, panel2, panel3; //declaring
  private JButton click; //declaring light weight button that calculates the dividing the numerator and the denominator
  
  
  //GUI constructor
  public GUIExample(){
    setTitle("GUI Example - Divide Numbers");
    setLayout(new GridLayout(3,1));
    //initialization
    numeratorLabel = new JLabel("Numerator");
    numeratorTF = new JTextField(10);
    panel1 = new JPanel();
    panel1.add(numeratorLabel);
    panel1.add(numeratorTF);
    add(panel1);
    
    denominatorLabel = new JLabel("Denominator");
    denominatorTF = new JTextField(10);
    panel2 = new JPanel();
    panel2.add(denominatorLabel);
    panel2.add(denominatorTF);
    add(panel2);
    
    click = new JButton("Calculate");
    panel3 = new JPanel();
    panel3.add(click);
    add(panel3);
   
    
    setSize(400,400);
    setVisible(true);
  }//end GUI constructor
  
  public static void main(String [] args){
    GUIExample e1 = new GUIExample();
  
  }//end main method
}//end GUIExample class