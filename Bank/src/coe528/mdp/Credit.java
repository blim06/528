/**
 *
 * @author Gelareh
 */
public class Credit {

    public static int crLimit = 2500;  
    private final long thirtyDayTime=currentTime-2592000000L;
    private long baseTime=currentTime-518400000;                //1448748000000;  //current time @dec,1,2015
    private static long currentTime=System.currentTimeMillis();
    //This section is about paying up your credit card balance
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
     
    //This section is about purchasing with your credit card
    public void bill_payment(double amount) {
        if (Credit.this.crLimit >= amount) {
        Credit.this.crLimit -= amount;
        System.out.println("Your current balance is: " + crLimit);
        } else if (amount > crLimit) {
            System.err.println("Over credit card limit.");
        }    
    }

    public static int getCrBal() {
        return crLimit;
    }

    public static void setCrBal(int crLimit) {
        Credit.crLimit = crLimit;
    }      
        
}

  
    
    
    
