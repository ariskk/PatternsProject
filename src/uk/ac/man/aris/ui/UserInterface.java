/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.aris.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * TODO : messages next to buttons and maybe transaction history 
 * @author mbaxkak4
 */
public class UserInterface extends JPanel{
    private final JLabel title;
    private final JLabel convert;
    private final JLabel submit;
    private final JLabel toLabel;
    private final JLabel funds;
    private final JTextArea messages;
    private final JTextField from;
    private final JLabel to;
    private final JTextField amount;
    private final JTextField targetAccount;
    private final JButton convertButton;
    private final JButton submitButton;
    private final JComboBox dropdownCurrencyFrom;
    private final JComboBox dropdownCurrencyTo;
    private final JComboBox dropdownCurrencySubmit;
    private final String[] currencies= {"Euros","Dollars","Pounds"};
    
    public UserInterface(){
    title=new JLabel(new ImageIcon("logo.jpg"));
    convert=new JLabel("Convert currencies :");
    submit=new JLabel("Submit funds to Account:");
    toLabel=new JLabel("to");
    funds=new JLabel("Amount");
    messages=new JTextArea(5,19);
    from=new JTextField(7);
    to=new JLabel(); 
    amount=new JTextField(7);
    targetAccount=new JTextField(7);
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
         con.gridx=1;
         con.gridy=0;
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
        to.setBackground(Color.white);
        this.add(to,con);
        con.gridx=0;
        con.gridy=2;
        this.add(convertButton,con);
        /*Submit payments*/
        con.gridx=0;
        con.gridy=3;
        this.add(submit,con);
        con.gridx=1;
        this.add(targetAccount,con);
        con.gridx=2;
        this.add(new JLabel(""),con);
        con.gridx=3;
        this.add(funds,con);
        con.gridx=4;
        this.add(dropdownCurrencySubmit,con);
        con.gridx=5;
        this.add(amount,con);
        con.gridy=4;
        con.gridx=0;
        this.add(submitButton,con);
        con.gridy=5;
        this.add(messages,con);
        
        
    }
    
    protected void addListeners(ActionListener act){
    convertButton.addActionListener(act);
    submitButton.addActionListener(act);
    
    }
    public void setTitle(String titleMsg){
    title.setText(titleMsg);
    }
    
    public void setMessage(String msg){
    messages.setText(msg);}
    
    public void setToText(String txt){
    to.setText(txt);}
    
    public String getFromCurrency(){
        return String.valueOf(dropdownCurrencyFrom.getSelectedItem());}
    
    public String getToCurrency(){
        return String.valueOf(dropdownCurrencyTo.getSelectedItem());}
    
    public String getSubmitCurrency(){
        return String.valueOf(dropdownCurrencySubmit.getSelectedItem());}
    
    public double getConversionAmount(){
    return Double.parseDouble(from.getText());}
    public double getSubmissionAmount(){
    return Double.parseDouble(amount.getText());}
    
    public String getSubmissionUsername(){
    return targetAccount.getText();}
}
