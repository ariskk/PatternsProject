/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
    public Account getAccount(String username) {
       double pounds=0,euros=0,dollars=0;
       
        try {  
          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Accounts WHERE username='" +username+"';");
          while ( rs.next() ) {
         
           String pass=rs.getString("password");
           pounds=rs.getDouble("pounds");
           euros=rs.getDouble("euros");
           dollars=rs.getDouble("dolalrs");
          //Transctions
       
           
               }
           rs.close();
           stmt.close();
           c.close();}
        catch (Exception e){
                }
        return new Account(username,dollars,euros,pounds,null);
    }

    @Override
    public void upedateAccount(String toUsername,double dollars,double euros,double pounds) {
      //TRANSACTION UPDATE THIS METHOD MUST BE NULL AND THIS MOVED TO TRANSACTION DAO
        try {  
          Statement stmt = c.createStatement();
          //long time=Timestamp.getTime();
          stmt.executeQuery("INSERT INTO Transactions (fromUser,toUser,timestamp,amountDollars,amountEuros,AmountPounds) VALUES ('"+username+"','"+
                             toUsername+"','"+0+"','"+dollars+"','"+euros+"','"+pounds+"');");
          
           
           stmt.close();
           c.close();}
        catch (Exception e){
                }
    }
    
}
