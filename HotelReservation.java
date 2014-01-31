/*CJ Gehin-Scott
 * IT-230*/

import javax.swing.*;
import java.awt.*;

public class HotelReservation extends JFrame{
  private JLabel firstNameLabel, lastNameLabel, checkInLabel, checkOutLabel, specialRatesLabel, roomTypeLabel, billingAddressLabel, streetLabel, cityLabel, stateLabel, zipLabel, 
  phoneLabel, ccTypeLabel, ccNumberLabel, expirationLabel, blankLabel;
  private JTextField firstNameTF, lastNameTF, checkInTF, checkOutTF, streetTF,cityTF,zipTF,phoneTF, ccNumberTF, expirationTF;
  private JPanel northPanel, westPanel, westPanel2, eastPanel, billingPanel, ccPanel, southPanel;
  private JComboBox numberOfRoomsCB, numberOfGuestsCB, stateCB;
  private JRadioButton noneButton, aaaButton, seniorButton, govtMiltButton, studioButton, standardButton, familyButton, suiteButton, visaButton, masterButton, amexButton, discoverButton;
  private JButton submit, cancel;
    
  //GUI constructor
  public HotelReservation(){
    setTitle("Super Cheap Hotel Reservations");
    setLayout(new BorderLayout());
    
    //North Border
    firstNameLabel = new JLabel("First Name");
    firstNameTF = new JTextField(15);
    lastNameLabel = new JLabel("Last Name");
    lastNameTF = new JTextField(15);
    northPanel = new JPanel();
    northPanel.add(firstNameLabel);
    northPanel.add(firstNameTF);
    northPanel.add(lastNameLabel);
    northPanel.add(lastNameTF);
    add(northPanel, BorderLayout.NORTH);
    
    //WestBorder
    checkInLabel = new JLabel("Check-In-Date (mm/dd/yyyy)");
    checkInTF = new JTextField(15);
    checkOutLabel = new JLabel("Check-Out-Date (mm/dd/yyyy)");
    checkOutTF = new JTextField(15);
    String roomsArray[] = {"Number of Rooms","1","2","3","4-9","10-25","25+"};
    String guestsArray[] = {"Guests per Room","1","2","3","4","5","6"};
    numberOfRoomsCB = new JComboBox(roomsArray);
    numberOfGuestsCB = new JComboBox(guestsArray);
    specialRatesLabel = new JLabel("Special Rates");
    roomTypeLabel = new JLabel("Room Type");
    noneButton = new JRadioButton("None");
    aaaButton = new JRadioButton("AAA/CAA Discount");
    seniorButton = new JRadioButton("Senior Discount (65+)");
    govtMiltButton = new JRadioButton("Government or Military Discount");
    studioButton = new JRadioButton("Studio");
    standardButton = new JRadioButton("Standard");
    familyButton = new JRadioButton("Family");
    suiteButton = new JRadioButton("Suite");
    westPanel2 = new JPanel();
    westPanel2.setLayout(new GridLayout(8,2));
    westPanel2.add(checkInLabel);
    westPanel2.add(checkOutLabel);
    westPanel2.add(checkInTF);
    westPanel2.add(checkOutTF);
    westPanel2.add(numberOfRoomsCB);
    westPanel2.add(numberOfGuestsCB);
    westPanel2.add(specialRatesLabel);
    westPanel2.add(roomTypeLabel);
    westPanel2.add(noneButton);
    westPanel2.add(studioButton);
    westPanel2.add(aaaButton);
    westPanel2.add(standardButton);
    westPanel2.add(seniorButton);
    westPanel2.add(familyButton);
    westPanel2.add(govtMiltButton);
    westPanel2.add(suiteButton);
    westPanel = new JPanel();
    westPanel.add(westPanel2);
    add(westPanel, BorderLayout.WEST);
    
    //East Border
    billingAddressLabel = new JLabel("Billing Address");
    blankLabel = new JLabel(" ");
    streetLabel = new JLabel("Street");
    streetTF = new JTextField(15);
    cityLabel = new JLabel("City");
    cityTF = new JTextField(15);
    stateLabel = new JLabel("State");
    String stateArray [] = {"Please Select One","Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas",
      "Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico",
      "New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia",
      "Washington","West Virginia","Wisconsin","Wyoming"};
    stateCB = new JComboBox(stateArray);
    zipLabel = new JLabel("Zip");
    zipTF = new JTextField(15);
    phoneLabel = new JLabel("Phone Number");
    phoneTF = new JTextField(15);
    ccTypeLabel = new JLabel("Credit Card Type:");
    visaButton = new JRadioButton("Visa");
    masterButton = new JRadioButton("MasterCard");
    amexButton = new JRadioButton("American Express");
    discoverButton = new JRadioButton("Discover");
    ccNumberLabel = new JLabel("Credit Card Number");
    expirationLabel = new JLabel("Expiration Date (mm/yyyy)");
    ccNumberTF = new JTextField(5);
    expirationTF = new JTextField(5);
    //panel that sorts the billing info into 6X2 grid layout
   billingPanel = new JPanel();
   billingPanel.setLayout(new GridLayout(8,2));
   billingPanel.add(billingAddressLabel);
   billingPanel.add(blankLabel);
   billingPanel.add(streetLabel);
   billingPanel.add(streetTF);
   billingPanel.add(cityLabel);
   billingPanel.add(cityTF);
   billingPanel.add(stateLabel);
   billingPanel.add(stateCB);
   billingPanel.add(zipLabel);
   billingPanel.add(zipTF);
   billingPanel.add(phoneLabel);
   billingPanel.add(phoneTF);
   billingPanel.add(ccNumberLabel);
   billingPanel.add(expirationLabel);
   billingPanel.add(ccNumberTF);
   billingPanel.add(expirationTF);
   //panel that sorts the CC info into radio buttons to designate the type of credit card, and the card number and expiration
   ccPanel = new JPanel();
   ccPanel.setLayout(new GridLayout(6,2));
   ccPanel.add(ccTypeLabel);
   ButtonGroup ccGroup = new ButtonGroup(); // groups the credit card radio buttons so that only one can be clicked at a time
   ccGroup.add(visaButton);
   ccGroup.add(masterButton);
   ccGroup.add(amexButton);
   ccGroup.add(discoverButton);
   ccPanel.add(visaButton);
   ccPanel.add(masterButton);
   ccPanel.add(amexButton);
   ccPanel.add(discoverButton);
   //panel that holds the billing panel and the CC panel for formatting purposes
   eastPanel = new JPanel();
   eastPanel.setLayout(new GridLayout(4,1));
   eastPanel.add(billingPanel);
   eastPanel.add(ccPanel);
   add(eastPanel, BorderLayout.EAST);
   
   //South Border
   submit = new JButton("Submit");
   cancel = new JButton("Cancel");
   southPanel = new JPanel();
   southPanel.add(cancel);
   southPanel.add(submit);
   add(southPanel, BorderLayout.SOUTH);
    
    setSize(1200,720);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public static void main(String[] args){
    HotelReservation h1 = new HotelReservation();
  }//end main method
}//end HotelReservation class