package coe528.mdp;

public class GoodStanding implements State {
     public void checkif(Context cxt) {
      System.out.println("Account is in good standing");
      cxt.setState(this);	
   }

   public String toString(){
      return "Good Standing";
   } 
}
