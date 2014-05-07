/*CJ Gehin-Scott
 * IT-230*/

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.sql.*;
import java.net.*;

public class HotelReservation extends JFrame implements ActionListener{
  private JLabel firstNameLabel, lastNameLabel, checkInLabel, checkOutLabel, specialRatesLabel, roomTypeLabel, billingAddressLabel, streetLabel, cityLabel, stateLabel, zipLabel, 
  phoneLabel, ccTypeLabel, ccNumberLabel, expirationLabel, blankLabel, visaLabel, masterLabel, amexLabel, discoverLabel, specialRequestsLabel, handicapLabel;
  private JTextField firstNameTF, lastNameTF, checkInTF, checkOutTF, streetTF,cityTF,zipTF,phoneTF, ccNumberTF, expirationTF;
  private JPanel northPanel, westPanel, westPanel2, westPanel3, eastPanel, billingPanel, billingPanel2, ccPanel, ccPanelCenter, ccPanelSouth, southPanel;
  private JComboBox numberOfRoomsCB, numberOfGuestsCB, stateCB, handicapCB;
  private JRadioButton noneButton, aaaButton, seniorButton, govtMiltButton, studioButton, standardButton, familyButton, suiteButton, visaButton, masterButton, amexButton, discoverButton;
  private JButton submit, cancel,search,delete;
  private ButtonGroup ccGroup, specialRatesGroup, roomTypeGroup;
  private JTextArea specialRequestsTA;
  private Socket socket;
  private ServerSocket serverSocket;
  private ObjectOutputStream output;
  private ObjectInputStream input;
  private String sendMessage; //message to be sent to the server
  private String receiveMessage; //message to be received by the server
  
    
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
    northPanel.setBackground(Color.cyan);
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
    studioButton.setToolTipText("One Queen Bed");
    standardButton = new JRadioButton("Standard");
    standardButton.setToolTipText("One King Bed or Two Queen Beds");
    familyButton = new JRadioButton("Family");
    familyButton.setToolTipText("Three Queen Beds and Living Room");
    suiteButton = new JRadioButton("Suite");
    suiteButton.setToolTipText("Two Bedrooms, Living Room, and a Kitchen");
    specialRatesGroup = new ButtonGroup();// groups the special rates button so that only one can be applied
    specialRatesGroup.add(noneButton);
    specialRatesGroup.add(aaaButton);
    specialRatesGroup.add(seniorButton);
    specialRatesGroup.add(govtMiltButton);
    roomTypeGroup = new ButtonGroup(); // groups the room type buttons so that only one can be selected at a time
    roomTypeGroup.add(studioButton);
    roomTypeGroup.add(standardButton);
    roomTypeGroup.add(familyButton);
    roomTypeGroup.add(suiteButton);
   //Holds the top half of the west panel
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
    //Holds the bottom half of the west panel
    specialRequestsLabel = new JLabel("Special Requests");
    specialRequestsTA = new JTextArea(3,6);
    westPanel3 = new JPanel();
    westPanel3.setLayout(new BorderLayout());
    westPanel3.add(specialRequestsLabel, BorderLayout.NORTH);
    westPanel3.add(specialRequestsTA, BorderLayout.CENTER);
    //Holds the entire west border
    westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(2,1));
    westPanel.add(westPanel2);
    westPanel.add(westPanel3);
    add(westPanel, BorderLayout.WEST);
      
    //East Border
    billingAddressLabel = new JLabel("Billing Address");
    billingAddressLabel.setForeground(Color.RED);
    blankLabel = new JLabel(" ");
    streetLabel = new JLabel("Street");
    streetTF = new JTextField(15);
    cityLabel = new JLabel("City");
    cityTF = new JTextField(15);
    stateLabel = new JLabel("State");
    String stateArray [] = {"Please Select One","Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware", "Washington D.C.", "Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas",
      "Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico",
      "New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia",
      "Washington","West Virginia","Wisconsin","Wyoming"};
    stateCB = new JComboBox(stateArray);
    zipLabel = new JLabel("Zip");
    zipTF = new JTextField(15);
    phoneLabel = new JLabel("Phone Number");
    phoneTF = new JTextField(15);
    ccTypeLabel = new JLabel("Credit Card Information:");
    ccTypeLabel.setForeground(Color.RED);
    
    //Visa Button
    visaButton = new JRadioButton();
    ImageIcon visaIcon = new ImageIcon("visa.gif");
    visaLabel = new JLabel(visaIcon);
    //Mastercard Button
    masterButton = new JRadioButton();
    ImageIcon masterIcon = new ImageIcon("master.gif");
    masterLabel = new JLabel(masterIcon);
    //American Express Button
    amexButton = new JRadioButton();
    ImageIcon amexIcon = new ImageIcon("amex.gif");
    amexLabel = new JLabel(amexIcon);
    //Discover Button
    discoverButton = new JRadioButton();
    ImageIcon discoverIcon = new ImageIcon("discover.gif");
    discoverLabel = new JLabel(discoverIcon);
    
    ccNumberLabel = new JLabel("Credit Card Number");
    expirationLabel = new JLabel("Expiration Date (mm/yyyy)");
    search = new JButton("Search");
    search.addActionListener(this);
    delete = new JButton("Delete Reservation");
    delete.addActionListener(this);
    ccNumberTF = new JTextField(5);
    expirationTF = new JTextField(5);
    handicapLabel = new JLabel("Handicap Accessible");
    String yesNoArray[] = {"","YES", "NO"};
    handicapCB = new JComboBox(yesNoArray);
    
    //panel that sorts the billing info into 8X2 grid layout
   billingPanel = new JPanel();
   billingPanel.setLayout(new BorderLayout());
   billingPanel.add(billingAddressLabel, BorderLayout.NORTH);
   billingPanel2 = new JPanel();
   billingPanel2.setLayout(new GridLayout(7,2));
   //billingPanel2.add(blankLabel);
   billingPanel2.add(streetLabel);
   billingPanel2.add(streetTF);
   billingPanel2.add(cityLabel);
   billingPanel2.add(cityTF);
   billingPanel2.add(stateLabel);
   billingPanel2.add(stateCB);
   billingPanel2.add(zipLabel);
   billingPanel2.add(zipTF);
   billingPanel2.add(phoneLabel);
   billingPanel2.add(phoneTF);
   billingPanel.add(billingPanel2, BorderLayout.CENTER);
   
   //panel that sorts the CC info into radio buttons to designate the type of credit card, and the card number and expiration
   ccPanel = new JPanel();
   ccPanel.setLayout(new BorderLayout());
   ccPanel.add(ccTypeLabel, BorderLayout.NORTH);
   ccGroup = new ButtonGroup(); // groups the credit card radio buttons so that only one can be clicked at a time
   ccGroup.add(visaButton);
   ccGroup.add(masterButton);
   ccGroup.add(amexButton);
   ccGroup.add(discoverButton);
   ccPanelCenter = new JPanel();
   ccPanelCenter.add(visaButton);
   ccPanelCenter.add(visaLabel);
   ccPanelCenter.add(masterButton);
   ccPanelCenter.add(masterLabel);
   ccPanelCenter.add(amexButton);
   ccPanelCenter.add(amexLabel);
   ccPanelCenter.add(discoverButton);
   ccPanelCenter.add(discoverLabel);
   ccPanel.add(ccPanelCenter, BorderLayout.CENTER);
   ccPanelSouth = new JPanel();
   ccPanelSouth.setLayout(new GridLayout(5,2));
   ccPanelSouth.add(ccNumberLabel);
   ccPanelSouth.add(expirationLabel);
   ccPanelSouth.add(ccNumberTF);
   ccPanelSouth.add(expirationTF);
   ccPanelSouth.add(search);
   ccPanelSouth.add(delete);
   ccPanelSouth.add(handicapLabel);
   ccPanelSouth.add(handicapCB);
   ccPanel.add(ccPanelSouth, BorderLayout.SOUTH);
     
   //panel that holds the billing panel and the CC panel for formatting purposes
   eastPanel = new JPanel();
   eastPanel.setLayout(new GridLayout(2,1));
   eastPanel.add(billingPanel);
   eastPanel.add(ccPanel);
   add(eastPanel, BorderLayout.EAST);
   
   //South Border
   submit = new JButton("Submit");
   submit.addActionListener(this);
   cancel = new JButton("Cancel");
   cancel.addActionListener(this);
   southPanel = new JPanel();
   southPanel.setBackground(Color.cyan);
   southPanel.add(cancel);
   southPanel.add(submit);
   add(southPanel, BorderLayout.SOUTH);
    
    setSize(900,620);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent event){
    if(event.getSource() == submit){
      String fn = firstNameTF.getText();
      String ln = lastNameTF.getText();
      String checkIn = checkInTF.getText();
      String checkOut = checkOutTF.getText();
      String numberRooms = numberOfRoomsCB.getSelectedItem().toString();
      String numberGuests = numberOfGuestsCB.getSelectedItem().toString();
      String discount = "";
      if(noneButton.isSelected()){
        discount = "None";
      }else if(aaaButton.isSelected()){
        discount = "AAA/CAA Discount";
      }else if(seniorButton.isSelected()){
        discount = "Senior Discount (65+)";
      }else if(govtMiltButton.isSelected()){
        discount = "Government/Military Discount";
      }
      String roomType = "";
      if(studioButton.isSelected()){
        roomType = "Studio";
      }else if(standardButton.isSelected()){
        roomType = "Standard";
      }else if(familyButton.isSelected()){
        roomType = "Family";
      }else if(suiteButton.isSelected()){
        roomType = "Suite";
      }
      String specialRequests = specialRequestsTA.getText();
      String street = streetTF.getText();
      String city = cityTF.getText();
      String zip = zipTF.getText();
      String state = stateCB.getSelectedItem().toString();
      String phone = phoneTF.getText();
      String creditType = "";
      if(visaButton.isSelected()){
        creditType = "Visa";
      }else if(masterButton.isSelected()){
        creditType = "Master Card";
      }else if(amexButton.isSelected()){
        creditType = "American Express";
      }else if(discoverButton.isSelected()){
        creditType = "Discover";
      }
      String ccNumber = ccNumberTF.getText();
      String expirationDate = expirationTF.getText();
      String handicap = handicapCB.getSelectedItem().toString();
      
      try{
        if(ccNumber.length() > 16 || ccNumber.length() < 16 && amexButton.isSelected() == false){
          throw new InvalidCreditCardException("Error:Wrong Credit Card Number!! Only enter 16 numbers on your credit card with no spaces");
        }else if(ccNumber.length() < 15 || ccNumber.length() <15  && amexButton.isSelected() == true){
          throw new InvalidCreditCardException("Invalid Amex number!! Only enter 15 numbers on your Amex credit card with no spaces");
        }else if(ccNumber.charAt(0) != '3' && amexButton.isSelected() == true){
          throw new InvalidCreditCardException("Invalid Amex card number!! Amex cards must begin with 3");
        }else if(ccNumber.charAt(0) != '4' && visaButton.isSelected() == true){
          throw new InvalidCreditCardException("Invalid Visa card number!! Visa cards must begin with 4");
        }else if(ccNumber.charAt(0) != '5' && masterButton.isSelected() == true){
          throw new InvalidCreditCardException("Invalid MasterCard card number!! MasterCard cards must begin with 5");
        }else if(ccNumber.charAt(0) != '6' && discoverButton.isSelected() == true){
          throw new InvalidCreditCardException("Invalid Discover card number!! Discover cards must begin with 6");
        }
        //Sends CC info to Server for validation
      try{
       socket = new Socket(InetAddress.getByName("localhost"),1098);
       output = new ObjectOutputStream(socket.getOutputStream());
       sendMessage = ccNumber + expirationDate;
       output.writeObject(sendMessage);//converts message string to stream format
       output.flush();
       input = new ObjectInputStream(socket.getInputStream());
       receiveMessage = (String) input.readObject();
      }catch(UnknownHostException uhe){
       uhe.printStackTrace();
      }catch(IOException ioe){
       ioe.printStackTrace();
      }catch(ClassNotFoundException cnfe){
       cnfe.printStackTrace();
      }
      String url = "jdbc:mysql://localhost/hotelReservations?user=root&password=";
      String insertQuery = "INSERT INTO reservations values('" + fn +"','" + ln +"','"+ checkIn +
        "','"+ checkOut + "','" + numberRooms + "','" + numberGuests +"','" + discount + "','"
        + specialRequests +"','"+ street + "','" + city + "','" + state + "','" + zip + "','" + phone +"','"
        + creditType +"','" + ccNumber + "','" + expirationDate +"','" + handicap +"','" +
        roomType +"');";
      if(receiveMessage.equalsIgnoreCase("yes")){
       try{
       Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(url);
          Statement stmt = conn.createStatement();
          stmt.execute(insertQuery);
       }catch(ClassNotFoundException cnfe){
        cnfe.printStackTrace();
       }catch(SQLException sqle){
        sqle.printStackTrace();
       }
       JOptionPane.showMessageDialog(null,"Your reservation was successfully saved!!"
       + "\nFirst Name: " + fn + "\nLast Name: " + ln + "\nCheck-In-Date:  " + checkIn + "\nCheck-Out-Date:  " + checkOut + "\nNumber of Rooms: " +
       numberRooms + "\nNumber of Guests: " + numberGuests  + "\nDiscount Applied: " + discount +"\nRoom Type Selected: " + roomType + "\nSpecial Requests: " 
       + specialRequests + "\nHandicap Accessible: " + handicap + "\nBilling Address: " + "\nStreet: " + street + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip + "\nPhone Number: " + phone 
       +"\nCredit Card Type: " +creditType + "\nCredit Card Number: " + ccNumber + "\nExpiration Date: " + expirationDate);
      }else{
       JOptionPane.showMessageDialog(null, "The credit card you entered is not valid.\n Please check the credit card number and expiration date and try again!");
      }
      }catch(InvalidCreditCardException icce){
        JOptionPane.showMessageDialog(null, icce.toString());
      }
    }else if(event.getSource() == cancel){
    firstNameTF.setText("");
    lastNameTF.setText("");
    checkInTF.setText("");
    checkOutTF.setText("");
    specialRequestsTA.setText("");
    streetTF.setText("");
    cityTF.setText("");
    zipTF.setText("");
    phoneTF.setText("");
    ccNumberTF.setText("");
    expirationTF.setText("");
    stateCB.setSelectedItem("Please Select One");
    numberOfRoomsCB.setSelectedItem("Number of Rooms");
    numberOfGuestsCB.setSelectedItem("Guests per Room");
    handicapCB.setSelectedItem("");
    specialRatesGroup.clearSelection();  
    roomTypeGroup.clearSelection();
    ccGroup.clearSelection();
    }else if(event.getSource() == search){
      String url = "jdbc:mysql://localhost/hotelReservations?user=root&password=";
      String ccNumber = ccNumberTF.getText();
      String ccSearchQuery = ("SELECT * FROM reservations WHERE creditCardNum = " + ccNumber + ";");
      try{
      Class.forName("com.mysql.jdbc.Driver"); 
      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();
      ResultSet result = stmt.executeQuery(ccSearchQuery);
      
         if(result.next()){
        JOptionPane.showMessageDialog(null,"Here is your reservation"
              + "\nFirst Name: " + result.getString(1) + "\nLast Name: " + result.getString(2) + "\nCheck-In-Date:  " + result.getString(3) + "\nCheck-Out-Date:  " + result.getString(4) + "\nNumber of Rooms: " +
                  result.getString(5) + "\nNumber of Guests: " + result.getString(6)  + "\nDiscount Applied: " + result.getString(7) +"\nRoom Type Selected: " + result.getString(18) + "\nSpecial Requests: " 
                  + result.getString(8) + "\nHandicap Accessible: " + result.getString(17) + "\nBilling Address: " + "\nStreet: " + result.getString(9) + "\nCity: " + result.getString(10) + "\nState: " + result.getString(11) + "\nZip: " + result.getString(12) + "\nPhone Number: " + result.getString(13) 
                  +"\nCredit Card Type: " +result.getString(14) + "\nCredit Card Number: " + result.getString(15) + "\nExpiration Date: " + result.getString(16));
      }else{
       JOptionPane.showMessageDialog(null, "There isn't a reservation under that credit-card number("
         + ccNumber +"). Please try again.");
      }
      }catch(SQLException sqle){
       sqle.printStackTrace();
      }catch(ClassNotFoundException cnfe){
       cnfe.printStackTrace();
      }
    }else if(event.getSource() == delete){
     String url = "jdbc:mysql://localhost/hotelReservations?user=root&password=";
        String ccNumber = ccNumberTF.getText();
        String ccDeleteQuery = ("DELETE FROM reservations WHERE creditCardNum = " + ccNumber + ";");
      try{
         Class.forName("com.mysql.jdbc.Driver"); 
         Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         stmt.execute(ccDeleteQuery);
         
       }catch(SQLException sqle){
        sqle.printStackTrace();
       }catch(ClassNotFoundException cnfe){
        cnfe.printStackTrace();
      }
      JOptionPane.showMessageDialog(null,"Your reservation with credit-card number ("+ccNumber+") has been deleted");
    }
  }
  public static void main(String[] args){
    HotelReservation h1 = new HotelReservation();
    
  }//end main method
}//end HotelReservation class