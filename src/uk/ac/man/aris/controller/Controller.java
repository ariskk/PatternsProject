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
 * 
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
                
               if(model.authenticate(((LoginScreen)mainF.getPanel()).getUsername(),((LoginScreen)mainF.getPanel()).getPassword())){
              mainF.setPanel(new UserInterface());
              mainF.addUIListeners(this);
              ((UserInterface)mainF.getPanel()).setMessage("The system is ready to accept transactions");
               }
              else{
              ((LoginScreen)mainF.getPanel()).setMessage("Invalid Login Credentials");}
              }break;
                
            case "Convert":{
              double result;
              result = model.convert(((UserInterface)mainF.getPanel()).getFromCurrency(),((UserInterface)mainF.getPanel()).getToCurrency(), ((UserInterface)mainF.getPanel()).getConversionAmount());
              if(result!=0){
              ((UserInterface)mainF.getPanel()).setMessage("Successfully purchaced"+result+" "+((UserInterface)mainF.getPanel()).getToCurrency());
              System.out.println("success");}
              else{
               ((UserInterface)mainF.getPanel()).setMessage("Not Enough funds");      
              System.out.println("not success");}
            
            }break;
                
            case "Submit":{
                if(model.submit(((UserInterface)mainF.getPanel()).getSubmissionUsername(),((UserInterface)mainF.getPanel()).getSubmitCurrency(),((UserInterface)mainF.getPanel()).getSubmissionAmount()))
                {((UserInterface)mainF.getPanel()).setMessage("Transaction completed successfully");  }
                else
                {((UserInterface)mainF.getPanel()).setMessage("Not Enough funds");  }
             
             }break;
    }}

}

