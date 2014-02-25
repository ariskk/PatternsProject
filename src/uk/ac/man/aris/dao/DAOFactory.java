/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

/**
 *
 * @author aris
 */
public abstract class DAOFactory {
    /*List of database types supportted by the factory
      Let's assume we might want to add a MySQL database in the future*/
    public static final int SQLite=1;
    public static final int MySQL=2;
    
    public abstract AccountDAO getAccountDAO();
    public abstract TranscationDAO getTranscactionDAO();
    
    public static DAOFactory getDAOFactory(int type){
    switch (type){
        case SQLite :
        return new SQLiteDAOFactory();
       /*A case can be added here for each supported type of database*/
        default :
        return null;
    }
    }
    
}
