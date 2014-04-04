/*CJ Gehin-Scott
 * MidTerm Practice */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class DeliveryService1 extends JFrame{
 
  private JLabel weightLabel, deliveryLabel;
  private JTextField weightTF;
  private JButton submit, cancel;
  private JRadioButton localDeliveryRB, longDistanceDeliveryRB;
  private JCheckBox insuranceCheckBox;
  private JPanel northPanel, southPanel, centerPanel, deliveryPanel, insurancePanel;
 
     public DeliveryService1()
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
     cancel = new JButton("Cancel");
     southPanel = new JPanel();
     southPanel.add(submit);
     southPanel.add(cancel);
     add(southPanel, BorderLayout.SOUTH);
     
     //setting size of JFrame and making it visible
     setSize(500,250);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
     
     public static void main(String[] args){
       DeliveryService1 ds1 = new DeliveryService1();
     }
}

