/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.model;

import java.text.DecimalFormat;
import uk.ac.man.aris.dao.Account;
import uk.ac.man.aris.dao.AccountDAO;
import uk.ac.man.aris.dao.Authentication;
import uk.ac.man.aris.dao.DAOFactory;
import uk.ac.man.aris.dao.Transaction;
import uk.ac.man.aris.dao.TransactionDAO;

/**
 * Model class that exposes the backend of the application to the Controller through a transaction interface
 * and exchanges data with the DAOs using transfer objects.
 * @author aris
 */
public class Model {
    private final double euroToDollarRate=1.37;
    private final double euroToPoundRate=0.83;
    private final double dollarToPoundRate=0.60;
    private Account account;                  //transfer object
    private Transaction transaction;          //transfer object
    private final DAOFactory sqliteFactory;   //abstract factory
    private AccountDAO accountDAO;            //Interface
    private TransactionDAO transactionDAO;
    
    public Model(){
    sqliteFactory=DAOFactory.getDAOFactory(1);  //SQLite=1;
    accountDAO=sqliteFactory.getAccountDAO();
    transactionDAO=sqliteFactory.getTranscactionDAO();
    }
   
    
    public boolean authenticate(String username,String password){
        boolean auth=false;
        if(Authentication.authenticate(username, password)){
        auth=true;
        account=accountDAO.getAccount(username);
       
        }
        return auth;}
    
    public String balance(){
        DecimalFormat df=new DecimalFormat("#.0");
    return "Balance \nDollars:"+df.format(account.getDollars())+"\n Euros:"+df.format(account.getEuros())+"\n Pounds:"+df.format(account.getPounds());}
    
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
                        // transaction=new Transaction(account.getUsername(),account.getUsername(),result,-1*amount,0,0);
                         transactionDAO.createTransaction(account.getUsername(),account.getUsername(),result,-1*amount,0);
                     }
                          break;
                     case "Pounds":{
                        result=amount*euroToPoundRate;
                        account.setEuros(account.getEuros()-amount);
                        account.setPounds(account.getPounds()+result);
                        accountDAO.upedateAccount(account);
                        transactionDAO.createTransaction(account.getUsername(),account.getUsername(),0,-1*amount,result);
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
                          transactionDAO.createTransaction(account.getUsername(),account.getUsername(),-1*amount,result,0);
                     }
                         break;
                     case "Pounds":{
                         result=amount*dollarToPoundRate;
                         account.setDollars(account.getDollars()-amount);
                         account.setPounds(account.getPounds()+result);
                         accountDAO.upedateAccount(account);
                         transactionDAO.createTransaction(account.getUsername(),account.getUsername(),-1*amount,0,result);
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
                         transactionDAO.createTransaction(account.getUsername(),account.getUsername(),result,0,-1*amount);
                     }
                         break;
                     case "Euros":{
                          result=amount/euroToPoundRate;
                          account.setPounds(account.getPounds()-amount);
                          account.setEuros(account.getEuros()+result);
                          accountDAO.upedateAccount(account);
                          transactionDAO.createTransaction(account.getUsername(),account.getUsername(),0,result,-1*amount);
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
               transactionDAO.createTransaction(account.getUsername(),clientAccount.getUsername(),0,amount,0);
               return true;
           }
        
        }
        case "Dollars":{
           if(account.getDollars()>amount){
               account.setDollars(account.getDollars()-amount);
               clientAccount.setDollars(clientAccount.getDollars()+amount);
               
               accountDAO.upedateAccount(account);
               accountDAO.upedateAccount(clientAccount);
               transactionDAO.createTransaction(account.getUsername(),account.getUsername(),amount,0,0);
               return true;
           
           }
        }
        case "Pounds":{
           if(account.getPounds()>amount){
               account.setPounds(account.getPounds()-amount);
               clientAccount.setPounds(clientAccount.getPounds()+amount);
               
               accountDAO.upedateAccount(account);
               accountDAO.upedateAccount(clientAccount);
               transactionDAO.createTransaction(account.getUsername(),account.getUsername(),0,0,amount);
               return true;
           }
        
        }
    
    }   
    return false;}
}
