/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.init;

import uk.ac.man.aris.controller.Controller;
import uk.ac.man.aris.ui.UserInterface;

/**
 * Initialization
 * @author aris
 */
public class Initializer {
    
    
    public static void main (String[] args){
    
        //init db
        //controller
        //init gui
        UserInterface ui=new UserInterface();
        ui.setVisible(true);
        Controller con=new Controller(ui);
    
    
    }
    
}
