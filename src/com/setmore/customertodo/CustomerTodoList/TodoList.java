package com.setmore.customertodo.CustomerTodoList;

import java.util.*;

public class TodoList extends TodoListTemplate{
    Scanner readInput = new Scanner(System.in);
//    Map<String, Map<Integer,TodoListTemplate>> customerTodo = new HashTable<>();
    Map<Integer,TodoListTemplate> todoList = new HashMap<Integer, TodoListTemplate>();
    Set<String> todoListComplete = new TreeSet<>();
    int count = 1;

    public void addTodoList(){
        System.out.print("Add list : ");
        String list = readInput.next();
        todoList.put(count, new TodoListTemplate(list, unCompleted));
        count++;
    }

    public void displayTodoList(){
        for (Map.Entry<Integer, TodoListTemplate> list : todoList.entrySet()){
            int listLineNumber = list.getKey();
            TodoListTemplate tlt = list.getValue();
            System.out.println(listLineNumber + " : " + tlt.status + " " + tlt.todoListName);
        }
    }

    public void deleteTodoList(){
        displayTodoList();
        System.out.print("Select the list number : ");
        int deleteLineNumber = readInput.nextInt();
        for (Map.Entry<Integer, TodoListTemplate> list : todoList.entrySet()){
            if (deleteLineNumber == list.getKey())
                todoList.remove(deleteLineNumber);
        }
    }

    public void completeTodoList(){
        int choiceStatus = 0;
        do {
            displayTodoList();
            System.out.println("1. Completed  2. Not Completed    3.Exit");
            System.out.print("Choose any one : ");
            choiceStatus = readInput.nextInt();
            int lineNumber = 0;
            switch (choiceStatus) {
                case 1: System.out.print("Line number : ");
                        lineNumber = readInput.nextInt();
                        for (Map.Entry<Integer, TodoListTemplate> list : todoList.entrySet()) {
                            TodoListTemplate todo = list.getValue();
                            if (todo.status.equals(unCompleted)){
                                if (lineNumber == list.getKey()) {
                                    todo.status = completed;
                                    todoListComplete.add(todo.todoListName);
                                }
                            }
                        }
                        break;
                case 2: System.out.print("Line Number : ");
                        lineNumber = readInput.nextInt();
                        for (Map.Entry<Integer, TodoListTemplate> list : todoList.entrySet()) {
                            int listLineNumber = list.getKey();
                            TodoListTemplate todo = list.getValue();
                            if (todo.status.equals(completed)) {
                                if (lineNumber == list.getKey()) {
                                    todo.status = unCompleted;
                                    todoListComplete.remove(todo.todoListName);
                                }
                            }
                        }
                        break;
                case 3: System.out.println("Exit from the List");
                        break;
                default: System.out.println("Sorry!!! Please select the correct option");
                        break;
            }
        }while (choiceStatus != 3);
    }

    public void listOperation(String name){
        System.out.println("Welcome " + name);
        int choice = 0;
        do{
            System.out.println("1. Add Todo 2. Delete Todo 3.Change Status in Todo's 4. View List 5. Completed List 6. Exit");
            System.out.println("===========================================================================================");
            System.out.print("Select the tab : ");
            choice = readInput.nextInt();
            switch (choice){
                case 1: addTodoList();
                        System.out.println("**************************** End ****************************");
                        break;
                case 2: deleteTodoList();
                        System.out.println("**************************** End ****************************");
                        break;
                case 3: completeTodoList();
                        System.out.println("**************************** End ****************************");
                        break;
                case 4: System.out.println(name + " Todo List");
                        displayTodoList();
                        System.out.println("**************************** End ****************************");
                        break;
                case 5: System.out.println("Completed Todo");
                        for (String completedList: todoListComplete)
                            System.out.println(completedList);
                        System.out.println("**************************** End ****************************");
                        break;
                case 6: System.out.println("Exit from Customer Todo List");
                        System.out.println("**************************** End ****************************");
                        break;
                default: System.out.println("Sorry, you have entered wrong option !!! Please enter the correct one :) ");
            }
        }while (choice != 6);
    }
}