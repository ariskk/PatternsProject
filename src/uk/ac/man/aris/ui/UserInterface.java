/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.ui;

import java.awt.Dimension;
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
   private final JTextField firstName;
   private final JLabel firstNameLabel;
   private final JLabel messageArea;
   
   public UserInterface () {
   mainPanel=new JPanel();
   submitButton=new JButton();
   cardNumber=new JTextField();
   firstName=new JTextField();
   firstNameLabel=new JLabel("<b>First Name</b>");
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
         
         
         this.add(mainPanel);
         
   
   }
  
  
  /* Getters            */
  public String getCreditCard(){
  return "";}
  
  
  public String getFirstName(){
  return "";}
  
}
