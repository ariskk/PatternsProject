/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * A Payment System dumb interface that has no external dependencies and is manipulated by a controller
 * 
 * @author aris
 */
public class UserInterface extends JFrame {
    
   /* GUI Component declarations */  
   private final JPanel mainPanel;
   private final JButton submitButton;
   private final JTextField cardNumberField;
   private final JTextField firstNameField;
   private final JTextField lastNameField;
   private final JLabel cardNumberLabel;
   private final JLabel firstNameLabel;
   private final JLabel lastNameLabel;
   private final JLabel messageArea;
  
   /* No argument constructor */
   public UserInterface () {
   mainPanel=new JPanel();
   submitButton=new JButton();
   cardNumberField=new JTextField(30);
   cardNumberLabel=new JLabel("<html><b>Card Number:</b></html>");
   firstNameField=new JTextField(30);
   firstNameLabel=new JLabel("<html><b>First Name:</b></html>");
   lastNameField=new JTextField(30);
   lastNameLabel=new JLabel("<html><b>Last Name:</b></html>");
   messageArea=new JLabel("Welcome to UoM On-line Banking System");
  
   initComponents();
   
   }
    
   
   /*  GUI componets initialization*/
  private void initComponents(){
         /* Set-Up frame size and position  */
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setSize(new Dimension(800,800));
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
         this.setTitle("Welcome to UoM Bank On-line Money Transfer System");

         /*Set-up Frame's Grid Layout   */
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        
        /* Add constraints and place GUI components   */
        con.gridx=0;
        con.gridy=0;
        con.weightx=1.0;
        con.weighty=1.0;
        mainPanel.add(firstNameLabel,con);
        con.gridx=1;
        con.weightx=3.0;
        mainPanel.add(firstNameField,con);
        
        con.gridx=0;
        con.gridy=1;
        con.weightx=1.0;
        con.weighty=1.0;
        mainPanel.add(lastNameLabel,con);
        con.gridx=1;
        con.weightx=3.0;
        mainPanel.add(lastNameField,con);
        
        con.gridx=0;
        con.gridy=2;
        con.weightx=1.0;
        con.weighty=1.0;
        mainPanel.add(cardNumberLabel,con);
        con.gridx=1;
        con.weightx=3.0;
        mainPanel.add(cardNumberField,con);
        
        con.gridx=0;
        con.gridy=3;
        con.weighty=4.0;
       
        mainPanel.add(messageArea,con);
        
       
        
                
        
        
        
         
         this.add(mainPanel);
         
   
   }
  
 /* GUI methods to get information and set messages areas*/
  
  /* Getters            */
  public String getCreditCard(){
  return "";}
  
  
  public String getFirstName(){
  return "";}
  
  /* Setters*/
  
  public void setMessage(String msg){
  messageArea.setText(msg);
  
  }
  /* External classes can GUI listeners to implement an observer pattern    */
  public void addListeners(){
  
  
  
  }
}
