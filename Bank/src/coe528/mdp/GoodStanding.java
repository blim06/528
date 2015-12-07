package coe528.mdp;

public class GoodStanding implements State {
     public void checkif(Context creditscore) {
      System.out.println("Account is in good standing");
      creditscore.setState(this);	
   }

   public String toString(){
      return "Good Standing";
   } 
}
