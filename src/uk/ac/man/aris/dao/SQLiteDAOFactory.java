/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *Factory implementation for SQLite
 * Calls DAOs to get the Account and Transaction DAOs
 * TODO: would be nice to implement a singleton db connection
 * @author aris
 */
public class SQLiteDAOFactory extends DAOFactory {

    public static Connection createConnection(){
        Connection c=null;
        try {
             Class.forName("org.sqlite.JDBC");
             c = DriverManager.getConnection("jdbc:sqlite:db/Patterns.db");
             c.setAutoCommit(false);
             System.out.println("Opened database successfully");
               }
        catch( Exception e ) {
               System.err.println( e.getClass().getName() + ": " + e.getMessage() );
               System.exit(0);
                }       
          return c;}
        
        
    @Override
    public AccountDAO getAccountDAO(String username) {
        return new SQLiteAccountDAO(username);
    }

    @Override
    public TransactionDAO getTranscactionDAO() {
       return new SQLiteTransactionDAO();
    }
    
}
