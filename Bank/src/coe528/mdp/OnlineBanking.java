package coe528.mdp;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Martin
 */
public class OnlineBanking implements Bank {
    public static User current_user;
    public static User transfer_target;

    public OnlineBanking(User u) {
        current_user = u;
    }

    
    

    public void selectAccount(){
        
        System.out.println("Which operation would you like to access?");
        System.out.println();
        System.out.println("1 = Chequing Account ");
        System.out.println("2 = Savings Account");
        System.out.println("3 = Credit Account");
        System.out.println("4 = Money Transfer");
        
        menuAccount();
    }
  

    public void menuAccount(){

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
        
        else if (actNum == 4){
            MoneyXfer();
        }
    }
    
    public void ChequingMenu()
     {      
            int cheq = Integer.parseInt(current_user.cheqBal);
            Chequeing c = new Chequeing(cheq);
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
                c.getCheqBal();
                System.out.println("Your balance is:"+current_user.balance);
                break;
            case 2:
                System.out.println("\nEnter amount to be transferred:");
                Scanner input2 = new Scanner(System.in); 
                amount = input2.nextInt();   
                c.transferCheq2Sav(amount);
                break;   
            case 3:
                selectAccount();
                break;
            case 4:
                System.out.println("\nThank you for using our online banking service");
                System.exit(0);
            }
        }     
    public void SavingMenu()
     {
            int sav = Integer.parseInt(current_user.savBal);
            Saving s = new Saving(sav);
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
                s.getSavBal();
                System.out.println("Your balance is:"+current_user.balance);
                break;
            case 2:
                System.out.println("\nEnter amount to be transferred:");
                Scanner input2 = new Scanner(System.in); 
                amount = input2.nextInt();   
                s.transferSav2Cheq(amount);
                break;   
            case 3:
                selectAccount();
                break;
            case 4:
                System.out.println("\nThank you for using our online banking service");
                System.exit(0);
            }
        } 
    
    public void CreditMenu()
     {
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
                System.out.println("\nThank you for using our online banking service");
                System.exit(0);
            }
        } 
    
    public void MoneyXfer()
     {
            int cheq = Integer.parseInt(current_user.cheqBal);
            Chequeing c = new Chequeing(cheq);
            int sav = Integer.parseInt(current_user.savBal);
            Saving s = new Saving(sav);
            
            String id2;
            int selection;
            int amount;
            
            System.out.println("Enter idNum of Account you wish to transfer to:");
            Scanner in1 = new Scanner(System.in);
            id2 = in1.nextLine();

            
            int cheq2 = Integer.parseInt(transfer_target.cheqBal);
            Chequeing r = new Chequeing(cheq2);
            int sav2 = Integer.parseInt(transfer_target.savBal);
            Saving q = new Saving(sav2);
            
            System.out.println("\nMoney Transfer Menu);");
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
                c.cheqAccTransfer(amount,c, r);
                break;
            case 2:
                System.out.println("\nEnter amount to be transferred:");
                Scanner input2 = new Scanner(System.in); 
                amount = input2.nextInt();
                s.savAccTransfer(amount,s, q);
                break;
            case 3:
                selectAccount();
                break;
            case 4:
                System.out.println("\nThank you for using our online banking service");
                System.exit(0);
            }
        } 
    
    
}

