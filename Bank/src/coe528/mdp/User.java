/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.mdp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Properties;

/**
 *
 * @author Brian
 */
public class User{
   
    /**
     *name of the user
     */
    protected String name="";

    /**
     *unique ID number assigned to each customer
     */
    protected String idNum="";

    /**
     *password to their account
     */
    protected String password="";

    /**
     *balance of account
     */
    protected String balance="";

    /**
     *chequeing balance of account
     */
    protected String cheqBal="";

    /**
     *savings balance of account
     */
    protected String savBal="";  
    public Chequeing chequeing;
    public Saving saving;
    public Credit credit;
    public State state;
    private static final File file = new File("/home/student1/mpieprzy/coe528/528/Bank/src/coe528/mdp/users.properties");
    private User current;   
    private User target; 
    Random rand = new Random();
    Properties users = new Properties();
    FileOutputStream output;
          
    public User() {
       
    }
   
    /**
     *When a user is created, a random number is generated which will serve as their <code>idNum</code>.
     * That random number is check to make sure no other users have the same <code>idNum</code> and it
     * is finalized when the number is unique. We print out this number for the user to record down.
     * The parameters the user entered for the name, password and balance is added to the database and
     * then saved.    
     *
     * @param name name of user created
     * @param password password of user created
     * @param balance balance of user created
     * @throws IOException when file to read and write to doesn't exist
     */
    public User(String name, String password, String balance) throws IOException {
        loadProperties(users);
        String num;
        this.name=name;
        num=412 + Integer.toString(rand.nextInt(999999999)+ 100000000);
        while (searchUser(num)==true) {
            num=412 + Integer.toString(rand.nextInt(999999999)+ 100000000);
        }       
        idNum=num;
        System.out.println("Your ID number is: " + this.idNum);
        System.out.println("Please keep your ID and password safe as they're your login information!");
        this.password=password;
        this.balance=balance;
        cheqBal="0";
        savBal="0";       
        users.setProperty(idNum, password+","+name+","+balance+","+cheqBal+","+savBal);
        saveProperties(users);       
    }
   
    /**Loads the database of registered users
     *
     * @param p properties file containing user information
     * @throws IOException when file to read from doesn't exist
     */
   
    public static void loadProperties(Properties p) throws IOException {
            FileInputStream input=new FileInputStream(file);
            p.load(input);
            input.close();
}
   
    /**When there are any changes to the current user's information,
     * this method will save the change to the database
     *
     * @param p properties file containing user information
     * @param idNum user ID whose information is to be updated
     * @throws IOException when file to read and write to doesn't exist
     */
    public void updateProperties(String idNum) throws IOException {
        loadProperties(users);
        users.setProperty(idNum, current.password+","+current.name+","+current.balance+","+current.chequeing.cheqBal+","+current.saving.savBal);       
        saveProperties(users);
    }
   
    /**Saves any changes done to the databases of users
     *
     * @param p properties file containing user information
     * @throws IOException when file to write to doesn't exist
     */
    public static void saveProperties(Properties p) throws IOException {
            FileOutputStream output = new FileOutputStream(file);
            p.store(output,"User data- Format(idNum=password,name,balance,cheqBal,savBal)");
            output.close();
    }
   
    /**Lets the current user change their password
     *
     * @param password new password to be changed
     */
    public void changePassword(String password) {
        current.password = password;
    }   
   
    /**Searches the database for the user with the following <code>idNum</code>
     * and returns true if the user exists or false if the user
     * doesn't exist
     *
     * @param idNum
     * @return true if user exists, false if user doesn't exist
     * @throws IOException when file to read from doesn't exist
     */
    public boolean searchUser(String idNum) throws IOException {
        loadProperties(users);
        if (this.users.containsKey(idNum)==true)  {           
            System.out.println("The account #: " + idNum + ", exists.");
            return true;                      
        }
        System.err.println("No accounts exist with the following id: " + idNum);
        return false;
    }
    
    public boolean access(String idNum) throws IOException {
        loadProperties(users); 
        System.out.println("***");
        target = new User();
        if (searchUser(idNum)==true) {
            System.out.println("***");
            String[] currentUser = users.getProperty(idNum).split(",");
                System.out.println(idNum);                
                target.chequeing.cheqBal=Integer.parseInt(currentUser[3]);
                target.saving.savBal=Integer.parseInt(currentUser[4]);
                System.out.println(target.chequeing.cheqBal);
                System.out.println(target.saving.savBal);
                System.out.println("Access successful.");
                return true;
            } else {
                System.err.println("Account does not exist.");
                return false;
            }
        }



   
    /**If the <code>idNum</code> inputted exists, it checks if the password
     * matches. When the user is successfully logged in, it stores the information
     * into an array.  
     *
     * @param idNum id number of the user trying to login
     * @param password password of the user
     * @return true if login is successful and false if login failed
     * @throws IOException when file to read from doesn't exist
     */
    public boolean login(String idNum, String password) throws IOException {
        loadProperties(users);       
        current = new User();
        if (searchUser(idNum)==true) {
            String[] currentUser = users.getProperty(idNum).split(",");
                String pass = currentUser[0];
            if (password.equals(pass)) {
                current.idNum=idNum;
                current.password=currentUser[0];
                current.name=currentUser[1];
                current.balance=currentUser[2];
                current.chequeing.cheqBal=Integer.parseInt(currentUser[3]);
                current.saving.savBal=Integer.parseInt(currentUser[4]);
                System.out.println("Login successful.");
                return true;
            } else {
                System.err.println("Login failed1.");
                return false;
            }
        } else {
            System.err.println("Login failed2.");
            return false;
        }      
    }
   
    /**
     *lets the current user log out
     */
    public void logout() {
        current = null;
        System.out.println("Logout succesful.");
    }  
   
   
    public static void main(String[] args)throws IOException{
        System.out.println("234234");
        User test = new User("brian", "12345", "100");
        System.out.println(test.users.containsKey(test.idNum)+"***");
        System.out.println(test.searchUser(test.idNum)+"**");
        if (test.login(test.idNum, test.password)==false )
        System.out.println("asd");       
    }
   
 
}
