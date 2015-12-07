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
     *
     */
    public static int savBal;

    /**
     *
     * @param amount
     */
    public Saving(int amount) {
        this.savBal=amount;
    }    
    
    

    /**
     *
     * @param amount
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
    
    /**
     *
     * @param amount
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
    
    /**
     *
     * @param amount
     */
    public void transferSav2Cheq(int amount) {        
        if (Saving.savBal >= amount) {
        Chequeing.cheqBal+=amount;
        System.out.println("Your savings balance is: " + savBal);
        } else {
            System.err.println("Insufficient funds.");
        }
    }

    /**
     *
     * @return
     */
    public static int getSavBal() {
        return savBal;
    }

    /**
     *
     * @param savBal
     */
    public static void setSavBal(int savBal) {
        Saving.savBal = savBal;
    }    
    
}
