/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

import java.util.ArrayList;

/**
 *
 * @author aris
 */
public interface TranscationDAO {
    
   public int createTransaction();
   public Transaction getTransaction();
   public ArrayList<Transaction> getTransactions(String user);
    
}
