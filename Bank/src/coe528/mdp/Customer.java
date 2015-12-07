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
    
    /**A customer is created with the following parameters:<code>name</code>,
     * <code>password</code>, and <code>balance</code>.
     *
     * @param name name of customer created
     * @param password password of customer created
     * @param balance balance of customer created
     * @throws IOException when file to read and write to doesn't exist
     */
    public Customer(String name, String password, String balance) throws IOException {
        super(name, password, balance);
    }
    
    /**Creates a Chequeing account with the balance of <code>amount</code>.
     * If the amount is less than the balance of the user's account, 
     * an error is produced.
     *
     * @param amount balance of chequeing account created
     */
    public void createChequeing(int amount) {
        Chequeing created = new Chequeing(amount);
        if (amount<=Integer.parseInt(balance))            
            chequeing = created;            
        else 
            System.err.println("Insufficient funds.");
    }
        
    /**Creates a Savings account with the balance of <code>amount</code>.
     * If the amount is less than the balance of the user's account, 
     * an error is produced.
     *
     * @param amount balance of savings account created 
     */
    public void createSaving(int amount) {
        Saving created = new Saving(amount);
        if (amount<=Integer.parseInt(balance))            
            saving = created;            
        else 
            System.err.println("Insufficient funds.");        
    }  
    
    /**creates a credit account for the user
     *
     */
    public void createCredit() {
        Credit created = new Credit();
        credit = created;
    }
    
    
    public static void main(String[] args) throws IOException {
        Customer brian = new Customer("brian","12345","100");
        brian.createChequeing(50);
        brian.createSaving(50);
        System.out.println(brian.chequeing.getCheqBal());
        System.out.println(brian.saving.getSavBal());
    }
    
}
