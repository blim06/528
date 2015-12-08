package coe528.mdp;

/**
 *the credit class is one of the accounts that users can have access to it and
 * paying bills and their credit balance through executed methods
 * @author Gelareh
 */
public class Credit {

    /**
     *initializing the parameter that we have used in class.
     */
    public static int crLimit = 2500;  
    private final long thirtyDayTime=2592000000L;
    private long baseTime=1449446400000L;//1448748000000;  //current time @dec,1,2015
    private static long currentTime=System.currentTimeMillis();
    

    /**
     *this method basically is basically about paying off the credit balance by 
     * adding the amount to the credit limit which was initialized at the beginning of the class
     * @param amount which is the double value that we have to purchase
     */
        public void pay_balance(double amount) {
        if (amount > 0 && crLimit < 2500) {
        Credit.this.crLimit += amount;
        System.out.println("Your current balance is: " + crLimit);
        } else {
            System.err.println("You must deposit funds greater than 0$.");
            
        }
         if ((currentTime-baseTime)>=thirtyDayTime) { 
           amount=amount*1.20;
       }
       
    }
     
    

    /**
     *in this method users are able to pay their bill by subtracting the value of
     * which is the amount from the credit limit
     * @param amount is the value of bills 
     */
        public void bill_payment(double amount) {
        if (Credit.this.crLimit >= amount) {
        Credit.this.crLimit -= amount;
        System.out.println("Your current balance is: " + crLimit);
        } else if (amount > crLimit) {
            System.err.println("Over credit card limit.");
        }    
    }

    /**
     *it gives the current balance (credit limits)of credit
     * @return
     */
    public static int getCrBal() {
        return crLimit;
    }

    /**
     *it set the current balance of credit to credit limit
     * @param crLimit is the limit of the credit card
     */
    public static void setCrBal(int crLimit) {
        Credit.crLimit = crLimit;
    }      
        
}
