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
    private static final File file = new File("C:\\Users\\bl\\Documents\\GitHub\\528\\Bank\\src\\coe528\\mdp\\users.properties");
    private ArrayList<User> database = new ArrayList<User>();
    private User current;
    Random rand = new Random();
    Properties users = new Properties();
    FileOutputStream output;
           
    
    public User(String name, String password, String balance) throws IOException {
        loadProperties(users);
        String num;
        this.name=name;
        num=412 + Integer.toString(rand.nextInt(999999999)+ 100000000);
        for (int i=0; i<database.size(); i++) {
            while (database.get(i).idNum.equals(num)) {
                num=412 + Integer.toString(rand.nextInt(999999999)+ 100000000);
            }            
        }
        idNum=num;
        this.password=password;
        this.balance=balance;
        users.setProperty(idNum, password+","+name+","+balance);
        saveProperties(users);
        database.add(this);
    }
    
    static void loadProperties(Properties p)throws IOException
    {
            FileInputStream input=new FileInputStream(file);
            p.load(input);
            input.close();
}
    
    public static void saveProperties(Properties p)throws IOException
    {
            FileOutputStream output = new FileOutputStream(file);
            p.store(output,"Properties");
            output.close();
    }
    
    public void changePassword(String password) {
        current.password = password;
    }    
    
    public boolean searchUser(String idNum) throws IOException {
        loadProperties(users);
        if (users.getProperty(idNum)!=null)  {
            System.out.println("The account #: " + idNum + ", exists.");
            return true;                       
        }
        System.err.println("No accounts exist with the following id: " + idNum);
        return false;
    }
    
        
    public boolean login(String idNum, String password) throws IOException {
        loadProperties(users);
        if (searchUser(idNum)==true) {
            String[] currentUser = users.getProperty(idNum).split(",");
            if (password.equals(currentUser[0])) {         
                current.idNum=idNum;
                current.password=currentUser[0];
                current.name=currentUser[1];
                current.balance=currentUser[2];
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
    
    public void logout() {
        current = null;
        System.out.println("Logout succesful.");
    }   
    
    public static void main(String[] args)throws IOException{
        User test = new User("brian", "12345", "100");
        User test2 = new User("brian1", "123456", "100");

    }
    
 
}
