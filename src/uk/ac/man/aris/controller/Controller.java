/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uk.ac.man.aris.model.Model;
import uk.ac.man.aris.ui.LoginScreen;
import uk.ac.man.aris.ui.UserInterface;
import uk.ac.man.aris.ui.mainFrame;

/**
 * Initialize the Controller class that mediates between the UI and the Model/DB
 * @author aris
 */
public class Controller implements ActionListener {
    private mainFrame mainF;
    private Model model;
  
    
    /*No Argument Constructor throws Exception*/
    public Controller(){
    throw new ExceptionInInitializerError("No User Interface found!");
    }
    
   public Controller(final mainFrame mainF,final Model mod){
     this.mainF=mainF;
     this.model=mod;
     mainF.addLoginListeners(this);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
          switch(e.getActionCommand()){
            case "Login":{
              
             System.out.println(((LoginScreen)mainF.getPanel()).getUsername());
             System.out.println(((LoginScreen)mainF.getPanel()).getPassword());
             
              mainF.setPanel(new UserInterface());
              mainF.addUIListeners(this);
              
            }
            case "Convert":{
            
            
            }
            case "Submit":{
            
            
            
            
            }
    }}






}

