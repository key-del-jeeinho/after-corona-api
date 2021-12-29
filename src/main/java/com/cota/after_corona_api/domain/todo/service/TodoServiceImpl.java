package com.cota.after_corona_api.domain.todo.service;

import com.cota.after_corona_api.domain.todo.dto.TodoDto;
import com.cota.after_corona_api.domain.todo.entity.TodoEntity;
import com.cota.after_corona_api.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository repository;

    @Override
    public TodoDto addTodo(String message, String description) {
        TodoEntity entity = repository.save(new TodoEntity(message, description));
        return new TodoDto(entity.getMessage(), entity.getDescription());
    }

    @Override
    public List<TodoDto> getAll() {
        return repository.findAll().stream().map(entity -> new TodoDto(entity.getMessage(), entity.getDescription())).collect(Collectors.toList());
    }
}
