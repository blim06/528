package coe528.mdp;

import java.util.Scanner;

/**
 *
 * @author mpieprzy
 */
public class BankFacade {
   private ATM atm;
   private OnlineBanking ob;
   
    /**
     *Constructor for the facade that is able to call the Online Banking and
     * ATM classes.
     * User chooses which class to call.
     */
    public BankFacade() {
        System.out.println("Which operation would you like to access?");
        System.out.println();
        System.out.println("1 = ATM ");
        System.out.println("2 = Online Banking");    
        Scanner in1 = new Scanner(System.in);
        String id = in1.nextLine();        
        if (id.equals("1")) {
            atm = new ATM();   
        } else if (id.equals("2")) {
            ob = new OnlineBanking();
        } else
            System.err.println("Option not available.");
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
     public void chequingMenuOB(){
        ob.chequingMenu();
     }
     public void chequingMenuATM(){
        atm.chequingMenu();
     }
     public void savingMenuOB(){
        ob.savingMenu();
     }
     public void savingMenuATM(){
        atm.savingMenu();
     }
     public void creditMenuOB(){
        ob.creditMenu();
     }
     public void creditMenuATM(){
        atm.creditMenu();
     }
     public void moneyXferOB(){
        ob.moneyXfer();
     }
     
   
   

  
}
