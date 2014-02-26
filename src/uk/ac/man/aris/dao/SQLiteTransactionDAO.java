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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Transaction DAO implementation for SQLite
 * Accesses the SQLite to retrieve the transactions and create the transaction object. Called by the factory
 * @author aris
 */
public class SQLiteTransactionDAO implements TransactionDAO {
    private final Connection c;
    
    public SQLiteTransactionDAO(){
    c=SQLiteConnectionSingleton.getConnection();}
    
    @Override
    public void createTransaction(String username,String toUsername,double dollars,double euros,double pounds) {
        Statement stmt;
        try {
            stmt = c.createStatement();
            stmt.executeQuery("INSERT INTO Transactions (fromUser,toUser,timestamp,amountDollars,amountEuros,AmountPounds) VALUES ('"+username+"','"+
                             toUsername+"','"+0+"','"+dollars+"','"+euros+"','"+pounds+"');");
             stmt.close();
             c.close();   
             } catch (SQLException ex) {
             Logger.getLogger(SQLiteTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
           
    }

    @Override
    public Transaction getTransaction() {
        double pounds=0,euros=0,dollars=0;
       
        try {  
          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Accounts WHERE username='" +0+"';");
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
        catch (SQLException e){
                }
            return new Transaction(null,null,dollars,euros,pounds,null);
    }

    @Override
    public ArrayList<Transaction> getTransactions(String user) {
       Statement stmt;
        try {
            stmt = c.createStatement();
            stmt.executeQuery("SELECT * FROM Transactions WHERE fromUser='"+user+"';");
             stmt.close();
             c.close();   
             } catch (SQLException ex) {
             Logger.getLogger(SQLiteTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
        return null;
    }

    
}
