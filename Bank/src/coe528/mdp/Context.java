ackage coe528.mdp;

/**
 *
 * @author mpieprzy
 */
public class Context {
    private State state;

    /**
     *Constructor (no state).
     */
    public Context(){
      state = null;
   }

    /**
     *Sets object state.
     * @param state of the object
     */
    public void setState(State state){
      this.state = state;		
   }

    /**
     *Gets object state.
     * @return
     */
    public State getState(){
      return state;
   }  
}
