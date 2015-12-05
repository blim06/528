package coe528.mdp;

//This interface holds all of the methods present in the daughter classes.
public interface Bank {
    public void action();
    public void selectAccount();
    public void menuAccount();
    public void ChequingMenu();
    public void SavingMenu();
    public void CreditMenu();
    public void deposit();
    public void withdraw();
    public void transferCheq2Sav();
    public void transferSav2Cheq();
    public void pay_balance();
    public void bill_payment();
}
