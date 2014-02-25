/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.aris.model;

import uk.ac.man.aris.dao.Account;

/**
 *
 * @author mbaxkak4
 */
public class SingletonAccountFactory {
    
    private static SingletonAccountFactory factoryInstance;
    
    public synchronized   SingletonAccountFactory getFactoryInstance(){
        if (factoryInstance==null){
        factoryInstance=new SingletonAccountFactory();}
        
    return factoryInstance;}
    


public Account getAccount(String ID,String pass){
 //check account
    //if cred ok
    //get the rest


return null;
}



}
