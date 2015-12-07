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
    public void createCustomer(String name, String password, String balance) throws IOException {
        loadProperties(users);
        Customer created = new Customer(name, password, balance);   
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
<<<<<<< HEAD
    
    public void freezeCustomer(State state) throws IOException {
        Context cxt = new Context();
        State frozen = new Frozen();
        cxt.setState(frozen);
    }
    public void unfreezeCustomer(State state) throws IOException {
        Context cxt = new Context();
        State goodstanding = new GoodStanding();
        cxt.setState(goodstanding);
    }

=======
//public static void main(String[] args)throws IOException{
//        Manager test = new Manager("Manager", "admin", "100");
//
//        
//
//    }
>>>>>>> origin/master
}
