/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aris
 */
public class SQLiteConnectionSingleton {
    
          private static Connection c;
             
    public static synchronized Connection getConnection(){
        if(c==null){
        try {
             Class.forName("org.sqlite.JDBC");
             c = DriverManager.getConnection("jdbc:sqlite:db/Patterns.db");
             c.setAutoCommit(false);
             System.out.println("Opened database successfully");
               }
        catch( Exception e ) {
               System.err.println( e.getClass().getName() + ": " + e.getMessage() );
               
                } }      
          return c;}
}
