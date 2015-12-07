package coe528.mdp;

public class Frozen implements State {
    
    public void checkif(Context cxt) {
      System.out.println("Account is frozen");
      cxt.setState(this);	
   }
    
   public String toString(){
      return "Frozen";
   } 
}
