package coe528.mdp;

public class BankFacade {
   private ATM atm;
   private Account acc;
   private Chequeing cheq;
   private Saving sav;
   private Credit credit;
   private Mortgage mortgage;
   

     public BankFacade(ATM atm, Account acc, Chequeing cheq, Saving sav, Credit credit, Mortgage mortgage) {
        this.atm = atm;
        this.acc = acc;
        this.cheq = cheq;
        this.sav = sav;
        this.credit = credit;
        this.mortgage = mortgage;
    }
   
   

  
}
