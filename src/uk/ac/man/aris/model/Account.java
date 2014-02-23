/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.model;

import java.util.ArrayList;

/**
 * An account class
 * @author aris
 */
public class Account {
    
    private final String id;
    private static double balanceDollars;
    private static double balanceEuros;
    private static double balancePounds;
    private static ArrayList<Transaction> transactions;
            
    public Account() throws Exception{
        throw new Exception("ID must be initialised");
    }
    public Account(String ID){
    this.id=ID;}
    
    public static void setDollars(double dol){
    balanceDollars=dol;}
    public static double getDollars(){return balanceDollars;}
    
    public static void setEuros(double eur){
    balanceEuros=eur;}
    public static double getEuros(){return balanceEuros;}
    
    public static void setPounds(double gbp){
    balancePounds=gbp;}
    public static double getPounds(){return balancePounds;}
    
    
    //something smarter
    public static void addTransaction(){
    /*TODO
     * transaction new transaction ktl and add it */}
    public static ArrayList getTranscations(){
        
    return transactions;}
    
}
