package org.isep.cleancode;

import java.time.LocalDate;

public class Todo {

    // this Todo class should be completed to achieve Step 1

    private String name;
    private LocalDate dueDate;

    public Todo(String name, LocalDate dueDate) {
        setName(name);
        setDueDate(dueDate);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
