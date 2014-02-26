/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.model;

import uk.ac.man.aris.dao.Account;
import uk.ac.man.aris.dao.AccountDAO;
import uk.ac.man.aris.dao.Authentication;
import uk.ac.man.aris.dao.DAOFactory;
import uk.ac.man.aris.dao.SQLiteAccountDAO;
import uk.ac.man.aris.dao.SQLiteDAOFactory;

/**
 * Model class that exposes the backend of the application to the Controller through a transaction interface
 * and exchanges data with the DAOs using transfer objects.
 * @author aris
 */
public class Model {
    private final double euroToDollarRate=1.37;
    private final double euroToPoundRate=0.83;
    private final double dollarToPoundRate=0.60;
    private Account account;
    private final DAOFactory sqliteFactory;
    private AccountDAO accountDAO;
    
    public Model(){
    sqliteFactory=DAOFactory.getDAOFactory(1);
    accountDAO=sqliteFactory.getAccountDAO();
    }
   
    
    public boolean authenticate(String username,String password){
        boolean auth=false;
        if(Authentication.authenticate(username, password)){
        auth=true;
        account=accountDAO.getAccount(username);
       // System.out.println(account.getUsername()+" "+account.getEuros());
        }
        return auth;}
    
    public double convert (String fromCurrency,String toCurrency,double amount){
        double result=0;
    switch(fromCurrency){
        case "Euros":{
             if(account.getEuros()>amount){
                 switch (toCurrency) {
                     case "Dollars":{
                         result=amount*euroToDollarRate;
                         account.setEuros(account.getEuros()-amount);
                         account.setDollars(account.getDollars()+result);
                         accountDAO.upedateAccount(account);
                     }
                          break;
                     case "Pounds":{
                        result=amount*euroToPoundRate;
                        account.setEuros(account.getEuros()-amount);
                        account.setPounds(account.getPounds()+result);
                        accountDAO.upedateAccount(account);
                     }
                         
                         break;
                 }
             
             }
        
        }break;
        case "Dollars":{
             if(account.getDollars()>amount){
                  switch (toCurrency) {
                     case "Euros":{
                         result=amount/euroToDollarRate;
                         account.setDollars(account.getDollars()-amount);
                         account.setEuros(account.getEuros()+result);
                          accountDAO.upedateAccount(account);
                     }
                         break;
                     case "Pounds":{
                         result=amount*dollarToPoundRate;
                         account.setDollars(account.getDollars()-amount);
                         account.setPounds(account.getPounds()+result);
                         accountDAO.upedateAccount(account);
                     }
                         break;
                  }
             }
        }break;
        case "Pounds":{
             if (account.getPounds()>amount){
                   switch (toCurrency) {
                     case "Dollars":{
                         result=amount/dollarToPoundRate;
                         account.setPounds(account.getPounds()-amount);
                         account.setDollars(account.getDollars()+result);
                         accountDAO.upedateAccount(account);
                     }
                         break;
                     case "Euros":{
                          result=amount/euroToPoundRate;
                          account.setPounds(account.getPounds()-amount);
                          account.setEuros(account.getEuros()+result);
                          accountDAO.upedateAccount(account);
                     }
                         break;
                   }
                   
             }
        
        }
    
    }   
    
    return result;
    }
    public boolean submit(String toUser,String Currency,double amount){
        Account clientAccount=accountDAO.getAccount(toUser);
     switch(Currency){
        case "Euros":{
           if(account.getEuros()>amount){
               account.setEuros(account.getEuros()-amount);
               clientAccount.setEuros(clientAccount.getEuros()+amount);
              //add transaction update object
               accountDAO.upedateAccount(account);
               accountDAO.upedateAccount(clientAccount);
           }
        
        }
        case "Dollars":{
           if(account.getDollars()>amount){
               account.setDollars(account.getDollars()-amount);
               clientAccount.setDollars(clientAccount.getDollars()+amount);
               
               accountDAO.upedateAccount(account);
               accountDAO.upedateAccount(clientAccount);
               
           
           }
        }
        case "Pounds":{
           if(account.getPounds()>amount){
               account.setPounds(account.getPounds()-amount);
               clientAccount.setPounds(clientAccount.getPounds()+amount);
               
               accountDAO.upedateAccount(account);
               accountDAO.upedateAccount(clientAccount);
           }
        
        }
    
    }   
    return false;}
}
