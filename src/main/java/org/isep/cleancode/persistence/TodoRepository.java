package org.isep.cleancode.persistence;

import org.isep.cleancode.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> getAllTodos() {
        return todos;
    }

    public void addTodo(Todo newTodo) {
        todos.add(newTodo);
    }

    public boolean existsByName(String name) {
        return todos.stream().anyMatch(todo -> todo.getName().equalsIgnoreCase(name));
    }
}
