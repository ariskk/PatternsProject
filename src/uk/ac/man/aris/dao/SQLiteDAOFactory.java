/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

/**
 * Factory implementation for SQLite
 * Return Transaction and Account DAOs
 * @author aris
 */
public class SQLiteDAOFactory extends DAOFactory {
    
     
    @Override
    public AccountDAO getAccountDAO() {
        return new SQLiteAccountDAO();
    }

    @Override
    public TransactionDAO getTranscactionDAO() {
       return new SQLiteTransactionDAO();
    }
    
}
