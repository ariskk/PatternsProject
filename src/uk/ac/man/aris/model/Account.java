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
    private double balanceDollars;
    private double balanceEuros;
    private double balancePounds;
    private ArrayList<Transaction> transactions;
            
    public Account() throws Exception{
        throw new Exception("ID must be initialised");
    }
    public Account(String ID){
    this.id=ID;}
}
