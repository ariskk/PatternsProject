/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Account DAO implementation for SQLite
 * Accesses the SQLite to retrieve the account and create the account object. Called by the factory
 * TODO ADD TRANSACTIONS and fix timestamp bug
 * @author aris
 */
public class SQLiteAccountDAO implements AccountDAO {
    private String username;
    private  Connection c;
    
    public SQLiteAccountDAO(){
    
    }
    
    public SQLiteAccountDAO(String username){
        this.username=username;
      
    }
    
    @Override
    public Account getAccount(String user) {
       
        double pounds=0,euros=0,dollars=0;
       
        try {  
          c=SQLiteConnectionSingleton.getConnection();
          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Accounts WHERE username='" +user+"';");
          while ( rs.next() ) {
           
           pounds=rs.getDouble("pounds");
           euros=rs.getDouble("euros");
           dollars=rs.getDouble("dollars");
          
             }
           rs.close();
           stmt.close();
          
        }
        catch (SQLException e){
                               }
        return new Account(user,dollars,euros,pounds,null);
    }

    @Override
    public void upedateAccount(Account acc) {
     
        try {  
          c=SQLiteConnectionSingleton.getConnection();  
          Statement stmt = c.createStatement();
          
          stmt.executeUpdate("UPDATE Accounts set dollars='"+acc.getDollars()+"',euros='"+acc.getEuros()+"',pounds='"+acc.getPounds()+
                             "' WHERE username='"+acc.getUsername()+"';");
           c.commit(); 
           stmt.close();
         
        }
        catch (SQLException e){
                }
    }

    @Override
    public void createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //Not supported,since there is no register UI
    }
    
}
