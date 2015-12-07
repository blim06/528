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

    public Manager(String name, String password, String balance) throws IOException {
        super(name, password, balance);
    }
    
    public void createCustomer(String name, String password, String balance) throws IOException {
        Customer created = new Customer(name, password, balance);        
    }
    
    public void deleteCustomer(String idNum) throws IOException {
        loadProperties(users);
        users.remove(idNum);
        saveProperties(users);        
    }
    
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

}
