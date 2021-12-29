package com.cota.after_corona_api.domain.todo.service;

import com.cota.after_corona_api.domain.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(String message, String description);

    List<TodoDto> getAll();
}
