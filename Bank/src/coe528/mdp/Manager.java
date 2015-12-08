/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.mdp;

import java.io.IOException;

/**
 *
 * @author Brian
 */
public class Manager extends User{   
    
    public static Customer target;

    /**A Manager is created with the following parameters:<code>name</code>,
     * <code>password</code>, and <code>balance</code>.
     *
     * @param name name of manager created
     * @param password password of manager created
     * @param balance balance of manager created
     * @throws IOException when file to read and write to doesn't exist
     */
    
    public Manager(String name, String password, String balance) throws IOException {
        super(name, password, balance);        
    }
    
    /**Loads the database with customers and creates a new customer
     * based on the specified <code>name</code>, <code>password</code>, and
     * <code>balance</code>. Saves all changes to the database.
     *
     * @param name name of new customer
     * @param password password of new customer
     * @param balance balance of new customer
     * @throws IOException when file to read and write to doesn't exist
     */
    public void createCustomer(String name, String password, String balance, State state) throws IOException {
        loadProperties(users);
        Customer created = new Customer(name, password, balance,state);   
        users.setProperty(created.idNum, created.password+","+created.name+","+created.balance+","+created.cheqBal+","+created.savBal);
        saveProperties(users);
    }
    
    /**Loads the database with customers. If a customer with the
     * <code>idNum</code> exists, the manager delete the customer
     * and saves the changes.
     *
     * @param idNum ID of customer to be deleted
     * @throws IOException when file to read and write to doesn't exist
     */
    public void deleteCustomer(String idNum) throws IOException {
        loadProperties(users);
        users.remove(idNum);
        saveProperties(users);        
    }

    public void freezeCustomer() throws IOException {
        target.state = new Frozen();
    }
    public void unfreezeCustomer() throws IOException {
        target.state = new GoodStanding();
    }


//public static void main(String[] args)throws IOException{
//        Manager test = new Manager("Manager", "admin", "100");
//
//        
//
//    }
}
