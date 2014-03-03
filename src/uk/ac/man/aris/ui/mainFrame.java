/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.aris.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mbaxkak4
 */
public final class mainFrame extends JFrame{
     private static JPanel ActivePanel;
     
    public void setPanel(JPanel panel){
        setUpFrame();
        ActivePanel=panel;
        this.setContentPane(panel);
        this.setVisible(true);
    }
    public JPanel getPanel(){
        if(ActivePanel instanceof LoginScreen){
        return (LoginScreen) ActivePanel;}
        else{
        return (UserInterface) ActivePanel;}
    }
    
    private void setUpFrame(){
        
          /* Set-Up frame size and position  */
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setSize(new Dimension(900,800));
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
         this.setTitle("Welcome to UoM on-line Account Manager");
    
    }
    
 public void addLoginListeners(ActionListener act){
 ((LoginScreen)ActivePanel).addListeners(act);}
 public void addUIListeners(ActionListener act){
 ((UserInterface)ActivePanel).addListeners(act);}
}
