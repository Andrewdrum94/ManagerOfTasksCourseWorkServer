package ru.netology.javacore;

import java.util.Stack;

public class StackOfRequests {

    private static Stack<RequestDto> requests = new Stack<>();

    public static void saveRequest(RequestDto dto) {
        requests.push(dto);
    }

    public static void restoreDto(Todos todos) {
        if (!(requests.isEmpty())) {
            RequestDto dto = requests.pop();
            if (dto.getType().equals("ADD")) todos.removeTask(dto.getTask());
            if (dto.getType().equals("REMOVE")) todos.addTask(dto.getTask());
        }
    }
}
