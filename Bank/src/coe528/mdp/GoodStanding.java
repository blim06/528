package coe528.mdp;

/**
 *
 * @author mpieprzy
 */
public class GoodStanding implements State {

    /**
     *Sets the state of an object to GoodStanding.
     * @param cxt context in which the state is being used for
     */
    public void checkif(Context cxt) {
      System.out.println("Account is in good standing");
      cxt.setState(this);	
   }

   public String toString(){
      return "Good Standing";
   } 
}
