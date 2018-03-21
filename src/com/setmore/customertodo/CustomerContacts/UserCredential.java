package com.setmore.customertodo.CustomerContacts;

import java.util.Map;
import java.util.Scanner;

public class UserCredential extends UserCredentailsTemplate {

    Scanner readInput = new Scanner(System.in);

    public void userRegister(){
        System.out.print("First Name : ");
        String firstName = readInput.next();
        System.out.print("Last Name: ");
        String lastName = readInput.next();
        System.out.print("Mobile Number : ");
        long mobileNumber = readInput.nextLong();
        System.out.print("Email address : ");
        String emailAddress = readInput.next();
        System.out.print("Password : ");
        String password = readInput.next();
        UserCredentailsTemplate userCredential = new UserCredentailsTemplate(firstName,lastName,mobileNumber,emailAddress,password);
        customerContacts.put(emailAddress, userCredential);
    }

    public String userLogin(){
        System.out.print("Email Address : ");
        String emailAddress = readInput.next();
        System.out.print("Password : ");
        String password = readInput.next();
        for (Map.Entry<String, UserCredentailsTemplate> loginCredential: customerContacts.entrySet()) {
            UserCredentailsTemplate uct = loginCredential.getValue();
            if (emailAddress.equals(loginCredential.getKey()) && password.equals(uct.password)) {
                String customerName = uct.firstName + " " + uct.lastName;
                return customerName;
            }
        }
        return null;
    }

    public void updateUserDetail(){
        System.out.print("Enter the user email address : ");
        String email = readInput.next();
        for (Map.Entry<String, UserCredentailsTemplate> login : customerContacts.entrySet()){
            UserCredentailsTemplate uct = login.getValue();
            if (email.equals(uct.emailAddress)){
                System.out.print("New Mobile Number : ");
                long mobileNumber = readInput.nextLong();
                uct.mobileNumber = mobileNumber;
            }
        }
    }

    public void displayUserDetails(){
        for (Map.Entry<String, UserCredentailsTemplate> loginCredential: customerContacts.entrySet()) {
            String email = loginCredential.getKey();
            UserCredentailsTemplate uct = loginCredential.getValue();
            System.out.println(email + " " + uct.firstName + " " + uct.lastName + " " + uct.mobileNumber);
        }
    }
}