/*CJ Gehin-Scott
 * IT-230
 * 01/23/2014*/

import javax.swing.*;
import java.awt.*;


public class GUIExample2 extends JFrame {
  private JLabel nameLabel, hobbyLabel, stateLabel, genderLabel;
  private JTextField nameTF;
  private JPanel northPanel, southPanel, westPanel, westPanel2, centerPanel, centerPanel2;
  private JButton submit, cancel;
  private JCheckBox movie, sports;
  private JComboBox state; //drop down box
  private JRadioButton male, female;
  
  
  public GUIExample2(){
    setTitle("GUI Example 2");
    setLayout(new BorderLayout());
    nameLabel = new JLabel("Name");
    nameTF = new JTextField(15);
    northPanel = new JPanel();
    northPanel.add(nameLabel);
    northPanel.add(nameTF);
    add(northPanel,BorderLayout.NORTH);
    
    hobbyLabel = new JLabel("Hobby");
    movie = new JCheckBox("Movie");
    sports = new JCheckBox("Sports");
    stateLabel = new JLabel("State");
    String stateArray [] = {"Washington D.C.", "Maryland", "Virginia"};
    state = new JComboBox(stateArray);
    westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(5,1));
    westPanel.add(hobbyLabel);
    westPanel.add(movie);
    westPanel.add(sports);
    westPanel.add(stateLabel);
    westPanel.add(state);
    westPanel2 = new JPanel();//to store the westPanel that way it is not blown out across the entire screen
    westPanel2.add(westPanel);
    add(westPanel2, BorderLayout.WEST);
    
    genderLabel = new JLabel("Gender");
    male = new JRadioButton("Male");
    female = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup(); //used to make sure that only one selection can be made at a time!
    group.add(male);
    group.add(female);
    centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(3,1));
    centerPanel.add(genderLabel);
    centerPanel.add(male);
    centerPanel.add(female);
    centerPanel2 = new JPanel();
    centerPanel2.add(centerPanel);
    add(centerPanel2, BorderLayout.CENTER);
    
    submit = new JButton("Submit");
    cancel = new JButton("Cancel");
    southPanel = new JPanel();
    southPanel.add(cancel);
    southPanel.add(submit);
    add(southPanel, BorderLayout.SOUTH);
    setSize(800,800);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String [] args){
    GUIExample2 e2 = new GUIExample2();
  }//end main method
  
}//end GUIExample2 class