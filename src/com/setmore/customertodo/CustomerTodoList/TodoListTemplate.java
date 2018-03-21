package com.setmore.customertodo.CustomerTodoList;

public class TodoListTemplate {
    public final static String completed = "COMPLETED";
    public final static String unCompleted = "NOTCOMPLETED";

    String todoListName;
    String status;

    public TodoListTemplate(){}

    public TodoListTemplate(String todoListName, String status) {
        this.todoListName = todoListName;
        this.status = status;
    }
}