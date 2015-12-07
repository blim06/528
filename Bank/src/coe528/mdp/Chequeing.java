/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.mdp;

/**
 *
 * @author Brian
 */
public class Chequeing extends Account {
    
    /**
     *chequeing account balance
     */
    public static int cheqBal;

    /**Creates a chequeing account with the following
     * <code>amount</code>.
     *
     * @param amount balance that account is created with
     */
    public Chequeing(int amount) {
        this.cheqBal = amount;
    }    
    
    /**Deposits <code>amount</code> into chequeing account.
     * Error is produced if amount is less than 0.
     *
     * @param amount balance to be deposited into account
     */
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
        Chequeing.cheqBal += amount;
        System.out.println("Your current balance is: " + cheqBal);
        } else {
            System.err.println("You must deposit funds greater than 0$.");
        }
    }
    
    /**Checks if there is a sufficient balance to be withdrew from the
     * chequeing account. Error is produced when amount withdrew exceeds
     * the balance.
     *
     * @param amount balance to be withdrew
     */
    @Override
    public void withdraw(int amount) {
        if (Chequeing.cheqBal >= amount) {
        Chequeing.cheqBal -= amount;
        System.out.println("Your current balance is: " + cheqBal);
        } else {
            System.err.println("Insufficient funds.");
        }
    }

    /**returns the balance of the chequeing account
     *
     * @return balance of chequeing account
     */
    public int getCheqBal() {
        return cheqBal;
    }

    /**Sets chequeing account to <code>amount</code>
     *
     * @param amount new balance account is set to
     */
    public void setCheqBal(int amount) {
        Chequeing.cheqBal = amount;
    }  
    
    /**Transfers <code>amount</code> to the savings account from chequeing.
     * If there are insufficient funds, transfer fails and an error is produced.
     *
     * @param amount amount to be transfered from chequeing to saving
     */
    public void transferCheq2Sav(int amount) {        
        if (Chequeing.cheqBal >= amount) {
        Saving.savBal+=amount;
        System.out.println("Your chequeing balance is: " + cheqBal);
        } else {
            System.err.println("Insufficient funds.");
        }
    }
    
}
