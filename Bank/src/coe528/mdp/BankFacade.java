package coe528.mdp;

public class BankFacade {
   private ExampleAction example;
   private ATM atm;
   private Account acc;
   private Chequeing cheq;
   private Saving sav;
   private Credit credit;
   private Mortgage mortgage;
   

     public BankFacade(ExampleAction example, ATM atm, Account acc, Chequeing cheq, Saving sav, Credit credit, Mortgage mortgage) {
        this.example = example;
        this.atm = atm;
        this.acc = acc;
        this.cheq = cheq;
        this.sav = sav;
        this.credit = credit;
        this.mortgage = mortgage;
    }
   
   
   public void doAction1(){
      example.action();
   }

  
}
