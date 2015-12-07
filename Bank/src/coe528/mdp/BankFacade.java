package coe528.mdp;

public class BankFacade {
   private ATM atm;
   private OnlineBanking ob;
   

     public BankFacade() {
        atm = new ATM();
        ob = new OnlineBanking();
    }
     
     public void selectAccountOB () {
        ob.selectAccount();
     }
     public void selectAccountATM() {
        atm.selectAccount();
     }
     public void menuAccountOB(){
        ob.menuAccount();
     }
     public void menuAccountATM(){
        atm.menuAccount();
     }
     public void ChequingMenuOB(){
        ob.ChequingMenu();
     }
     public void ChequingMenuATM(){
        atm.ChequingMenu();
     }
     public void SavingMenuOB(){
        ob.SavingMenu();
     }
     public void SavingMenuATM(){
        atm.SavingMenu();
     }
     public void CreditMenuOB(){
        ob.CreditMenu();
     }
     public void CreditMenuATM(){
        atm.CreditMenu();
     }
     public void MoneyXferOB(){
        ob.MoneyXfer();
     }
