package com.cota.after_corona_api.domain.todo.repository;

import com.cota.after_corona_api.domain.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
