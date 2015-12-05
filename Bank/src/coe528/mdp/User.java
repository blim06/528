/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.mdp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class User{
    
    private String name;
    private String idNum;
    private String password;
    private String balance;    
    String file = "users.txt";
    private ArrayList<User> database = new ArrayList<User>();
    private User current;
    Random rand = new Random();
    
    public User(String name, String password, String balance) {
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
        database.add(this);
    }
    
    public void changePassword(String password) {
        current.password = password;
    }
    
    public boolean loadFile() {
        try {
            File F = new File(file);
            Scanner scanner = new Scanner(F);
            String user;

            while (scanner.hasNext()) {
                user = scanner.next();
                if (user != "\n") {
                    idNum.add(user);
                    password.add(scanner.next());
                    name.add(scanner.next());
                    balance.add(scanner.next());
                }
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

        return false;
    }
    
    public int searchUser(String name) {
        String temp = "";
        for (int i = 0; i<database.size(); i++) {
            temp = database.get(i).name;
            if (name.equalsIgnoreCase(temp)) {
                return i;
            }
        }
        System.err.println("No accounts exist with the following name: " + name);
        return 0;
    }
    
        
    public boolean login(String name, String password) {
        int i = searchUser(name);
        String temp = database.get(i).password;
        if (temp == password) {
            current = database.get(i);
            System.out.println("Login successful.");
            return true;
        } else {
            System.err.println("Login failed.");
            return false;
        }
    }
    
    public void logout() {
        current = null;
        System.out.println("Logout succesful.");
    }   
    
 
}
