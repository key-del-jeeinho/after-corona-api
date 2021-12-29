package com.cota.after_corona_api.domain.todo.request;

public record AddTodoRequest(
        String title,
        String description
) {
}
