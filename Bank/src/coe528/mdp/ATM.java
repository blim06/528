package coe528.mdp;

import java.util.Scanner;
import java.io.IOException;
/*
 *
 * @author Gelareh
 */
public class ATM  {

    //private User test;
    public static User current_user;
    
    
    public ATM(User u) throws IOException{
        current_user=u;
        
        
        
        
    }
    public static void selectAccount(){
        
        System.out.println("Which account would you like to access?");
        System.out.println();
        System.out.println("1 = Chequing Account ");
        System.out.println("2 = Savings Account");
        System.out.println("3 = Credit Account");
        
        menuAccount();
    }
  
    public static void menuAccount(){

        Scanner account = new Scanner(System.in);
        while (!account.hasNextInt()) {
            System.out.println("Invalid choice.");
            selectAccount();
        }
        
        int actNum = account.nextInt();

        if (actNum == 1){
            ChequingMenu();
            
        }

        else if (actNum == 2){
            SavingMenu();
        }

        else if (actNum == 3){
            CreditMenu();
        }
    }
    
    public static void ChequingMenu()
     {
            Chequeing c = new Chequeing();
            int selection;
            int amount;
            System.out.println("\nChequing menu:");
            System.out.println("1 - View account balance:");
            System.out.println("2 - Withdraw funds:");
            System.out.println("3 - Deposit funds:");
            System.out.println("4 - Transfer to Saving:");            
            System.out.println("5 - Back to Account Menu:");
            System.out.println("6 - Terminate transaction:");
            System.out.print("Choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch(selection)
            {
            case 1:
                c.getCheqBal();
                System.out.println("Your balance is: "+current_user.balance);
                break;
            case 2:
                System.out.println("\nEnter amount:");
                Scanner input2 = new Scanner(System.in);  
                amount = input2.nextInt();   
                c.withdraw(amount);
                break;
            case 3:
                System.out.println("\nEnter amount:");
                Scanner input3 = new Scanner(System.in); 
                amount = input3.nextInt();   
                c.deposit(amount);
                break;
            case 4:
                System.out.println("\nEnter amount to be transferred:");
                Scanner input4 = new Scanner(System.in); 
                amount = input4.nextInt();   
                c.transferCheq2Sav(amount);
                break;   
            case 5:
                selectAccount();
                break;
            case 6:
                System.out.println("\nThank you for using this ATM!!! goodbye");
            }
        }     
    public static void SavingMenu()
     {
            Saving s = new Saving();
            int selection;
            int amount;
            System.out.println("\nSaving menu");
            System.out.println("1 - View account balance:");
            System.out.println("2 - Withdraw funds:");
            System.out.println("3 - Deposit funds:");
            System.out.println("4 - Transfer to Chequing:");            
            System.out.println("5 - Back to Account Menu:");
            System.out.println("6 - Terminate transaction:");
            System.out.print("Choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch(selection)
            {
            case 1:
                s.getSavBal();
                System.out.println("Your balance is: "+current_user.balance);
                break;
            case 2:
                System.out.println("\nEnter amount:");
                Scanner input2 = new Scanner(System.in);  
                amount = input2.nextInt();   
                s.withdraw(amount);
                break;
            case 3:
                System.out.println("\nEnter amount:");
                Scanner input3 = new Scanner(System.in); 
                amount = input3.nextInt();   
                s.deposit(amount);
                break;
            case 4:
                System.out.println("\nEnter amount to be transferred:");
                Scanner input4 = new Scanner(System.in); 
                amount = input4.nextInt();   
                s.transferSav2Cheq(amount);
                break;   
            case 5:
                selectAccount();
                break;
            case 6:
                System.out.println("\nThank you for using this ATM!!! goodbye");
            }
        } 
    
    public static void CreditMenu()
     {
            Credit cr = new Credit();
            int selection;
            int amount;
            System.out.println("\nCredit menu");
            System.out.println("1 - View account balance:");
            System.out.println("2 - Pay Up Balance:");
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
                System.out.println("Your balance is: "+current_user.balance);
                break;
            case 2:
                System.out.println("\nEnter amount:");
                Scanner input2 = new Scanner(System.in);  
                amount = input2.nextInt();   
                cr.pay_balance(amount);
                break;
            case 3:
                System.out.println("\nEnter amount:");
                Scanner input3 = new Scanner(System.in); 
                amount = input3.nextInt();   
                cr.bill_payment(amount);
                break;
            case 4:
                selectAccount();
                break;
            case 5:
                System.out.println("\nThank you for using this ATM!!! goodbye");
            }
        } 
    public static void main(String[] args)throws IOException{
    User test = new User("Brian", "12345", "100");
    ATM testing = new ATM(test);
    //User.loadProperties(test);
    CreditMenu();
}
    
}
