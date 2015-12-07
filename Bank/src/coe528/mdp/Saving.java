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
public class Saving extends Account {
    
    /**
     *savings account balance
     */
    public static int savBal;

    /**Creates a savings account with the following
     * <code>amount</code>.
     *
     * @param amount balance that account is created with
     */
    public Saving(int amount) {
        this.savBal=amount;
    }    

    /**Deposits <code>amount</code> into savings account.
     * Error is produced if amount is less than 0.
     *
     * @param amount balance to be deposited into account
     */
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
        Saving.savBal += amount;
        System.out.println("Your current balance is: " + savBal);
        } else {
            System.err.println("You must deposit funds greater than 0$.");
        }
    }
    
    /**Checks if there is a sufficient balance to be withdrew from the
     * savings account. Error is produced when amount withdrew exceeds
     * the balance.
     *
     * @param amount balance to be withdrew
     */
    @Override
    public void withdraw(int amount) {
        if (Saving.savBal >= amount) {
        Saving.savBal -= amount;
        System.out.println("Your current balance is: " + savBal);
        } else {
            System.err.println("Insufficient funds.");
        }    
    }
    
    /**Transfers <code>amount</code> to the chequeing account from savings.
     * If there are insufficient funds, transfer fails and an error is produced.
     *
     * @param amount amount to be transfered from savings to chequeing
     */
    public void transferSav2Cheq(int amount) {        
        if (Saving.savBal >= amount) {
        Chequeing.cheqBal+=amount;
        System.out.println("Your savings balance is: " + savBal);
        } else {
            System.err.println("Insufficient funds.");
        }
    }

    /**return savings account balance
     *
     * @return savings account balance
     */
    public static int getSavBal() {
        return savBal;
    }

    /**Sets savings account to <code>amount</code>
     *
     * @param amount new balance account is set to
     */
    public static void setSavBal(int amount) {
        Saving.savBal = amount;
    }    
    
}
