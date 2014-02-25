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
public interface AccountDAO {
    public Account getAccount(String username);
    public void upedateAccount();
    
}
