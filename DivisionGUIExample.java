import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DivisionGUIExample extends JFrame implements ActionListener { 
  private JLabel numeratorLabel, denominatorLabel; //declaring
  private JTextField numeratorField, denominatorField; //declaring
  private JPanel panel1, panel2, panel3;
  private JButton computeButton;
  
  //constructor
  public DivisionGUIExample() {
    setTitle("GUI Example - Divide Numbers");
    JPanel p = new JPanel();
    //initializing
    numeratorLabel = new JLabel("Numerator:");
    numeratorField = new JTextField(3);
    panel1 = new JPanel();
    panel1.add(numeratorLabel);
    panel1.add(numeratorField);
    p.add(panel1);
    
    denominatorLabel = new JLabel("Denominator:");
    denominatorField = new JTextField(3);
    panel2 = new JPanel();
    panel2.add(denominatorLabel);
    panel2.add(denominatorField);
    p.add(panel2);
    
    computeButton = new JButton("Compute");
    computeButton.addActionListener(this);
    p.add(computeButton);
    add(p);
    setSize(400, 100);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() == computeButton) {
      String num1 = numeratorField.getText();
      String num2 = denominatorField.getText();
           
      double x = Double.parseDouble(num1);
      double y = Double.parseDouble(num2);
      try{
        if(y == 0){
          throw new DivideByZeroException();
        }
        if(y <= 0 || x <= 0){
          throw new NegativeNumberException();
        }
      double div = x / y;
      JOptionPane.showMessageDialog(null, x + " / " + y + " = " + div, "Result", JOptionPane.INFORMATION_MESSAGE);
      }
      catch(DivideByZeroException dze){
        JOptionPane.showMessageDialog(null,dze.toString());
      }
      catch(NegativeNumberException nne){
        //JOptionPane.showMessageDialog(null,nne.toString());
        JOptionPane.showMessageDialog(null,nne.toString(), "Warning", JOptionPane.ERROR_MESSAGE); 
      }
    }
  }
  
  public static void main(String [] args) {
   DivisionGUIExample gui = new DivisionGUIExample();
  }
}