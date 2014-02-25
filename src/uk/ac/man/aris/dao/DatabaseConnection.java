/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *
 * @author aris
 */
public class DatabaseConnection {
     public static void main( String args[] )
  {
       Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:db/Patterns.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Accounts;" );
      while ( rs.next() ) {
         
         String  name = rs.getString("username");
         String pass=rs.getString("password");
         double pounds=rs.getDouble("pounds");
        
       
         System.out.println( name );
         System.out.println( pass );
         System.out.println( pounds );
        
         rs.close();
         stmt.close();
         c.close();
      }
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    
    System.out.println("Operation done successfully");
  }

    
}
