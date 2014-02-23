/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.init;

import uk.ac.man.aris.controller.Controller;
import uk.ac.man.aris.model.Model;
import uk.ac.man.aris.ui.LoginScreen;
import uk.ac.man.aris.ui.UserInterface;
import uk.ac.man.aris.ui.mainFrame;

/**
 * Initialization class: Starts project's main thread
 * @author aris
 */
public class Initializer {
    
    
    public static void main (String[] args){
    
        mainFrame main=new mainFrame();
        main.setPanel(new UserInterface());
        main.setVisible(true);
        Model mod=new Model();
        Controller con=new Controller(main,mod);
        }
    
}
