package org.isep.cleancode.application;

import org.isep.cleancode.Todo;
import org.isep.cleancode.persistence.TodoRepository;

import java.util.List;

public class TodoManager {

    private final ITodoRepository repository;

    public TodoManager(ITodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        return repository.getAllTodos();
    }

    public Todo createTodo(Todo newTodo) {
        if (repository.existsByName(newTodo.getName())) {
            throw new IllegalArgumentException("Todo name must be unique.");
        }
        repository.addTodo(newTodo);
        return newTodo;
    }


}
