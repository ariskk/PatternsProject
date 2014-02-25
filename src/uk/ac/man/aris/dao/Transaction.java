/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.sql.Timestamp;

/**
 * A transaction class
 * @author aris
 */
public class Transaction {
    private  final String fromID;
    private  final String toID;
    private  final double amountDollars;
    private  final double amountEuros;
    private  final double amountPounds;
    private  final Timestamp time;
    
    public Transaction() throws Exception{
        throw new Exception("NUll constructor not allowed");
     }
    
    public Transaction(String from,String to,double dol,double eur,double gbp,Timestamp time){
    this.fromID=from;
    this.toID=to;
    this.amountDollars=dol;
    this.amountEuros=eur;
    this.amountPounds=gbp;
    this.time=time;
    
    }
    
    /*Transaction Getters*/
    
        public String getFromID() {
        return fromID;
    }

    public String getToID() {
        return toID;
    }

    public double getAmountDollars() {
        return amountDollars;
    }

    public double getAmountEuros() {
        return amountEuros;
    }

    public double getAmountPounds() {
        return amountPounds;
    }

    public Timestamp getTime() {
        return time;
    }
    
}
