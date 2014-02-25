/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.model;

import uk.ac.man.aris.dao.Account;
import uk.ac.man.aris.dao.Authentication;
import uk.ac.man.aris.dao.SQLiteAccountDAO;

/**
 * Model class that exposes the backend of the application to the Controller through the transfer objects
 * @author aris
 */
public class Model {
    private final double euroToDollarRate=1.37;
    private final double euroToPoundRate=0.83;
    private final double dollarToPoundRate=0.60;
    private Account account;
    
    public Model(){
    
    }
    //forward transactions to model classes
    
    
    public boolean authenticate(String username,String password){
        boolean auth=false;
        if(Authentication.authenticate(username, password)){
        auth=true;
        
        }
        return auth;}
    
    public double convert (String fromCurrency,String toCurrency,double amount){
        
    
    return 0;
    }
    public boolean submit(String toUser,String Currency,double amount){
     
    return false;}
}
