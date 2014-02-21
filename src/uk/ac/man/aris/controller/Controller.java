/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.controller;

import uk.ac.man.aris.model.Model;
import uk.ac.man.aris.ui.mainFrame;

/**
 * Initialize the Controller class that mediates between the UI and the Model/DB
 * @author aris
 */
public class Controller {
    /*No Argument Constructor throws Exception*/
    public Controller(){
    throw new ExceptionInInitializerError("No User Interface found!");
    }
    
   public Controller(final mainFrame mainF,final Model mod){
   //mainF.addListeners(new GuiListener());
   }






}

