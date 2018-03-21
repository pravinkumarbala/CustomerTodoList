package com.setmore.customertodo.CustomerContacts;

import java.util.*;

public class UserCredentailsTemplate {

    // Varaibles
    String firstName;
    String lastName;
    long mobileNumber;
    String emailAddress;
    String password;

    //Collections
    static Map<String, UserCredentailsTemplate> customerContacts = new Hashtable<String, UserCredentailsTemplate>();

    //Default Constructor
    public UserCredentailsTemplate(){}

    //Constructor
    public UserCredentailsTemplate(String firstName, String lastName, long mobileNumber, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCredentailsTemplate)) return false;
        UserCredentailsTemplate that = (UserCredentailsTemplate) o;
        return mobileNumber == that.mobileNumber &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mobileNumber, emailAddress, password);
    }
}