package com.cota.after_corona_api.domain.todo.controller;

import com.cota.after_corona_api.domain.todo.dto.TodoDto;
import com.cota.after_corona_api.domain.todo.request.AddTodoRequest;
import com.cota.after_corona_api.domain.todo.response.AddTodoResponse;
import com.cota.after_corona_api.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todo-api")
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<AddTodoResponse> addTodo(@RequestBody AddTodoRequest request) {
        return ResponseEntity.ok(new AddTodoResponse(
                todoService.addTodo(request.title(), request.description())
                        .message()));
    }

    @GetMapping("/todo")
    public ResponseEntity<List<TodoDto>> getAllTodo() {
        return ResponseEntity.ok(todoService.getAll());
    }
}
