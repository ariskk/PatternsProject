/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.aris.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mbaxkak4
 */
public class UserInterface extends JPanel{
    private final JLabel title;
    private final JLabel convert;
    private final JLabel submit;
    private final JLabel toLabel;
    private final JButton convertButton;
    private final JButton submitButton;
    
    public UserInterface(){
    title=new JLabel("");
    convert=new JLabel("Convert");
    submit=new JLabel("Submit");
    toLabel=new JLabel("to");
    convertButton=new JButton("Convert");
    submitButton=new JButton("Submit");
    
    
    }
    
    public void addListeners(){
    
    
    }
    
}
