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
public class Customer extends User{
    
    private Chequeing chequeing;
    private Saving saving;
    private Credit credit;
    
    public Customer(String name, String password, String balance) throws IOException {
        super(name, password, balance);
    }
    
    /**
     *
     * @param amount
     */
    public void createChequeing(int amount) {
        Chequeing created = new Chequeing(amount);
        if (amount<=Integer.parseInt(balance))            
            chequeing = created;            
        else 
            System.err.println("Insufficient funds.");
    }
        
    /**
     *
     * @param amount
     */
    public void createSaving(int amount) {
        Saving created = new Saving(amount);
        if (amount<=Integer.parseInt(balance))            
            saving = created;            
        else 
            System.err.println("Insufficient funds.");        
    }  
    
    /**
     *
     */
    public void createCredit() {
        Credit created = new Credit();
        credit = created;
    }
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Customer brian = new Customer("brian","12345","100");
        brian.createChequeing(50);
        brian.createSaving(50);
        System.out.println(brian.chequeing.getCheqBal());
        System.out.println(brian.saving.getSavBal());
    }
    
}
