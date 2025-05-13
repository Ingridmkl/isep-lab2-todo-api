package org.isep.cleancode.presentation;

import com.google.gson.*;
import org.isep.cleancode.Todo;
import org.isep.cleancode.application.TodoManager;
import org.isep.cleancode.application.ITodoRepository;
import org.isep.cleancode.persistence.TodoRepository;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class TodoController {

    // this Todo class should be completed to achieve Step 1

    // private static final Gson gson = new Gson();
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
                                             JsonDeserializationContext context) throws JsonParseException {
                    return LocalDate.parse(json.getAsString());
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate src, java.lang.reflect.Type typeOfSrc,
                                             JsonSerializationContext context) {
                    return new JsonPrimitive(src.toString()); // Format: "yyyy-MM-dd"
                }
            })
            .create();

    private final TodoManager manager;

    public TodoController(ITodoRepository repository) {
        this.manager = new TodoManager(repository);
    }

    public Object getAllTodos(Request req, Response res) {
        res.type("application/json");

        return gson.toJson(manager.getAllTodos());
    }

    public Object createTodo(Request req, Response res) {
        res.type("application/json");

        try {
            Todo newTodo = gson.fromJson(req.body(), Todo.class);
            Todo createTodo = manager.createTodo(newTodo);
            res.status(201);
            return gson.toJson(createTodo);
        } catch (IllegalArgumentException e) {
            res.status(400);
            return gson.toJson(e.getMessage());
        }
    }
}
