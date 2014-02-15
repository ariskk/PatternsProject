/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.ui;

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

/**
 *
 * @author aris
 */
public class UserInterface extends JFrame {
    
   private final JPanel mainPanel;
   private final JButton submitButton;
   private final JTextField cardNumber;
   private final JTextField firstNameField;
   private final JLabel firstNameLabel;
   private final JLabel messageArea;
   
   public UserInterface () {
   mainPanel=new JPanel();
   submitButton=new JButton();
   cardNumber=new JTextField();
   firstNameField=new JTextField(30);
   firstNameLabel=new JLabel("<html><b>First Name:</b></html>");
   messageArea=new JLabel("Welcome to UoM On-line Banking System");
   initComponents();
   
   }
    
   
   
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
        con.gridy=2;
        con.weighty=4.0;
        mainPanel.add(messageArea,con);
        
       
        
                
        
        
        
         
         this.add(mainPanel);
         
   
   }
  
  
  /* Getters            */
  public String getCreditCard(){
  return "";}
  
  
  public String getFirstName(){
  return "";}
  
}
