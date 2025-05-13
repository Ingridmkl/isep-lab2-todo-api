package org.isep.cleancode;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

public class TodoController {

    // this Todo class should be completed to achieve Step 1

    private static final Gson gson = new Gson();
    private final List<Todo> todos = new ArrayList<>();

    public Object getAllTodos(Request req, Response res) {
        res.type("application/json");

        return gson.toJson(todos);
    }

    public Object createTodo(Request req, Response res) {
        res.type("application/json");

        try {
            Todo newTodo = gson.fromJson(req.body(), Todo.class);

            for (Todo todo : todos) {
                if (todo.getName().equalsIgnoreCase(newTodo.getName())) {
                    res.status(400); // Returns 400 if the business rules are not respected
                    return gson.toJson("Todo name must be unique.");
                }
            }

            todos.add(newTodo);
            res.status(201); // Returns 201 if ok
            return gson.toJson(newTodo);

        } catch (IllegalArgumentException e) {
            res.status(400);
            return gson.toJson(e.getMessage());
        }
    }
}
