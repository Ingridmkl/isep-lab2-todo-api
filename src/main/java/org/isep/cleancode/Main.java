package org.isep.cleancode;

import static spark.Spark.*;

import org.isep.cleancode.application.ITodoRepository;
import org.isep.cleancode.persistence.TodoRepository;
import org.isep.cleancode.presentation.TodoController;

public class Main {
    // private static final TodoController todoController = new TodoController();

    public static void main(String[] args) {
        ITodoRepository repository = new TodoRepository();
        TodoController todoController = new TodoController(repository);

        port(4567);

        get("/todos", todoController::getAllTodos);

        post("/todos", todoController::createTodo);
    }
}

