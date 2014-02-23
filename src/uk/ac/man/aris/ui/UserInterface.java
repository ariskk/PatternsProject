/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.aris.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author mbaxkak4
 */
public class UserInterface extends JPanel{
    private final JLabel title;
    private final JLabel convert;
    private final JLabel submit;
    private final JLabel toLabel;
    private final JTextField from;
    private final JTextField to;
    private final JTextField amount;
    private final JTextField targetAccount;
    private final JButton convertButton;
    private final JButton submitButton;
    private final JComboBox dropdownCurrencyFrom;
    private final JComboBox dropdownCurrencyTo;
    private final JComboBox dropdownCurrencySubmit;
    private final String[] currencies= {"Euros","Dollars","Pounds"};
    
    public UserInterface(){
    title=new JLabel("");
    convert=new JLabel("Convert");
    submit=new JLabel("Submit funds to Account:");
    toLabel=new JLabel("to");
    from=new JTextField(10);
    to=new JTextField(10);
    amount=new JTextField(10);
    targetAccount=new JTextField(10);
    convertButton=new JButton("Convert");
    submitButton=new JButton("Submit");
    dropdownCurrencyFrom=new JComboBox(currencies);
    dropdownCurrencyTo=new JComboBox(currencies);
    dropdownCurrencySubmit=new JComboBox(currencies);
    initComponents();
    }
    
    private void initComponents(){
    
        /*Set-up Frame's Grid Layout   */
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
       /*Title*/
        con.gridx=0;
        con.gridy=0;
        con.weightx=5.0;
        this.add(title,con);
        /* Convert currencies*/
        con.gridx=0;
        con.gridy=1;
        con.weightx=1.0;
        con.weighty=1.0;
        this.add(convert,con);
        con.gridx=1;
        this.add(dropdownCurrencyFrom,con);
        con.gridx=2;
        this.add(from,con);
        con.gridx=3;
        this.add(toLabel,con);
        con.gridx=4;
        this.add(dropdownCurrencyTo,con);
        con.gridx=5;
        this.add(to,con);
        /*Submit payments*/
        con.gridx=0;
        con.gridy=2;
        this.add(submit,con);
        con.gridx=1;
        this.add(targetAccount,con);
        con.gridx=2;
        this.add(dropdownCurrencySubmit,con);
        con.gridx=3;
        this.add(amount,con);
        
        
        /*Buttons*/
        con.gridy=3;
        con.gridx=0;
        this.add(submitButton,con);
        
    }
    
    protected void addListeners(ActionListener act){
    convertButton.addActionListener(act);
    submitButton.addActionListener(act);
    
    }
    public void setTitle(String titleMsg){
    title.setText(titleMsg);
    }
    
    public String getFromCurrency(){
        return String.valueOf(dropdownCurrencyFrom.getSelectedItem());}
    
    public String getToCurrency(){
        return String.valueOf(dropdownCurrencyTo.getSelectedItem());}
    
    public String getSubmitCurrency(){
        return String.valueOf(dropdownCurrencySubmit.getSelectedItem());}
}
