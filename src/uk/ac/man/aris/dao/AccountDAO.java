/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.man.aris.dao;

/**
 * Interface of the Account DAO .Every Database specific DAO must implement that interface
 * @author aris
 */
public interface AccountDAO {
    public Account getAccount(String user);
    public void upedateAccount(Account acc);
    public void createAccount();
}
