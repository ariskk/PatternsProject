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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Transaction DAO implementation for SQLite
 * Accesses the SQLite to retrieve the transactions and create the transaction transfer object.
 * @author aris
 */
public class SQLiteTransactionDAO implements TransactionDAO {
    private Connection c;
    
    public SQLiteTransactionDAO(){
    }
    
    //creates a database entry for each transaction performed
    @Override
    public void createTransaction(String username,String toUsername,double dollars,double euros,double pounds) {
        Statement stmt;
        try {
             c=SQLiteConnectionSingleton.getConnection();
             stmt = c.createStatement();
             Timestamp t=new Timestamp(System.currentTimeMillis());
             stmt.executeUpdate("INSERT INTO transactions (fromUser,toUser,timestamp,amountDollars,amountEuros,amountPounds) VALUES ('"+username+"','"+
                             toUsername+"','"+t.getTime()+"','"+dollars+"','"+euros+"','"+pounds+"');");
             c.commit();
             stmt.close();
               
             } catch (SQLException ex) {
             Logger.getLogger(SQLiteTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
           
    }
     
     //Get a specific transaction.Not useful in the oficial version
    @Override
    public Transaction getTransaction() {
        double pounds=0,euros=0,dollars=0;
       
        try {  
            try (Statement stmt = c.createStatement()) {
                ResultSet rs = stmt.executeQuery( "SELECT * FROM Accounts WHERE username='" +0+"';");
                while ( rs.next() ) {
                    
                    String pass=rs.getString("password");
                    pounds=rs.getDouble("pounds");
                    euros=rs.getDouble("euros");
                    dollars=rs.getDouble("dolalrs");
                   
                }
                rs.close();
            }
           c.close();}
        catch (SQLException e){
                }
            return new Transaction(null,null,dollars,euros,pounds,0);
    }

     //Get all the transaction in an ArrayList of Transaction transfer objects
    @Override
    public ArrayList<Transaction> getTransactions(String user) {
       Statement stmt;
       ArrayList transactions=new ArrayList();
       Transaction transaction;
        try {
            c=SQLiteConnectionSingleton.getConnection();
            stmt = c.createStatement();
           try (ResultSet rs = stmt.executeQuery("SELECT * FROM Transactions WHERE fromUser='"+user+"';")) {
               while (rs.next()){
                   transaction=new Transaction(rs.getString("fromUser"),rs.getString("toUser"),rs.getDouble("amountDollars"),
                           rs.getDouble("amountEuros"),rs.getDouble("amountPounds"),rs.getInt("timestamp"));
                   
                   transactions.add(transaction);
               }
           }
             stmt.close();            
             } catch (SQLException ex) {
             Logger.getLogger(SQLiteTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
        return transactions;
    }

    
}
