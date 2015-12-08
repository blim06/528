
package coe528.mdp;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin
 */
public class OnlineBanking implements Bank {

    /**
     *Customer object used for all methods
     */
    public static Customer current_user;

    /**
     *Customer object used for money transfer
     */
    public static Customer transfer_target;
    
    /**
     *Constructor
     */
    public OnlineBanking() {
        selectAccount();
    }

    /**
     *Method that writes the menu for menuAccount().
     */
    public void selectAccount(){
        
        System.out.println("Which operation would you like to access?");
        System.out.println();
        System.out.println("1 = Chequing Account ");
        System.out.println("2 = Savings Account");
        System.out.println("3 = Credit Account");
        System.out.println("4 = Money Transfer");
        
        menuAccount();
    }
  
    /**
     *Method that selects the desired user function.
     */
    public void menuAccount(){

        Scanner account = new Scanner(System.in);
        while (!account.hasNextInt()) {
            System.out.println("Invalid choice.");
            selectAccount();
        }
        
        int actNum = account.nextInt();

        if (actNum == 1){
            chequingMenu(); 
        }

        else if (actNum == 2){
            savingMenu();
        }

        else if (actNum == 3){
            creditMenu();
        }
        
        else if (actNum == 4){
            moneyXfer();
        }
    }
    
    /**
     *Method to access chequeing account.
     *Gets balance from users file and allows user to check balance.
     *Allows user to transfer money from chequeing to other accounts.
     */
    public void chequingMenu()
     {      
            
        try {
            int selection;
            int amount;
            System.out.println("\nChequing menu:");
            System.out.println("1 - View account balance:");
            System.out.println("2 - Transfer to Saving:");            
            System.out.println("3 - Back to Account Menu:");
            System.out.println("4 - Exit online banking service:");
            System.out.print("Choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch(selection)
            {
                case 1:
                    //System.out.println("Your balance is:");
                    //current_user.chequeing.getCheqBal();
                    System.out.println("Your balance is:"+current_user.chequeing.cheqBal);
                    break;
                case 2:
                    System.out.println("\nEnter amount to be transferred:");
                    Scanner input2 = new Scanner(System.in);
                    amount = input2.nextInt();
                    current_user.chequeing.transferCheq2Sav(amount);
                    current_user.updateProperties(current_user.idNum);
                    break;
                case 3:
                    selectAccount();
                    break;
                case 4:
                    System.out.println("\nThank you for using our online banking service");
                    System.exit(0);
            }
        } catch (IOException ex) {
            
        }
        }     

    /**
     *Method used to access saving account.
     * Gets balance from users file and allows user to check balance.
     * Allows user to transfer money from saving to other accounts.
     */
    public void savingMenu()
     {
        try {
            int selection;
            int amount;
            System.out.println("\nSaving menu");
            System.out.println("1 - View account balance:");
            System.out.println("2 - Transfer to Chequing:");            
            System.out.println("3 - Back to Account Menu:");
            System.out.println("4 - Terminate transaction:");
            System.out.print("Choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch(selection)
            {
                case 1:
                    current_user.saving.getSavBal();
                    System.out.println("Your balance is:"+current_user.saving.savBal);
                    break;
                case 2:
                    System.out.println("\nEnter amount to be transferred:");
                    Scanner input2 = new Scanner(System.in);
                    amount = input2.nextInt();
                    current_user.saving.transferSav2Cheq(amount);
                    current_user.updateProperties(current_user.idNum);
                    break;
                case 3:
                    selectAccount();
                    break;
                case 4:
                    System.out.println("\nThank you for using our online banking service");
                    System.exit(0);
            }
        } catch (IOException ex) {
        }
        } 
    
    /**
     *Method used to access credit account.
     * Allows the ability to check account balance.
     * Allows the ability to pay bills and balance.
     */
    public void creditMenu()
     {
        try {
            Credit cr = new Credit();
            int selection;
            int amount;
            System.out.println("\nCredit menu");
            System.out.println("1 - View account balance:");
            System.out.println("2 - Pay Balance:");
            System.out.println("3 - Pay Bills:");        
            System.out.println("4 - Back to Account Menu:");
            System.out.println("5 - Terminate transaction:");
            System.out.print("Choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch(selection)
            {
                case 1:
                    cr.getCrBal();
                    System.out.println("Your balance is:"+current_user.balance);
                    break;
                case 2:
                    System.out.println("\nEnter amount:");
                    Scanner input2 = new Scanner(System.in);
                    amount = input2.nextInt();
                    current_user.credit.pay_balance(amount);
                    current_user.updateProperties(current_user.idNum);
                    break;
                case 3:
                    System.out.println("\nEnter amount:");
                    Scanner input3 = new Scanner(System.in);
                    amount = input3.nextInt();
                    current_user.credit.bill_payment(amount);
                    current_user.updateProperties(current_user.idNum);
                    break;
                case 4:
                    selectAccount();
                    break;
                case 5:
                    System.out.println("\nThank you for using our online banking service");
                    System.exit(0);
            }
        } catch (IOException ex) {
        }
        } 
    
    /**
     *Method used to transfer money from one user to another.
     * Asks for ID number of target account and then allow user to transfer from
     * chequeing or from saving.
     */
    public void moneyXfer()
     {
        try {
            String id2;
            int selection;
            int amount;
            transfer_target = new Customer();
                    
            
            System.out.println("Enter idNum of Account you wish to transfer to:");
            Scanner in1 = new Scanner(System.in);
            id2 = in1.nextLine();
            if (transfer_target.searchUser(id2)==false) {
                selectAccount();
            }
            
            //current_user.updateProperties(current_user.users, id2);
            //transfer_target.access(id2);
            //transfer_target.access(id2)4
            
            
            System.out.println("\nMoney Transfer Menu");
            System.out.println("1 - Transfer from Chequing:");
            System.out.println("2 - Transfer from Saving:");      
            System.out.println("4 - Back to Account Menu:");
            System.out.println("5 - Terminate transaction:");
            System.out.print("Choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch(selection)
            {
                case 1:
                    System.out.println("\nEnter amount to be transferred:");
                    Scanner input1 = new Scanner(System.in);
                    amount = input1.nextInt();
                    current_user.access(id2);                    
                    current_user.chequeing.cheqAccTransfer(amount, current_user.target);         
                    current_user.updateProperties(current_user.idNum);
                    System.out.println(current_user.target.chequeing.cheqBal+"AA");
                    
                    break;
                case 2:
                    System.out.println("\nEnter amount to be transferred:");
                    Scanner input2 = new Scanner(System.in);
                    amount = input2.nextInt();
                    current_user.saving.savAccTransfer(amount,current_user.saving, transfer_target.saving);
                    current_user.updateProperties(current_user.idNum);
                    break;
                case 3:
                    selectAccount();
                    break;
                case 4:
                    System.out.println("\nThank you for using our online banking service");
                    System.exit(0);
            }
        } catch (IOException ex) {
        }
        } 
    
   public static void main(String[] args) throws IOException {
       GoodStanding one = new GoodStanding();
       current_user = new Customer("name","password","100", one);
       current_user.login(current_user.idNum, current_user.password);
       current_user.createChequeing(50);
       current_user.createSaving(50);
       current_user.updateProperties(current_user.idNum);
       OnlineBanking bank = new OnlineBanking();
       
    }
}

