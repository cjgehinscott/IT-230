/*CJ Gehin-Scott
 * IT-230
 * 01/23/2014*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUIExample2 extends JFrame implements ActionListener {
  private JLabel nameLabel, hobbyLabel, stateLabel, genderLabel, commentLabel;
  private JTextField nameTF;
  private JPanel northPanel, southPanel, westPanel, westPanel2, centerPanel, centerPanel2, eastPanel;
  private JButton submit, cancel;
  private JCheckBox movie, sports;
  private JComboBox state; //drop down box
  private JRadioButton male, female;
  private JTextArea comments;
  private ButtonGroup group;
  
  
  public GUIExample2(){
    setTitle("GUI Example 2");
    setLayout(new BorderLayout(15,15));
    //North Border
    nameLabel = new JLabel("Name");
    nameLabel.setForeground(Color.WHITE);
    nameTF = new JTextField(15);
    northPanel = new JPanel();
    northPanel.setBackground(Color.BLUE);
    northPanel.add(nameLabel);
    northPanel.add(nameTF);
    add(northPanel,BorderLayout.NORTH);
    
    //West Border
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
    
    //Center Border
    genderLabel = new JLabel("Gender");
    male = new JRadioButton("");
    female = new JRadioButton("");
    group = new ButtonGroup(); //used to make sure that only one selection can be made at a time!
    group.add(male);
    group.add(female);
    centerPanel = new JPanel();
    centerPanel.setBackground(Color.WHITE);
    centerPanel.add(genderLabel);
    centerPanel.add(male);
    ImageIcon micon = new ImageIcon("male.gif");
    JLabel maleLabel = new JLabel(micon);
    maleLabel.setToolTipText("Male");
    centerPanel.add(maleLabel);
    centerPanel.add(female);
    ImageIcon ficon = new ImageIcon("female.gif");
    JLabel femaleLabel = new JLabel(ficon);
    femaleLabel.setToolTipText("Female");
    centerPanel.add(femaleLabel);
    centerPanel2 = new JPanel();
    centerPanel2.setBackground(Color.WHITE);
    centerPanel2.add(centerPanel);
    add(centerPanel2, BorderLayout.CENTER);
    
    //East Border
    commentLabel = new JLabel("Comments");
    comments = new JTextArea(5,10);
    eastPanel = new JPanel();
    eastPanel.setLayout(new BorderLayout());
    eastPanel.add(commentLabel, BorderLayout.NORTH);
    eastPanel.add(comments, BorderLayout.CENTER);
    add(eastPanel, BorderLayout.EAST);
    
    //South Border
    submit = new JButton("Submit");
    submit.addActionListener(this);
    cancel = new JButton("Cancel");
    cancel.addActionListener(this);
    Color cColor = new Color(230,230,250);
    southPanel = new JPanel();
    southPanel.setBackground(cColor);
    southPanel.add(cancel);
    southPanel.add(submit);
    add(southPanel, BorderLayout.SOUTH);
    setSize(600,400);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent event){
    if(event.getSource() == submit){
     // System.out.println("Submitted!!");
      String n = nameTF.getText();
      String myState = state.getSelectedItem().toString();
      String c = comments.getText();
      boolean sp = sports.isSelected();
      boolean m = movie.isSelected();
      String gndr = "";
      if(male.isSelected()){
        gndr = "Male";
      }else if(female.isSelected()){
        gndr = "Female";
      }
      JOptionPane.showMessageDialog(null,"Name: " + n + "\nState: " + myState + "\nComments: " + c
                                   + "\nSports: " + sp + "\nMovie: " + m + "\nGender: " + gndr);
    }else if(event.getSource() == cancel){
      //System.out.println("Cancelled!!");
      nameTF.setText("");
      comments.setText("");
      sports.setSelected(false);
      movie.setSelected(false);
      group.clearSelection();
    }
  }
  
  public static void main(String [] args){
    GUIExample2 e2 = new GUIExample2();
  }//end main method
  
}//end GUIExample2 class