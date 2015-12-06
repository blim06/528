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
    
    public static int cheqBal;

    public Chequeing(int amount) {
        this.cheqBal = amount;
    }    
    
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
        Chequeing.cheqBal += amount;
        System.out.println("Your current balance is: " + cheqBal);
        } else {
            System.err.println("You must deposit funds greater than 0$.");
        }
    }
    
    @Override
    public void withdraw(int amount) {
        if (Chequeing.cheqBal >= amount) {
        Chequeing.cheqBal -= amount;
        System.out.println("Your current balance is: " + cheqBal);
        } else {
            System.err.println("Insufficient funds.");
        }
    }

    public int getCheqBal() {
        return cheqBal;
    }

    public void setCheqBal(int cheqBal) {
        Chequeing.cheqBal = cheqBal;
    }  
    
    public void transferCheq2Sav(int amount) {        
        if (Chequeing.cheqBal >= amount) {
        Saving.savBal+=amount;
        System.out.println("Your chequeing balance is: " + cheqBal);
        } else {
            System.err.println("Insufficient funds.");
        }
    }
    
}
