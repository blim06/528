package coe528.mdp;

/**
 *
 * @author mpieprzy
 */
public class Frozen implements State {
    
    /**
     *Sets the state of an object to Frozen.
     * @param cxt context in which the state is being used for
     */
    public void checkif(Context cxt) {
      System.out.println("Account is frozen");
      cxt.setState(this);	
   }
    
   public String toString(){
      return "Frozen";
   } 
}
