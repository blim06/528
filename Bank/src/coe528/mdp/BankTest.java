import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author mpieprzy
 */
public class BankTest {
    
    private static Customer test ;
    
    public static void main(String[] args){
 
        String id;
        String pw;
      
        try{
            test = new Customer();
        }catch(Exception e){
            
        }
        
        System.out.println("Enter your idNum");
        Scanner in1 = new Scanner(System.in);
        id = in1.nextLine();
            
        System.out.println("Enter your pw");
        Scanner in2 = new Scanner(System.in);
        pw = in2.nextLine();

        try{
        if (test.login(id, pw)==false )
        System.out.println("Error");
        else {
          GoodStanding one = new GoodStanding();
          test = new Customer("name","password","100", one);
          test.login(test.idNum, test.password);
          test.createChequeing(50);
          test.createSaving(50);
          test.updateProperties(test.idNum);
          BankFacade bankFacade = new BankFacade();
          }
        }catch (Exception e){
            
        }
        
 
    }
}
    
