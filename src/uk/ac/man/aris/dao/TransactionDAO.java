/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.util.ArrayList;

/**
 *Interface for Transaction DAO. Every database specific implementation must implement this interface
 * @author aris
 */
public interface TransactionDAO {
    
   public int createTransaction();
   public Transaction getTransaction();
   public ArrayList<Transaction> getTransactions(String user);
    
}
