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
    
//    private static Manager instance;           
//    public Manager(String name, String password, String balance) throws IOException {
//        super(name, password, balance);
//    }                        
//    public static Manager getInstance() throws IOException{        
//       if (instance == null)                   
//           instance = new Manager("admin", "admin", "10000");            
//       return instance;                           
//    }

    /**
     *
     * @param name
     * @param password
     * @param balance
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    
    public Manager(String name, String password, String balance) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        super(name, password, balance);        
    }
    
    /**
     *
     * @param name
     * @param password
     * @param balance
     * @throws IOException
     */
    public void createCustomer(String name, String password, String balance) throws IOException {
        loadProperties(users);
        Customer created = new Customer(name, password, balance);   
        users.setProperty(created.idNum, created.password+","+created.name+","+created.balance+","+created.cheqBal+","+created.savBal);
        saveProperties(users);
    }
    
    /**
     *
     * @param idNum
     * @throws IOException
     */
    public void deleteCustomer(String idNum) throws IOException {
        loadProperties(users);
        users.remove(idNum);
        saveProperties(users);        
    }
//public static void main(String[] args)throws IOException{
//        Manager test = new Manager("Manager", "admin", "100");
//
//        
//
//    }
}
