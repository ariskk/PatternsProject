/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.ui;



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * A Payment System dumb interface that has no external dependencies and is manipulated by a controller
 * 
 * @author aris
 */
public class LoginScreen extends JPanel{
    
   /* GUI Component declarations */  
   
   private final JButton submitButton;
   private final JButton cancelButton;

   private final JTextField usernameField;
   private final JPasswordField passField;

   private final JLabel usernameLabel;
   private final JLabel passLabel;
   private final JLabel messageArea;
  
   /* No argument constructor */
   public LoginScreen () {
   
   submitButton=new JButton("Login");
   cancelButton=new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            } });
   usernameField=new JTextField(30);
   usernameLabel=new JLabel("<html><b>Username:</b></html>");
   passField=new JPasswordField(30);
   passLabel=new JLabel("<html><b>Password:</b></html>");
   messageArea=new JLabel("Welcome to UoM On-line Account Manager");
  
   initComponents();
   
   }
    
   
   /*  GUI componets initialization*/
  private void initComponents(){
       
         /*Set-up Frame's Grid Layout   */
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        
        /* Add constraints and place GUI components   */
        con.gridx=0;
        con.gridy=0;
        con.weightx=1.0;
        con.weighty=1.0;
        this.add(usernameLabel,con);
        con.gridx=1;
        con.weightx=3.0;
        this.add(usernameField,con);
        
        con.gridx=0;
        con.gridy=1;
        con.weightx=1.0;
        con.weighty=1.0;
        this.add(passLabel,con);
        con.gridx=1;
        con.weightx=3.0;
        this.add(passField,con);
        
        con.gridx=0;
        con.gridy=2;
        con.weightx=1.0;
        con.weighty=1.0;
        this.add(submitButton,con);
        con.gridx=1;
        con.weightx=3.0;
        this.add(cancelButton,con);
       
        
        con.gridx=0;
        con.gridy=3;
        con.weighty=4.0;
       
        this.add(messageArea,con);
        
      
         
   
   }
  
 /* GUI methods to get information and set messages areas*/
  
  /* Getters            */
  public String getUsername(){
  return usernameField.getText();}
  
  
  public String getPassword(){
  return passField.getPassword().toString();}
  
  /* Setters*/
  
  public void setMessage(String msg){
  messageArea.setText(msg);
  }
  /* External classes can place GUI listeners to implement an observer pattern    */
  protected void addListeners(ActionListener act){
      submitButton.addActionListener(act);
  }
}
