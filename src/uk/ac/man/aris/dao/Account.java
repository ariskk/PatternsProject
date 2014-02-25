/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.util.ArrayList;

/**
 * An account class
 * @author aris
 */
public class Account {
    
    private final String username;
    private  double balanceDollars;
    private  double balanceEuros;
    private  double balancePounds;
    private  ArrayList<Transaction> transactions;
            
    public Account() throws Exception{
        throw new Exception("ID must be initialised");
    }
    
    public Account(String ID,double dol,double eur,double gbp,ArrayList<Transaction> array){
    this.username=ID;
    this.balanceDollars=dol;
    this.balanceEuros=eur;
    this.balancePounds=gbp;
    this.transactions=array;}
    
    public  void setDollars(double dol){
    balanceDollars=dol;}
    public  double getDollars(){return balanceDollars;}
    
    public  void setEuros(double eur){
    balanceEuros=eur;}
    public  double getEuros(){return balanceEuros;}
    
    public  void setPounds(double gbp){
    balancePounds=gbp;}
    public  double getPounds(){return balancePounds;}
    
    
    //something smarter
    public static void addTransaction(){
    /*TODO
     * transaction new transaction ktl and add it */}
    public  ArrayList getTranscations(){
    return transactions;}
    
}
