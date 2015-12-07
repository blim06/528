package coe528.mdp;

public class BankFacade {
   private ATM atm;
   private OnlineBanking om;
   

     public BankFacade() {
        atm = new ATM();
        om = new OnlineBanking();
    }
     
     public void selectAccountOM () {
        om.selectAccount();
     }
     public void selectAccountATM() {
        atm.selectAccount();
     }
     public void menuAccountOM(){
        om.menuAccount();
     }
     public void menuAccountATM(){
        atm.menuAccount();
     }
     public void ChequingMenuOM(){
        om.ChequingMenu();
     }
     public void ChequingMenuATM(){
        atm.ChequingMenu();
     }
     public void SavingMenuOM(){
        om.SavingMenu();
     }
     public void SavingMenuATM(){
        atm.SavingMenu();
     }
     public void CreditMenuOM(){
        om.CreditMenu();
     }
     public void CreditMenuATM(){
        atm.CreditMenu();
     }
     public void MoneyXferOM(){
        om.MoneyXfer();
     }
