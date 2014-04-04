import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Example extends JFrame implements ActionListener { 
  private JLabel numeratorLabel, denominatorLabel; //declaring
  private JTextField numeratorField, denominatorField; //declaring
  private JPanel panel1, panel2, panel3;
  private JButton computeButton;
  
  //constructor
  public Example() {
    setTitle("GUI Example - Divide Numbers");
    setLayout(new GridLayout(3,1));
    //initializing
    numeratorLabel = new JLabel("Numerator:");
    numeratorField = new JTextField(10);
    panel1 = new JPanel();
    panel1.add(numeratorLabel);
    panel1.add(numeratorField);
    add(panel1);
    
    denominatorLabel = new JLabel("Denominator:");
    denominatorField = new JTextField(10);
    panel2 = new JPanel();
    panel2.add(denominatorLabel);
    panel2.add(denominatorField);
    add(panel2);
    
    computeButton = new JButton("Compute");
    computeButton.addActionListener(this);
    add(computeButton);
    
    setSize(400, 400);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent event){
    if(event.getSource() == computeButton){
       int numerator = Integer.parseInt(numeratorField.getText());
       String num = numeratorField.getText();
       int denominator = Integer.parseInt(denominatorField.getText());
       String denom = denominatorField.getText();
       try{
         int quotient = numerator / denominator;
         String equals = Integer.toString(quotient);
         JOptionPane.showMessageDialog(null,  num + " / " + denom + " = " + equals);
       }
       catch(Exception e){
         JOptionPane.showMessageDialog(null, e.toString());
       }
       JOptionPane.showMessageDialog(null, "Yay");
    }
  }
  public static void main(String [] args) {
    Example gui = new Example();
  }
}