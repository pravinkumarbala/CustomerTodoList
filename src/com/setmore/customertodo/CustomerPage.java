package com.setmore.customertodo;

import com.setmore.customertodo.CustomerContacts.UserCredential;
import com.setmore.customertodo.CustomerTodoList.TodoList;

import java.util.Scanner;

public class CustomerPage {
    static UserCredential uc;
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        System.out.println("#################################");
        System.out.println("# Welcome to Customer Todo List #");
        System.out.println("#################################");
        int choice = 0;
        do {
            uc = new UserCredential();
            System.out.println("=============================");
            System.out.println("||  1.Login  ||  2.SignUp  ||");
            System.out.println("=============================");
            System.out.print("Select the tab : ");
            choice = readInput.nextInt();
            switch (choice){
                case 1: System.out.println(",,,,,,,,,,,,,,");
                        System.out.println("| LOGIN PAGE |");
                        System.out.println("''''''''''''''");
                        String customerName = uc.userLogin();
                        TodoList todo = new TodoList();
                        if (customerName != null)
                            todo.listOperation(customerName);
                        else System.out.println("User Doesn't not exist");
                        break;
                case 2: System.out.println(",,,,,,,,,,,,,,,");
                        System.out.println("| SIGNUP PAGE |");
                        System.out.println("'''''''''''''''");
                        uc.userRegister();
                        break;
                case 3: System.out.println("User Details");
                        uc.displayUserDetails();
                        break;
                case 4: System.out.println("Exit from the Customer Todo List");
                        break;
                default: System.out.println("Sorry, Please enter the correct option");
                        break;
            }


        }while (choice != 4);
    }
}