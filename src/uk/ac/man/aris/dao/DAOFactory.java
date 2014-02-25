/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

/**
 * An abstract DAO factory
 * @author aris
 */
public abstract class DAOFactory {
    /*List of database types supportted by the factory
      Let's assume we might want to add a MySQL database in the future*/
    public static final int SQLite=1;
    public static final int MySQL=2;
    
    public abstract AccountDAO getAccountDAO(String username);
    public abstract TransactionDAO getTranscactionDAO();
    
    public static DAOFactory getDAOFactory(int type){
    switch (type){
        case SQLite :
        return new SQLiteDAOFactory();
        case MySQL :
        return null;
       /*A case can be added here for each supported type of database*/
        default :
        return null;
    }
    }
    
}
