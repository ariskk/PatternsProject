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
    private final String username;
    private final Connection c;
    
    public SQLiteAccountDAO(String username){
        this.username=username;
        c=SQLiteDAOFactory.createConnection();
    }
    
    @Override
    public Account getAccount() {
       double pounds=0,euros=0,dollars=0;
       
        try {  
          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Accounts WHERE username='" +username+"';");
          while ( rs.next() ) {
         
           pounds=rs.getDouble("pounds");
           euros=rs.getDouble("euros");
           dollars=rs.getDouble("dolalrs");
          //Transctions
       
             }
           rs.close();
           stmt.close();
           c.close();}
        catch (SQLException e){
                               }
        return new Account(username,dollars,euros,pounds,null);
    }

    @Override
    public void upedateAccount(Account acc) {
     
        try {  
          Statement stmt = c.createStatement();
          //long time=Timestamp.getTime();
          stmt.executeQuery("INSERT INTO Accounts (username,amountDollars,amountEuros,AmountPounds) VALUES ('"+acc.getUsername()+"','"+
                             "','"+acc.getDollars()+"','"+acc.getEuros()+"','"+acc.getPounds()+"');");
           stmt.close();
           c.close();}
        catch (SQLException e){
                }
    }

    @Override
    public void createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //Not supported,since there is no register UI
    }
    
}
