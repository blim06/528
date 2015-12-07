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
    
    protected String name;
    protected String idNum;
    protected String password;
    protected String balance; 
    protected String cheqBal;
    protected String savBal;    
    private static final File file = new File("C:\\Users\\Brian\\Documents\\GitHub\\528\\Bank\\src\\coe528\\mdp\\users.properties");
    private User current;
    Random rand = new Random();
    Properties users = new Properties();
    FileOutputStream output;
           
    /**
     *Creates an instantance of User with inputs name,
     * 
     * @param name
     * @param password
     * @param balance
     * @throws IOException
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
     * @throws IOException 
     */
    
    public static void loadProperties(Properties p) throws IOException {
            FileInputStream input=new FileInputStream(file);
            p.load(input);
            input.close();
}
    
    public void updateProperties(Properties p, String idNum) throws IOException {
        loadProperties(users);
        users.setProperty(idNum, current.password+","+current.name+","+current.balance+","+current.cheqBal+","+current.savBal);        
        saveProperties(users);
    }
    
    /**Saves any changes done to the databases of users
     *
     * @param p properties file containing user information
     * @throws IOException
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
        if (users.getProperty(idNum)!=null)  {
            System.out.println("The account #: " + idNum + ", exists.");
            return true;                       
        }
        System.err.println("No accounts exist with the following id: " + idNum);
        return false;
    }
    
    /**
     *
     * @param idNum id number of the user trying to login
     * @param password password of the user 
     * @return true if login is successful and false if login failed
     * @throws IOException when file to read from doesn't exist
     */
    public boolean login(String idNum, String password) throws IOException {
        loadProperties(users);
        if (searchUser(idNum)==true) {
            String[] currentUser = users.getProperty(idNum).split(",");
            if (password.equals(currentUser[0])) {         
                current.idNum=idNum;
                current.password=currentUser[0];
                current.name=currentUser[1];
                current.balance=currentUser[2];
                current.cheqBal=currentUser[3];
                current.savBal=currentUser[4];
                System.out.println("Login successful.");
                return true;
            } else {
                System.err.println("Login failed.");
                return false;
            }
        } else {
            System.err.println("Login failed.");
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
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException{
        User test = new User("brian", "12345", "100");
        User test2 = new User("brian1", "123456", "100");
        

    }
    
 
}
