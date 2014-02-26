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
 * Authentication Class. final class only one static method
 * @author aris
 */
public final class Authentication {
    
     public static boolean authenticate( String username,String pass ){   
          boolean authenticate=false;
          Connection c=SQLiteConnectionSingleton.getConnection();  
          Statement stmt;
    try {

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT username,password FROM Accounts WHERE username='"+username+"';" );
         while ( rs.next() ) {
         
         String  name = rs.getString("username");
         String passw=rs.getString("password");
         if(username.equals(name)&pass.equals(passw)){authenticate=true;}
        
       
         System.out.println( name );
         System.out.println( pass );
         
        
         rs.close();
         stmt.close();
         //c.close();
         }
      
         }
    catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
                          }
    
      System.out.println("Operation done successfully");
      return authenticate;
  }

    
}
