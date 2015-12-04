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
    
    public static int savBal;
    
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
        Saving.savBal += amount;
        System.out.println("Your current balance is: " + savBal);
        } else {
            System.err.println("You must deposit funds greater than 0$.");
        }
    }
    
    @Override
    public void withdraw(int amount) {
        if (Saving.savBal >= amount) {
        Saving.savBal -= amount;
        System.out.println("Your current balance is: " + savBal);
        } else {
            System.err.println("Insufficient funds.");
        }    
    }
    
    public void transferSav2Cheq(int amount) {        
        if (Saving.savBal >= amount) {
        Chequeing.cheqBal+=amount;
        System.out.println("Your savings balance is: " + savBal);
        } else {
            System.err.println("Insufficient funds.");
        }
    }

    public static int getSavBal() {
        return savBal;
    }

    public static void setSavBal(int savBal) {
        Saving.savBal = savBal;
    }    
    
}
