/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
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
       try {  
          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Accounts WHERE username="+username);
      while ( rs.next() ) {
         
         String  name = rs.getString("username");
         String pass=rs.getString("password");
         double pounds=rs.getDouble("pounds");
         double euros=rs.getDouble("euros");
         double dollars=rs.getDouble("dolalrs");
         
       
         
        
         rs.close();
         stmt.close();
         c.close();
      }}
       
       
       catch (Exception e){
       }
        return null;
    }

    @Override
    public void upedateAccount() {
       
    }
    
}
