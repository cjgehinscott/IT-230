/*CJ Gehin-Scott
 * MidTerm Practice */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class DeliveryService2 extends JFrame implements ActionListener{
 
  private JLabel weightLabel, deliveryLabel;
  private JTextField weightTF;
  private JButton submit, cancel;
  private JRadioButton localDeliveryRB, longDistanceDeliveryRB;
  private JCheckBox insuranceCheckBox;
  private JPanel northPanel, southPanel, centerPanel, deliveryPanel, insurancePanel;
  private ButtonGroup deliveryGroup;
 
     public DeliveryService2()
    {
      setTitle("Delivery Service");
      setLayout(new BorderLayout());
      
  
  //North Panel
     weightLabel = new JLabel("Enter weight in pounds: " );
     weightTF = new JTextField(20);
     northPanel = new JPanel();
     northPanel.add(weightLabel);
     northPanel.add(weightTF);
     add(northPanel, BorderLayout.NORTH);
     
   //Center Panel
     deliveryLabel = new JLabel("Type of Delivery");
     localDeliveryRB = new JRadioButton("Local");
     longDistanceDeliveryRB = new JRadioButton("Long Distance");
     insuranceCheckBox = new JCheckBox("Insurance");
     deliveryGroup = new ButtonGroup();
     deliveryGroup.add(localDeliveryRB);
     deliveryGroup.add(longDistanceDeliveryRB);
     deliveryPanel = new JPanel();
     deliveryPanel.add(deliveryLabel);
     deliveryPanel.add(localDeliveryRB);
     deliveryPanel.add(longDistanceDeliveryRB);
     insurancePanel = new JPanel();
     insurancePanel.add(insuranceCheckBox);
     centerPanel = new JPanel();
     centerPanel.setLayout(new GridLayout(2,1));
     centerPanel.add(deliveryPanel);
     centerPanel.add(insurancePanel);
     add(centerPanel, BorderLayout.CENTER);
     
   //South Panel
     submit = new JButton("Submit");
     submit.addActionListener(this);
     cancel = new JButton("Cancel");
     cancel.addActionListener(this);
     southPanel = new JPanel();
     southPanel.add(submit);
     southPanel.add(cancel);
     add(southPanel, BorderLayout.SOUTH);
     
     //setting size of JFrame and making it visible
     setSize(500,250);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
     public void actionPerformed(ActionEvent event)
     {
       if(event.getSource() == submit){
         String weight = weightTF.getText();
         String delivery = "";
         if(localDeliveryRB.isSelected()){
           delivery = "Local Delivery";
         }else if(longDistanceDeliveryRB.isSelected()){
           delivery = "Long Distance Delivery";
         }
         String insurance = "";
         if(insuranceCheckBox.isSelected()){
           insurance = "Insurance: Yes";
         }else if(!insuranceCheckBox.isSelected()){
           insurance = "Insurance: No";
         }
         JOptionPane.showMessageDialog(null, "Weight: " + weight + "\nDelivery: " + delivery + "\n" + insurance);
       }else if(event.getSource() == cancel){
          weightTF.setText("");
          deliveryGroup.clearSelection();
          insuranceCheckBox.setSelected(false);
       }
     }
     public static void main(String[] args){
       DeliveryService2 ds1 = new DeliveryService2();
     }
}



