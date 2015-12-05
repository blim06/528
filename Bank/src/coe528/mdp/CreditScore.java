package coe528.mdp;

public class CreditScore {
    private State state;

   public CreditScore(){
      state = null;
   }

   public void setState(State state){
      this.state = state;		
   }

   public State getState(){
      return state;
   }  
}
